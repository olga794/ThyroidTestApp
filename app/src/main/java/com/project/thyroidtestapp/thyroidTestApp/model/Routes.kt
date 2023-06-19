package com.project.thyroidtestapp.thyroidTestApp.model


import androidx.navigation.NavType
import androidx.navigation.navArgument
import java.sql.RowId

sealed class Routes(
    val ruta: String,
    val navArgs: List<NavArg> = emptyList()
) {
    val rutaRequerida = run{
        // routes/{arg1}/{arg2}
        val argKeys = navArgs.map{"{${it.key}}"}
        listOf(ruta)
            .plus(argKeys)
            .joinToString("/")
    }
    var rutaSinArg = run{
        // "routes?arg1={mediaId}"
    }
    val argumentos = navArgs.map {
        navArgument(it.key){ type =it.navType}
    }

    // objetos de ruta

    object Introduccion:Routes("intro")
    object Login:Routes("login")
    object Detail: Routes("detail", listOf(NavArg.MediaId)){
        fun crearRuta(mediaId: Int) ="$ruta/$mediaId"
    }

}
enum class NavArg(val key: String, val navType: NavType<*>){
   MediaId("mediaId", NavType.IntType)

}