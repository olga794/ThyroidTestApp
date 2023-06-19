package com.project.thyroidtestapp.thyroidTestApp.ui.login


import android.app.Activity
import android.telephony.SignalStrengthUpdateRequest
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.runtime.*
import androidx.compose.material.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.TextStyle
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.thyroidtestapp.R
import com.project.thyroidtestapp.thyroidTestApp.ui.intro.FondoIntro

//onUpClick: ()-> Unit


@Composable
fun LoginScreen(loginViewModel: LoginViewModel) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(2.dp)


    ) {
        FondoIntro()
        Header(Modifier.align(Alignment.TopEnd))
        Body(Modifier.align(Alignment.Center), loginViewModel)
        Footer(Modifier.align(Alignment.BottomCenter))
    }
}


@Composable
fun Body(modifier: Modifier, loginViewModel: LoginViewModel) {
    val email:String by loginViewModel.email.observeAsState(initial = "")
    val password:String by loginViewModel.password.observeAsState(initial = "")
    val isLoginEnable:Boolean by loginViewModel.isLoginEnable.observeAsState(initial =  false)


    Column(modifier = modifier.padding( 40.dp)) {
        Row(modifier = modifier.padding( 1.dp)) {
            LogoCinta()
            TituloApp("THYROID TEST")
        }
        Spacer(modifier = Modifier.size(10.dp))
        Email(email) {
            loginViewModel.onLoginChanged(email = it, password = password)
        }
        Spacer(modifier = Modifier.size(4.dp))
        Password(password) {
            loginViewModel.onLoginChanged(email = email, password = it)
        }
        Spacer(modifier = Modifier.size(8.dp))
        ForgotPassword(Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.size(16.dp))
        LoginButton(isLoginEnable)
        Spacer(modifier = Modifier.size(16.dp))
        LoginDivider()
        Spacer(modifier = Modifier.size(32.dp))
        SocialLogin()

    }
}

@Composable
fun SocialLogin() {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_cinta),
            contentDescription = "Social login fb",
            modifier = Modifier.size(16.dp)
        )
        Text(
            text = "olga",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 8.dp),
            color = Color(0xFF4EA8E9)
        )
    }
}

@Composable
fun LoginDivider() {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

//        Divider(
//            Modifier
//                .background(Color(0xFFF9F9F9))
//                .height(1.dp)
//                .weight(1f)
//        )
        Text(
            text = "OR",
            modifier = Modifier.padding(horizontal = 18.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFB5B5B5)
        )
//        Divider(
//            Modifier
//                .background(Color(0xFFF9F9F9))
//                .height(1.dp)
//                .weight(1f)
//        )
    }
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

        Text(text = "INGRESAR",style = TextStyle(
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
fun Password(password: String, onTextChanged: (String) -> Unit) {
    var passwordVisibility by remember { mutableStateOf(false) }
    //TextFieldValue
//    TextField(
//        value = password,
//        onValueChange = { onTextChanged(it) },
//        modifier = Modifier.fillMaxWidth(),
//        placeholder = { Text("Password") },
////        colors = TextFieldDefaults.textFieldColors(
////            textColor = Color(0xFFB2B2B2),
////            backgroundColor = Color(0xFFFAFAFA),
////            focusedIndicatorColor = Color.Transparent,
////            unfocusedIndicatorColor = Color.Transparent
////        ),
//        singleLine = true,
//        maxLines = 1,
//        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
//        trailingIcon = {
//            val imagen = if (passwordVisibility) {
//                Icons.Filled.VisibilityOff
//            } else {
//                Icons.Filled.Visibility
//            }
//            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
//                Icon(imageVector = imagen, contentDescription = "show password")
//            }
//        },
//        visualTransformation = if (passwordVisibility) {
//            VisualTransformation.None
//        } else {
//            PasswordVisualTransformation()
//        }
//    )
}

@Composable
fun Email(email: String, onTextChanged: (String) -> Unit) {

//    TextField(
//        value = email,
//        onValueChange = { onTextChanged(it) },
//        modifier = Modifier.fillMaxWidth(),
//        placeholder = { Text(text = "Email") },
//        maxLines = 1,
//        singleLine = true,
//        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
////        //colors = TextFieldDefaults.textFieldColors(
////            textColor = Color(0xFFB2B2B2),
////            backgroundColor = Color(0xFFFAFAFA),
////            focusedIndicatorColor = Color.Transparent,
////            unfocusedIndicatorColor = Color.Transparent
////        )
//    )
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
        //EchoApp("Elaborado: por @OLF ")
        SignUp()
        Spacer(modifier = Modifier.size(2.dp))
    }
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        text = "¿Ha olvidado su contraseña?",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF000000),
        modifier = modifier
    )
}

@Composable
fun SignUp() {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(
            text = "¿No tines Una Cuenta?", fontSize = 12.sp, color = Color(0xFFB5B5B5)
        )
        Text(
            text = "Inscribirse.",
            Modifier.padding(horizontal = 8.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4EA8E9),
        )
    }
}

@Composable
fun Header(modifier: Modifier) {
    val activity = LocalContext.current as Activity
    Icon(
        imageVector = Icons.Rounded.Close,
        contentDescription = "cerrar app",
        modifier = modifier.clickable { activity.finish() })
}

//@Composable
//fun Divider(
//    modifier: Modifier = Modifier,
//    thickness: Dp = DividerDefaults.Thickness,
//    color: Color = DividerDefaults.color
//): Unit

