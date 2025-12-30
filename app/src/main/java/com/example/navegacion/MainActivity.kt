@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.navegacion

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.navegacion.data.api.responses.PedidoResponse
import com.example.navegacion.ui.theme.NavegacionTheme
import com.example.navegacion.ui.viewmodel.PedidoViewModel

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavegacionTheme {
                val navController = rememberNavController()
                val navigateActions = remember(navController) {
                    MyAppNavegationActions(navController)
                }
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val selectedDestination = navBackStackEntry?.destination?.route ?: MyAppRoute.MAIN_SCREEN

                val viewModel: PedidoViewModel = viewModel()
                val showTopBar = selectedDestination != MyAppRoute.MAIN_SCREEN && selectedDestination != "chef" && selectedDestination != "completados" &&
                        selectedDestination !="reportes" && selectedDestination !="mes/{month}" && selectedDestination !="dayDetail/{dayTitle}" && selectedDestination !="mes"

                // Controla la visibilidad de la bottom navigation
                val showBottomBar =false

                Column(modifier = Modifier.fillMaxSize()) {
                    if(showTopBar) {
                        MyAppTopNavigation(
                            selectedDestination = selectedDestination,
                            navigateTopLevelDestination = navigateActions::navigateTo
                        )
                    }

                    NavHost(
                        modifier = Modifier.weight(1f),
                        navController = navController,
                        startDestination = MyAppRoute.MAIN_SCREEN,

                        ) {
                        composable(MyAppRoute.MAIN_SCREEN) {
                            MainScreen(
                                onChefSelected = { navController.navigate("chef") },
                                onMeseroSelected = { navController.navigate(MyAppRoute.HAMBURGUESA) },
                                onPedidosCompletadoClick = { navController.navigate("completados") },
                                onReportes = { navController.navigate("reportes") }
                            )
                        }
                        composable(MyAppRoute.HAMBURGUESA) {
                            HamburquesaScreen(viewModel)
                        }
                        composable(MyAppRoute.SALCHICHA) {
                            SalchichaScreen(viewModel)
                        }
                        composable(MyAppRoute.ALITAS) {
                            AlitasScreen(viewModel)
                        }
                        composable("chef") {
                            ChefScreen(viewModel, navController)
                        }
                        composable("completados") {
                            PedidosCompletadosScreen(
                                viewModel = viewModel,
                                onBackPressed = { navController.popBackStack() },
                                onNavigationToReports = {
                                    // No necesitas navegar inmediatamente a reportes
                                    // Solo actualiza los datos
                                    viewModel.fetchPedidosPagados()
                                }
                            )
                        }

                        composable("reportes") {
                            ReporteScreen(
                                viewModel = viewModel,
                                onNavigateToMonth = { mes, pedidos ->
                                    viewModel.setPedidosDelMes(mes, pedidos)
                                    navController.navigate("mes")
                                },
                            )
                        }

                        composable("dayDetail/{dayTitle}") { backStackEntry ->
                            val dayTitle = backStackEntry.arguments?.getString("dayTitle") ?: ""
                            val pedidos = backStackEntry.savedStateHandle.get<List<PedidoResponse>>("pedidos") ?: emptyList()

                            DiaDetalleScreen(
                                dayTitle = dayTitle,
                                pedidos = pedidos,
                                onBackPressed = { navController.popBackStack() }
                            )
                        }

                        composable("mes") {
                            // Obtener datos del ViewModel
                            val mesSeleccionado = viewModel.mesSeleccionado.value
                            val pedidosDelMes = viewModel.pedidosDelMes.value

                            MesScreen(
                                monthName = mesSeleccionado,
                                pedidos = pedidosDelMes,
                                onBack = { navController.popBackStack() }
                            )
                        }
                    }

                    // BottomNavigation condicional
                    if (showBottomBar) {
                        MyAppBottomNavigation(
                            selectedDestination = selectedDestination,
                            navigateTopLevelDestination = navigateActions::navigateTo
                        )
                    }
                }
            }
        }
    }
}
@Composable
fun MyAppTopNavigation(
    selectedDestination: String,
    navigateTopLevelDestination: (MyAppTopLevelDestination) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp), // Altura estándar para una barra superior
        color = Color(0xFFEBCB1C) // Color de fondo
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly // Distribuye los íconos uniformemente
        ) {
            TOP_LEVEL_DETINATIONS.forEach { destination ->
                IconButton(
                    onClick = { navigateTopLevelDestination(destination) },
                    modifier = Modifier.weight(1f) // Cada ícono ocupa el mismo espacio
                ) {
                    Icon(
                        imageVector = destination.selectedIcon,
                        contentDescription = stringResource(id = destination.iconTextId),
                        tint = if (selectedDestination == destination.route) Color.Red else Color.White // Cambia el color según la selección
                    )
                }
            }
        }
    }
}
@Composable
fun MyAppBottomNavigation(
    selectedDestination: String,
    navigateTopLevelDestination: (MyAppTopLevelDestination) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        color = Color(0xFFEBCB1C)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TOP_LEVEL_DETINATIONS.forEach { destination ->
                IconButton(
                    onClick = { navigateTopLevelDestination(destination) },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = destination.selectedIcon,
                        contentDescription = stringResource(id = destination.iconTextId),
                        tint = if (selectedDestination == destination.route) Color.Red else Color.White
                    )
                }
            }
        }
    }
}