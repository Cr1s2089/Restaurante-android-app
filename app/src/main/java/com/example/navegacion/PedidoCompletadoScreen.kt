package com.example.navegacion

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
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
import java.text.SimpleDateFormat
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PedidosCompletadosScreen(
    viewModel: PedidoViewModel,
    onBackPressed: () -> Unit,
    onNavigationToReports: () -> Unit
) {
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()
    val pedidosCompletados by viewModel.pedidosCompletados.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.fetchPedidosCompletados()
        viewModel.fetchPedidosPagados()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Pedidos Completados") },
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
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            errorMessage?.let {
                Text(text = it, color = Color.Red, modifier = Modifier.padding(bottom = 8.dp))
            }
            if (isLoading) {
                LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(16.dp))
            }
            if (pedidosCompletados.isEmpty() && !isLoading) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("No hay pedidos completados", fontSize = 18.sp)
                }
            } else {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    items(pedidosCompletados) { pedido ->
                        CompletedOrderCard(
                            pedido = pedido,
                            onMarkAsPaid = { id ->
                                viewModel.marcarPedidoComoPagado(id)
                                onNavigationToReports()
                            }
                        )
                    }
                }
            }
        }
    }
}
@Composable
fun CompletedOrderCard(pedido: PedidoResponse, onMarkAsPaid:(Int)->Unit
) {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    val outputFormat = SimpleDateFormat("HH:mm:ss dd/MM/yyyy", Locale.getDefault())

    val formattedDate = pedido.fecha_hora.let {
        try {
            outputFormat.format(inputFormat.parse(it))
        } catch (e: Exception) {
            "Fecha no disponible"
        }
    }

    val total = pedido.detalles?.sumOf { it.precio_unitario * it.cantidad } ?: 0.0

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Pedido #${pedido.id.toString().takeLast(6) ?: "N/A"}",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(text = formattedDate, color = Color.Gray)
            }

            Divider(modifier = Modifier.padding(vertical = 8.dp))

            if (!pedido.detalles.isNullOrEmpty()) {
                pedido.detalles.forEach { detalle ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "${detalle.producto_nombre} x${detalle.cantidad}", color = Color.Black)
                        Text(text = "Bs ${detalle.precio_unitario}", color = Color.Black)
                    }
                }
            } else {
                Text("No hay productos en este pedido", color = Color.Black)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = { onMarkAsPaid(pedido.id) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF4CAF50),
                        contentColor = Color.White
                    ),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Marcar como pagado")
                }

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "Total: Bs $total",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF4CAF50)
                )
            }
        }
    }
}