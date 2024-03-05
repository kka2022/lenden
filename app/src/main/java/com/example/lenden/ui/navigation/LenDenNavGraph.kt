package com.example.lenden.ui.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.lenden.R
import com.example.lenden.ui.components.AddDialog
import com.example.lenden.ui.components.FloatingAddButton
import com.example.lenden.ui.components.LenDenTopAppBar
import com.example.lenden.ui.screens.DetailScreen
import com.example.lenden.ui.screens.HomeScreen
import com.example.lenden.ui.screens.PersonViewModel
import com.example.lenden.ui.screens.SplashScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LenDenNavGraph(navController: NavHostController = rememberNavController()) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination?.route

    val personViewModel = viewModel<PersonViewModel>(factory = PersonViewModel.Factory)
    val allPersons = personViewModel.personsList.collectAsState().value

    Scaffold(
        topBar = {
            LenDenTopAppBar(
                title = stringResource(id = R.string.app_name),
                onBackClick = {
                    navController.navigateUp()
                },
                isBackButtonVisible = currentDestination != AppScreens.Home.name && currentDestination != AppScreens.Splash.name
            )
        },
        floatingActionButton = {
            if (currentDestination == AppScreens.Home.name) {
                FloatingAddButton(onClick = {
                    navController.navigate(AppScreens.AddDialog.name)
                })
            }
        },
        containerColor = MaterialTheme.colorScheme.primaryContainer
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = AppScreens.Splash.name,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(route = AppScreens.Splash.name,
                exitTransition = {
                    return@composable fadeOut(tween(700))
                }

            ) {
                SplashScreen(
                    navController = navController,
                )
            }
            composable(route = AppScreens.Home.name) {
                HomeScreen(
                    goToDetails = {
                        navController.navigate(route = AppScreens.Details.name + "/$it")
                        personViewModel.findPersonById(it)
                    },
                    personsList = allPersons,
                    deleteAccount = {
                        personViewModel.deletePerson(it)
                    }
                )
            }
            composable(route = AppScreens.Details.name + "/{personId}", arguments = listOf(
                navArgument("personId") { type = NavType.StringType }
            )) { backStackEntry ->
                backStackEntry.arguments?.getString("personId")?.let { personId ->
                    DetailScreen(
                        person = personViewModel.singlePerson.value
                    )
                }
            }
            dialog(route = AppScreens.AddDialog.name) {
                AddDialog(
                    addDialogNameText = personViewModel.addDialogName.value,
                    addDialogAmountText = personViewModel.addDialogAmount.value,
                    onAddDialogNameChange = { personViewModel.changeAddDialogName(it) },
                    onAddDialogAmountChange = { personViewModel.changeAddDialogAmount(it) },
                    onAddButtonClick = {
                        personViewModel.insertPerson(it)
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}

enum class AppScreens {
    Home,
    Splash,
    Details,
    AddDialog
}

