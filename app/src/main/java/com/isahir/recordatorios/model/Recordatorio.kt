package com.isahir.recordatorios.model

sealed class Categoria(val nombre: String) {
    data object Trabajo : Categoria("Trabajo")
    data object Estudio : Categoria("Estudio")
    data object Salud : Categoria("Salud")
    data object Hogar : Categoria("Hogar")
}

sealed class Prioridad(val nombre: String) {
    data object Alta : Prioridad("Alta")
    data object Media : Prioridad("Media")
    data object Baja : Prioridad("Baja")
}

sealed class Estado(val nombre: String) {
    data object Pendiente : Estado("Pendiente")
    data object Completado : Estado("Completado")
}

data class Recordatorio(
    val id: Int,
    val titulo: String,
    val categoria: Categoria,
    val prioridad: Prioridad,
    val estado: Estado = Estado.Pendiente,
    val descripcion: String? = null,
) {
    init {
        require(id > 0) { "El id debe ser positivo" }
        require(titulo.isNotBlank()) { "El título no puede estar vacío" }
    }
}
