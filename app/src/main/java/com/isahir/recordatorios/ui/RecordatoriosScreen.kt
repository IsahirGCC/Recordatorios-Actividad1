package com.isahir.recordatorios.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.isahir.recordatorios.data.DatosSimulados
import com.isahir.recordatorios.model.Estado
import com.isahir.recordatorios.model.Prioridad
import com.isahir.recordatorios.model.Recordatorio
import com.isahir.recordatorios.ui.theme.RecordatoriosTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecordatoriosScreen() {
    val pendientes = DatosSimulados.porEstado(Estado.Pendiente).size
    val altas = DatosSimulados.porPrioridad(Prioridad.Alta).size

    Scaffold(topBar = { TopAppBar(title = { Text("Recordatorios") }) }) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            item {
                Text("Pendientes: $pendientes · Prioridad alta: $altas · Categorías: ${DatosSimulados.categorias.size}")
            }
            items(DatosSimulados.recordatorios) { TarjetaRecordatorio(it) }
        }
    }
}

@Composable
fun TarjetaRecordatorio(r: Recordatorio) {
    Card(Modifier.fillMaxWidth()) {
        Column(Modifier.padding(12.dp)) {
            Text(r.titulo, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            r.descripcion?.let { Text(it, style = MaterialTheme.typography.bodySmall) }
            Text("Categoría: ${r.categoria.nombre}", color = DatosSimulados.colores.getValue(r.categoria))
            Text("Prioridad: ${r.prioridad.nombre}")
            Text("Estado: ${r.estado.nombre}")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RecordatoriosPreview() {
    RecordatoriosTheme(dynamicColor = false) { RecordatoriosScreen() }
}
