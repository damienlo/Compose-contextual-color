package com.life.orca.composeme.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.life.orca.composeme.ui.screens.features.FeatureListScreen
import com.life.orca.composeme.ui.screens.sample.YotiButtonSampleScreen
import com.life.orca.composeme.ui.theme.ComposeMeTheme

private object Routes {
    const val FeatureList = "feature_list"
    const val YotiButtonSample = "yoti_button_sample"
}

private class Actions(navController: NavHostController) {
    val showYotiButtonSample: () -> Unit = {
        navController.navigate(Routes.YotiButtonSample)
    }
}

@Composable
fun HomeScreen(startDestination: String = Routes.FeatureList) {
    val navController = rememberNavController()
    val actions = remember(navController) { Actions(navController) }

    NavHost(navController, startDestination = startDestination) {
        composable(Routes.FeatureList) {
            FeatureListScreen(showYotiButtonSample = actions.showYotiButtonSample)
        }
        composable(Routes.YotiButtonSample) {
            YotiButtonSampleScreen()
        }
    }
}

@Preview
@Composable
fun HomeScreenLightPreview() {
    ComposeMeTheme {
        HomeScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenDarkPreview() {
    ComposeMeTheme(darkTheme = true) {
        HomeScreen()
    }
}