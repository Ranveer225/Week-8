package edu.farmingdale.pizzapartybottomnavbar

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

// ToDo 1: The splash screen should have the image displayed in the center of the screen.

@Composable
fun SplashScreen(navController: NavHostController) {

    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 1000, easing = {
                OvershootInterpolator(2f).getInterpolation(it)
            })
        )
        delay(3000)
        navController.navigate(BottomNavigationItems.PizzaScreen.route)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.fsclogo),
            contentDescription = "FSC Logo",
        )
    }
}
