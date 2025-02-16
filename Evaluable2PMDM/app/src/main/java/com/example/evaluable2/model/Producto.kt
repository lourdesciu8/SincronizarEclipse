package com.example.tienda.model

import java.io.Serializable

// Modelo de datos para representar un producto
class Producto(val id: Int, val nombre: String, val precio: Double, val imagenUrl: String) : Serializable
