package com.example.navegacion

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import com.example.navegacion.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton

import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.foundation.shape.CircleShape



import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.filled.Check


@Composable
fun MainScreen(
    onChefSelected: () -> Unit,
    onMeseroSelected: () -> Unit,
    onPedidosCompletadoClick:()->Unit,
    onReportes:()->Unit

) {
    // Estado para controlar la visibilidad del menú de ajustes
    var showAjustesMenu by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.rodos2),
                    contentDescription = "Imagen desde recursos",
                    modifier = Modifier.size(150.dp),
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    UserCard("Chef", R.drawable.cocinero, onClick = onChefSelected)
                    UserCard("Mesero", R.drawable.mesero) { onMeseroSelected()}
                }

            }

            Spacer(modifier = Modifier.height(32.dp))

        }
        //#################################################
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Botón de ajustes izquierdo con menú
            Box {
                Card(
                    shape = CircleShape,
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFEBCB1C)),
                    modifier = Modifier.size(48.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    IconButton(
                        onClick = { showAjustesMenu = true },
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Ajustes"
                        )
                    }
                }

                DropdownMenu(
                    expanded = showAjustesMenu,
                    onDismissRequest = { showAjustesMenu = false }
                ) {
                    DropdownMenuItem(
                        text = { Text("Reportes") },
                        onClick = {
                            showAjustesMenu = false
                            onReportes()
                        }
                    )

                }
            }

            // Botón derecho (menú)
            Card(
                shape = CircleShape,
                colors = CardDefaults.cardColors(containerColor = Color(0xFFEBCB1C)),
                modifier = Modifier.size(48.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                IconButton(
                    onClick = onPedidosCompletadoClick,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Icon(
                        Icons.Filled.Check,
                        contentDescription = "Menú"
                    )
                }
            }
        }
    }
}

@Composable
fun UserCard(role: String, imageRes: Int,onClick:()->Unit) {
    Card(
        modifier = Modifier
            .size(120.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFEBCB1C))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = role,
                modifier = Modifier.size(64.dp)
            )
            Text(text = role, fontWeight = FontWeight.Bold)
        }
    }
}
