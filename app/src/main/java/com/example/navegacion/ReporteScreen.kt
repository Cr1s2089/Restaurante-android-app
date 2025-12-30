package com.example.navegacion

import android.icu.text.SimpleDateFormat
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navegacion.data.api.responses.PedidoResponse
import com.example.navegacion.ui.viewmodel.PedidoViewModel
import java.time.LocalDate
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ReporteScreen(
    viewModel: PedidoViewModel,
    onNavigateToDay: (String, List<PedidoResponse>) -> Unit = { _, _ -> },
    onNavigateToMonth: (String, Any?) -> Unit // Cambiado: solo recibe el nombre del mes
) {
    val pedidosPagados by viewModel.pedidosPagados.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.fetchPedidosPagados()
    }

    // SOLO usar el año actual
    val currentYear = LocalDate.now().year

    // Filtramos solo los pedidos del año actual
    val pedidosFiltrados = pedidosPagados.filter {
        try {
            val date = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(it.fecha_hora)
            date.year + 1900 == currentYear
        } catch (e: Exception) {
            false
        }
    }

    val pedidosPorMes = pedidosFiltrados.groupBy { pedido ->
        try {
            val date = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(pedido.fecha_hora)
            SimpleDateFormat("MMMM", Locale.getDefault()).format(date)
        } catch (e: Exception) {
            "Fecha inválida"
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("Reportes ")
                        Text(
                            text = currentYear.toString(),
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFEBCB1C),
                    titleContentColor = Color.White
                )
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            if (pedidosPagados.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("No hay pedidos pagados registrados", fontSize = 18.sp)
                }
            } else if (pedidosFiltrados.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("No hay pedidos en el año actual", fontSize = 18.sp)
                }
            } else {
                LazyColumn {
                    pedidosPorMes.forEach { (mes, pedidosDelMes) ->
                        item {
                            // Ahora MonthHeader es clickeable
                            MonthHeader(
                                mes = mes,
                                pedidos = pedidosDelMes,
                                onClick = { onNavigateToMonth(mes,pedidosDelMes)}
                            )
                        }

                        // Agrupar por día dentro del mes
                        val pedidosPorDia = pedidosDelMes.groupBy { pedido ->
                            try {
                                val date = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(pedido.fecha_hora)
                                SimpleDateFormat("dd 'de' MMMM", Locale.getDefault()).format(date)
                            } catch (e: Exception) {
                                "Fecha inválida"
                            }
                        }

                        pedidosPorDia.forEach { (dia, pedidosDelDia) ->
                            item {
                                DayCard(
                                    dayTitle = dia,
                                    pedidos = pedidosDelDia
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun MonthHeader(
    mes: String,
    pedidos: List<PedidoResponse>,
    onClick: () -> Unit // Agregamos onClick
) {
    val totalMes = pedidos.sumOf { it.total }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable(onClick = onClick), // Hacemos clickeable
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFEBCB1C)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = mes.replaceFirstChar { it.titlecase() },
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFF5F5F5)
                )
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Ver detalles",
                    tint = Color.White,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            Text(
                text = "Bs ${"%.2f".format(totalMes)}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFF5F5F5)
            )
        }
    }
}

@Composable
private fun DayCard(
    dayTitle: String,
    pedidos: List<PedidoResponse>
) {
    val totalDia = pedidos.sumOf { it.total }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = dayTitle,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "${pedidos.size} pedidos",
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Total del día: Bs ${"%.2f".format(totalDia)}",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4CAF50)
            )
        }
    }
}
// ELIMINAMOS COMPLETAMENTE la función YearSelector