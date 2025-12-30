package com.example.navegacion

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.navegacion.data.api.responses.PedidoResponse
import java.text.SimpleDateFormat
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiaDetalleScreen(
    dayTitle: String,
    pedidos: List<PedidoResponse>,
    onBackPressed: () -> Unit
) {
    val totalDia = remember(pedidos) {
        pedidos.sumOf { it.detalles?.sumOf { it.precio_unitario * it.cantidad } ?: 0.0 }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(dayTitle) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFEBCB1C),
                    titleContentColor = Color.White
                ),
                navigationIcon = {
                    IconButton(onClick = onBackPressed) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            LazyColumn {
                items(pedidos) { pedido ->
                    PaidOrderCard(pedido = pedido)
                }

                item {
                    DayTotalCard(total = totalDia)
                }
            }
        }
    }
}

@Composable
fun PaidOrderCard(pedido: PedidoResponse) {
    val formattedTime = try {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val outputFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        outputFormat.format(inputFormat.parse(pedido.fecha_hora))
    } catch (e: Exception) {
        pedido.fecha_hora
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Pedido #${pedido.id}",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = formattedTime,
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "Total: Bs ${"%.2f".format(pedido.total)}",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF4CAF50)
                )
            }
        }
    }
}

@Composable
fun DayTotalCard(total: Double) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFEBCB1C).copy(alpha = 0.2f)
        )
    ) {
        Text(
            text = "TOTAL DEL DÍA: Bs ${"%.2f".format(total)}",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color(0xFFEBCB1C)
        )
    }
}