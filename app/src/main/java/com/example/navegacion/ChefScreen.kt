package com.example.navegacion

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.navegacion.ui.viewmodel.PedidoViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.navegacion.data.api.responses.PedidoResponse
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat

import java.util.*


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChefScreen(viewModel: PedidoViewModel,navController: NavController) {
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()
    val pedidos by viewModel.pedidos.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.fetchPedidos()
        delay(10000)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Panel del Chef") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFEBCB1C),
                    titleContentColor = Color.White
                ),
                actions = {
                    IconButton(onClick = { viewModel.fetchPedidos() }) {
                        Icon(Icons.Default.Refresh, contentDescription = "Actualizar")
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

            if (pedidos.isEmpty() && !isLoading) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("No hay pedidos pendientes", fontSize = 18.sp)
                }
            } else {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    items(pedidos) { pedido ->
                        OrderCard(
                            pedido = pedido,
                            onDelete = { viewModel.deletePedido(pedido.id.toString()) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun OrderCard(
    pedido: PedidoResponse,
    onDelete: () -> Unit,
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

            Button(
                onClick = onDelete,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFEBCB1C),
                    contentColor = Color.White
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 4.dp,
                    pressedElevation = 8.dp
                )
            ) {
                Icon(Icons.Default.Check, contentDescription = null, modifier = Modifier.size(18.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text("Listo", fontWeight = FontWeight.Bold)
            }
        }
    }
}