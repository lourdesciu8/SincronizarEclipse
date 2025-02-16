package com.example.evaluable2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.evaluable2.databinding.ActivityMainBinding
import com.example.evaluable2.Adapter.ProductosAdapter
import com.example.tienda.SecondActivity
import com.example.tienda.model.Producto
import android.annotation.SuppressLint

// MainActivity: Pantalla principal que muestra las categorías y productos
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var productosAdapter: ProductosAdapter
    private val listaProductos = ArrayList<Producto>()
    private val carrito = ArrayList<Producto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.recyclerProductos.layoutManager = LinearLayoutManager(this)
        productosAdapter = ProductosAdapter(listaProductos) {
            producto -> agregarAlCarrito(producto) }
        binding.recyclerProductos.adapter = productosAdapter

        cargarCategorias()

        binding.spinnerCategorias.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val categoriaSeleccionada = parent?.getItemAtPosition(position).toString()

                cargarProductosPorCategoria(categoriaSeleccionada) // Pasamos directamente el slug(la categoría)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        cargarProductos()
    }

    private fun cargarCategorias() {
        val queue = Volley.newRequestQueue(this)
        val url = "https://dummyjson.com/products/categories"

        val request = JsonArrayRequest(Request.Method.GET, url, null, { response ->
            val categorias = ArrayList<String>()

            for (i in 0 .. response.length()-1) {
                val item = response.getJSONObject(i) // Obtener objeto JSON individual
                val slug = item.getString("slug")   // Extraer solo el slug
                categorias.add(slug)                // Agregar el slug a la lista
            }

            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, categorias)
            binding.spinnerCategorias.adapter = adapter

        }, { Log.v("categorias", it.toString())})
        queue.add(request)
    }


    private fun cargarProductosPorCategoria(categoria: String) {
        val queue = Volley.newRequestQueue(this)
        val url = "https://dummyjson.com/products/category/$categoria"

        val request = JsonObjectRequest(Request.Method.GET, url, null, { response ->
            val productosArray = response.getJSONArray("products")
            listaProductos.clear()

            for (i in 0 .. productosArray.length()-1) {
                val item = productosArray.getJSONObject(i)
                val producto = Producto(
                    item.getInt("id"),
                    item.getString("title"),
                    item.getDouble("price"),
                    item.getString("thumbnail")
                )
                listaProductos.add(producto)
            }

            println("Productos cargados correctamente: ${listaProductos.size}")
            productosAdapter.notifyDataSetChanged()
        }, { Log.v("productosCategoria", it.toString()) })
        queue.add(request)
    }


    @SuppressLint("NotifyDataSetChanged")
    private fun cargarProductos() {
        val queue = Volley.newRequestQueue(this)
        val url = "https://dummyjson.com/products"

        val request = JsonObjectRequest(Request.Method.GET, url, null, { response ->
            val productosArray = response.getJSONArray("products")
            for (i in 0 .. productosArray.length()-1) {
                val item = productosArray.getJSONObject(i)
                val producto = Producto(
                    item.getInt("id"),
                    item.getString("title"),
                    item.getDouble("price"),
                    item.getString("thumbnail")
                )
                listaProductos.add(producto)
            }
            productosAdapter.notifyDataSetChanged()
        }, { Log.v("productos", it.toString())})
        queue.add(request)
    }

    private fun agregarAlCarrito(producto: Producto) {
        carrito.add(producto)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuCarrito -> {

                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("carrito", ArrayList(carrito))
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
