package com.isahir.recordatorios.data

import androidx.compose.ui.graphics.Color
import com.isahir.recordatorios.model.Categoria
import com.isahir.recordatorios.model.Estado
import com.isahir.recordatorios.model.Prioridad
import com.isahir.recordatorios.model.Recordatorio

object DatosSimulados {

    // List: recordatorios simulados
    val recordatorios: List<Recordatorio> = listOf(
        Recordatorio(1, "Entregar informe", Categoria.Trabajo, Prioridad.Alta, descripcion = "Enviar antes del viernes"),
        Recordatorio(2, "Estudiar Kotlin", Categoria.Estudio, Prioridad.Media),
        Recordatorio(3, "Control médico", Categoria.Salud, Prioridad.Alta),
        Recordatorio(4, "Pagar cuenta de luz", Categoria.Hogar, Prioridad.Media, Estado.Completado),
        Recordatorio(5, "Reunión de equipo", Categoria.Trabajo, Prioridad.Baja, Estado.Completado),
    )

    // Set: categorías sin repetir
    val categorias: Set<Categoria> = recordatorios.map { it.categoria }.toSet()

    // Map: color de cada categoría
    val colores: Map<Categoria, Color> = mapOf(
        Categoria.Trabajo to Color(0xFF1E88E5),
        Categoria.Estudio to Color(0xFF8E24AA),
        Categoria.Salud to Color(0xFF43A047),
        Categoria.Hogar to Color(0xFFFB8C00),
    )

    fun porEstado(estado: Estado) = recordatorios.filter { it.estado == estado }
    fun porPrioridad(prioridad: Prioridad) = recordatorios.filter { it.prioridad == prioridad }
}
