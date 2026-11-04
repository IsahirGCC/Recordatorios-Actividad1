package com.isahir.recordatorios

import com.isahir.recordatorios.data.DatosSimulados
import com.isahir.recordatorios.model.Categoria
import com.isahir.recordatorios.model.Estado
import com.isahir.recordatorios.model.Prioridad
import com.isahir.recordatorios.model.Recordatorio
import org.junit.Assert.assertEquals
import org.junit.Test

class RecordatoriosTest {

    @Test(expected = IllegalArgumentException::class)
    fun tituloVacioEsRechazado() {
        Recordatorio(1, " ", Categoria.Hogar, Prioridad.Baja)
    }

    @Test
    fun filtrosYSet() {
        assertEquals(3, DatosSimulados.porEstado(Estado.Pendiente).size)
        assertEquals(2, DatosSimulados.porPrioridad(Prioridad.Alta).size)
        assertEquals(4, DatosSimulados.categorias.size)
    }
}
