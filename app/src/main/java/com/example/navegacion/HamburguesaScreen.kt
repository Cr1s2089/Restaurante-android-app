package com.example.navegacion

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
fun HamburquesaScreen(viewModel: PedidoViewModel) {

    data class MenuItem(
        val id: Int,
        val name: String,
        val price: Double,
        val imageRes: Int
    )

    val burgers = listOf(
        MenuItem(46, "CLASICA", 19.0, R.drawable.hamburguesaclasica),
        MenuItem(47, "QUESO", 22.0, R.drawable.hamburguesaqueso),
        MenuItem(48, "HAWAIANA", 22.0, R.drawable.hamburguesahawaiana),
        MenuItem(49, "ROYAL", 30.0, R.drawable.hamburguesaroyal)
    )

    Column(modifier = Modifier.padding(16.dp)) {
        Text("HAMBURGUESAS", fontSize = 22.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(burgers) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            viewModel.addProduct(item.id, item.name, item.price)
                        },
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.elevatedCardElevation(4.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = item.name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.height(4.dp))
                            // Si querés agregar ingredientes, podés hacerlo como otro campo
                            // Text(text = "Con papas y salsa", fontSize = 14.sp, color = Color.Gray)
                        }

                        Spacer(modifier = Modifier.width(16.dp))

                        Image(
                            painter = painterResource(id = item.imageRes),
                            contentDescription = item.name,
                            modifier = Modifier.size(80.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }

        OrderSummary(
            viewModel = viewModel,
            onSendOrder = {
                viewModel.sendOrder()
            }
        )
    }
}