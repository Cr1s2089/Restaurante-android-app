package com.example.navegacion.ui.components


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navegacion.ui.viewmodel.PedidoViewModel


@Composable
fun OrderSummary(
    viewModel: PedidoViewModel,
    modifier: Modifier = Modifier,
    onSendOrder: () -> Unit = {} // Nuevo parámetro para manejar el envío
) {
    val products by viewModel.selectedProducts.collectAsState()

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Título simplificado
            Text(
                text = "TU PEDIDO",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Lista de pedidos con scroll
            LazyColumn(
                modifier = Modifier.heightIn(max = 200.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(products.entries.toList()) { (id, producto) ->
                    OrderItem(
                        productName = producto.nombre,
                        quantity = producto.cantidad,
                        onRemoveOne = { viewModel.removeProduct(id) },
                        onRemoveAll = { viewModel.removeProductCompletely(id) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Botón para enviar pedido (verde)
            Button(
                onClick = onSendOrder,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFEBCB1C), // Verde
                    contentColor = Color.White
                ),
                enabled = products.isNotEmpty()
            ) {
                Text("ENVIAR PEDIDO", fontSize = 16.sp)
            }
        }
    }
}

@Composable
private fun OrderItem(
    productName: String,
    quantity: Int,
    onRemoveOne: () -> Unit,
    onRemoveAll: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "$productName x$quantity",
            fontSize = 16.sp,
            modifier = Modifier.weight(1f)
        )

        Row {
            IconButton(
                onClick = onRemoveOne,
                modifier = Modifier.size(24.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Quitar uno",
                    tint = Color.Red
                )
            }

            IconButton(
                onClick = onRemoveAll,
                modifier = Modifier.size(24.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Eliminar todo",
                    tint = Color.Red
                )
            }
        }
    }
}