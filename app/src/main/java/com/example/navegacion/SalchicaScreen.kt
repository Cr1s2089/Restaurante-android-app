package com.example.navegacion

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navegacion.ui.components.OrderSummary
import com.example.navegacion.ui.viewmodel.PedidoViewModel

@Composable
fun SalchichaScreen(viewModel: PedidoViewModel){
    data class ProductoUI(
        val id: Int,
        val nombre: String,
        val descripcion: String,
        val precio: Double,
        val imageRes: Int
    )
    val salchichaProducts = listOf(
        ProductoUI(54,"SALCHIPAPA", "Porción de salchipapa clásica",10.0, R.drawable.salchipapa),
        ProductoUI(54,"SALCHIPAPA", "Porción de salchipapa clásica",12.0, R.drawable.salchipapa),
        ProductoUI(54,"HOTDOG", "Porción de salchipapa clásica",10.0, R.drawable.hotdog),
        ProductoUI(53,"TEA-CONO", "Porción de papa, salchicha, fingers + salsas ",25.0, R.drawable.cono)
    )

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "SALCHIPAPAS Y HOTDOGS",
            fontSize = 22.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        // Lista desplazable de productos
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(salchichaProducts) { producto ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { viewModel.addProduct(producto.id, producto.nombre, producto.precio) },
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.elevatedCardElevation(4.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = producto.nombre,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = producto.descripcion,
                                fontSize = 14.sp,
                                color = Color.Gray
                            )
                        }

                        Spacer(modifier = Modifier.width(16.dp))

                        Image(
                            painter = painterResource(id = producto.imageRes),
                            contentDescription = producto.nombre,
                            modifier = Modifier.size(80.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }

        // Resumen del pedido
        OrderSummary(
            viewModel= viewModel,
            onSendOrder = {
                viewModel.sendOrder()
            })
    }
}