package com.project.thyroidtestapp

import android.content.ClipData.Item
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.project.thyroidtestapp.thyroidTestApp.model.NavArg
import com.project.thyroidtestapp.thyroidTestApp.model.Routes
import com.project.thyroidtestapp.thyroidTestApp.ui.intro.IntroScreen
import com.project.thyroidtestapp.thyroidTestApp.ui.intro.IntroViewModel
import com.project.thyroidtestapp.thyroidTestApp.ui.login.DetailScreen
import com.project.thyroidtestapp.thyroidTestApp.ui.login.LoginScreen
import com.project.thyroidtestapp.thyroidTestApp.ui.login.LoginViewModel

//const val INTRO =

@Composable
fun ThyroidTestNavHost(navController: NavHostController = rememberNavController()) {
       //NavHost(navController = navController, startDestination = Routes.Introduccion.rutaRequerida){
       NavHost(navController = navController, startDestination = Routes.Login.rutaRequerida){
        composable(Routes.Introduccion.rutaRequerida){
////            IntroScreen {
//                IntroViewModel(),
//                mediaItem ->
//                navController.navigate(Rutes.login.crearRuta(mediaItem.id))
//            }
            IntroScreen(introViewModel = IntroViewModel())

        }
           composable(Routes.Login.rutaRequerida){
               LoginScreen(loginViewModel = LoginViewModel())

           }

        composable(Routes.Detail.rutaRequerida,Routes.Detail.argumentos)
        { backStackEntry ->
            val id = backStackEntry.arguments?.getInt(NavArg.MediaId.key)
            requireNotNull(id, {"no puede ir nulo"})
            DetailScreen(mediaId = id)

            //DetailScren(mediaId = id, onUpClick ={navController.popBackStrack()})
            //PantallaScreen(IntroViewModel(), navController,id)

            //onclick:()->Unit pasar como parametro al clickable
            //.clickable(onClick = onclick)
            // para el antterior  onMediaClick: (MediaItem)-> Unit
            //onClick ={onMediaClick(it)},
            // para el sceen  onMediaClick: (MediaItem)-> Unit
            //onMediaClick = onMediaClick


        }
    }

}

private fun NavGraphBuilder.composable(
    navItem: Routes,
    content: @Composable (NavBackStackEntry) ->Unit) {

    composable(
        route = navItem.ruta,
        arguments = navItem.argumentos
    ){
        content(it)
    }
}

private inline fun <reified T> NavBackStackEntry.findArg(arg: NavArg): T {
    val value = arguments?.get(arg.key)
    requireNotNull(value)
    return value as T
}

