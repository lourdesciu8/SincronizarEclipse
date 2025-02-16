package com.example.tienda

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.evaluable2.R
import com.example.evaluable2.databinding.ActivitySecondBinding
import com.example.tienda.adapter.CarritoAdapter
import com.example.tienda.model.Producto
import com.google.android.material.snackbar.Snackbar


// SecondActivity: Pantalla que muestra el carrito y el total de la compra
class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private lateinit var carritoAdapter: CarritoAdapter
    private val carrito = ArrayList<Producto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        // Configuración del RecyclerView para mostrar el carrito
        binding.recyclerCarrito.layoutManager = LinearLayoutManager(this)
        carritoAdapter = CarritoAdapter(carrito)
        binding.recyclerCarrito.adapter = carritoAdapter

        // Recuperamos los productos del Intent
        if (intent.hasExtra("carrito")) {

                val productos = intent.getSerializableExtra("carrito") as? ArrayList<Producto>
                println("Productos recibidos en SecondActivity: $productos")

                if (!productos.isNullOrEmpty()) {
                    carrito.addAll(productos)
                    actualizarTotal()
                    carritoAdapter.notifyDataSetChanged()
                } else {
                    println("Error: el carrito recibido es nulo o vacío.")
                }

        }
    }

    private fun actualizarTotal() {
        val total = carrito.sumOf { it.precio }
        binding.textTotal.text = "Total: €" + String.format("%.2f", total)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.carrito_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuConfirmarCompra -> {
                if (carrito.isNotEmpty()) {
                    Snackbar.make(binding.root, "Enhorabuena, compra por valor de ${String.format("%.2f", carrito.sumOf { it.precio })} € realizada", Snackbar.LENGTH_LONG).show()
                    carrito.clear()
                    carritoAdapter.notifyDataSetChanged()
                    actualizarTotal()

                    // Notificar a MainActivity para vaciar el carrito
                    setResult(RESULT_OK)
                } else {
                    Snackbar.make(binding.root, "El carrito está vacío", Snackbar.LENGTH_SHORT).show()
                }
            }
            R.id.menuVaciarCarrito -> {
                if (carrito.isNotEmpty()) {
                    carrito.clear()
                    carritoAdapter.notifyDataSetChanged()
                    actualizarTotal()
                    Snackbar.make(binding.root, "Carrito vaciado", Snackbar.LENGTH_SHORT).show()

                    // Notificar a MainActivity para vaciar el carrito
                    setResult(RESULT_OK)
                } else {
                    Snackbar.make(binding.root, "El carrito ya está vacío", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
