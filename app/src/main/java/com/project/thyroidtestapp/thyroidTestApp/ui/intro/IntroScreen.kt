package com.project.thyroidtestapp.thyroidTestApp.ui.intro


import android.app.Activity
import android.media.browse.MediaBrowser.MediaItem
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.thyroidtestapp.R


@Composable
fun IntroScreen(introViewModel: IntroViewModel) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(2.dp)


    ) {
        FondoIntro()
        Header(Modifier.align(Alignment.TopEnd))
        Body(Modifier.align(Alignment.Center), introViewModel)
        Footer(Modifier.align(Alignment.BottomCenter))
    }
}



@Composable
fun Body(modifier: Modifier, introViewModel: IntroViewModel) {

    val isLoginEnable:Boolean by introViewModel.isLoginEnable.observeAsState(initial =  true)
    val isSingninEnable:Boolean by introViewModel.isLoginEnable.observeAsState(initial = true)

    Column(modifier = modifier.padding( 40.dp)) {
        Row(modifier = modifier.padding( 1.dp)) {
            LogoCinta()
            TituloApp("THYROID TEST")
        }
        Spacer(modifier = Modifier.size(10.dp))
        Bienvenida("Inicia sesión con tu cuenta de Thyroid Test para continuar.")
        Spacer(modifier = Modifier.size(20.dp))
        LoginButton(isLoginEnable)
        Spacer(modifier = Modifier.size(20.dp))
        SingninButton(isSingninEnable)
        Spacer(modifier = Modifier.size(16.dp))

    }
}

@Composable
fun Bienvenida(bienvenidaText: String) {
    Text(text = bienvenidaText,textAlign = TextAlign.Justify)
}

@Composable
fun LoginButton(loginEnable: Boolean) {
    Button(
        onClick = { },
        enabled = loginEnable,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF6751A3),
            disabledContainerColor = Color(0xFF999BBB),
            contentColor = Color.White,
            disabledContentColor = Color.White
        )
    ) {
        Icon(
            Icons.Default.Person,
            contentDescription = "login",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))

        Text(text = "INICIAR SESIÓN",style = TextStyle(
            color = Color(red = 255, green = 255, blue = 255, alpha = 255),
            fontFamily = FontFamily.SansSerif,
            fontSize = 20.0.sp,
            textAlign = TextAlign.Left,
            fontWeight = FontWeight(700.0.toInt()),
            fontStyle = FontStyle.Italic,
            shadow = Shadow(
                color = Color(
                    alpha = 63,
                    red = 0,
                    green = 0,
                    blue = 0
                ),
                offset = Offset(
                    x = 0.0f,
                    y = 4.0f
                ),
                blurRadius = 4.0f
            )


        ))

    }
}
//@Preview (showBackground = true , showSystemUi = true)

@Composable
fun SingninButton(SingninEnable: Boolean) {
    Button(
        onClick = { },
        enabled = SingninEnable,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF6751A3),
            disabledContainerColor = Color(0xFF999BBB),
            contentColor = Color.White,
            disabledContentColor = Color.White
        )
    ) {
        Icon(
            Icons.Default.AccountCircle,
            contentDescription = "cuenta",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))

        Text(text = "CREAR CUENTA",
            style = TextStyle(
            color = Color(red = 255, green = 255, blue = 255, alpha = 255),
            fontFamily = FontFamily.SansSerif,
            fontSize = 20.0.sp,
            textAlign = TextAlign.Left,
            fontWeight = FontWeight(700.0.toInt()),
            fontStyle = FontStyle.Italic,
            shadow = Shadow(
                color = Color(
                    alpha = 63,
                    red = 0,
                    green = 0,
                    blue = 0
                ),
                offset = Offset(
                    x = 0.0f,
                    y = 4.0f
                ),
                blurRadius = 4.0f
            )


        ))

    }
}

@Composable
fun TituloApp(tituloAppText: String) {
    Text(
        text = tituloAppText,
        style = TextStyle(
            color = Color(
                alpha = 255,
                red = 241,
                green = 81,
                blue = 127
            ),
            fontFamily = FontFamily.SansSerif,
            fontSize = 54.0.sp,
            textAlign = TextAlign.Right,
            fontWeight = FontWeight(600.0.toInt()),
            fontStyle = FontStyle.Italic,
            shadow = Shadow(
                color = Color(
                    alpha = 63,
                    red = 0,
                    green = 0,
                    blue = 0
                ),
                offset = Offset(
                    x = 0.0f,
                    y = 4.0f
                ),
                blurRadius = 4.0f
            )


        )

    )

}

@Composable
fun LogoCinta() {
    Image(
        painter = painterResource(id = R.drawable.logo_cinta),
        contentDescription = "logoCinta",
        alignment = Alignment.BottomEnd,
        modifier = Modifier
            .requiredWidth(84.0.dp)
            .requiredHeight(100.0.dp)
    )

}

@Composable
fun Footer(modifier: Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.size(10.dp))
        EchoApp("Elaborado: por @OLF ")
        Spacer(modifier = Modifier.size(2.dp))
    }
}


//@Preview (showBackground = true , showSystemUi = true)
@Composable
fun EchoApp(tituloEchoText: String) {
    Text(
        text = tituloEchoText,
        style = TextStyle(
            color = Color(
                alpha = 255,
                red = 0,
                green = 0,
                blue = 0
            ),
            fontFamily = FontFamily.Monospace,
            textAlign = TextAlign.Right,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Normal,
            shadow = Shadow(
                color = Color(
                    alpha = 63,
                    red = 0,
                    green = 0,
                    blue = 0
                ),
                offset = Offset(
                    x = 0.0f,
                    y = 4.0f
                ),
                blurRadius = 4.0f
            )


        )

    )

}
//@Preview(showBackground = true , showSystemUi = true)


@Composable
fun Header(modifier: Modifier) {
    val activity = LocalContext.current as Activity
    Icon(
        imageVector = Icons.Rounded.Close,
        contentDescription = "cerrar app",
        modifier = modifier.clickable { activity.finish() })
}

