package com.life.orca.composeme.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.life.orca.composeme.ui.screens.features.FeatureListScreen
import com.life.orca.composeme.ui.screens.navigationparam.NavigationParamScreen
import com.life.orca.composeme.ui.screens.sample.YotiButtonSampleScreen
import com.life.orca.composeme.ui.theme.ComposeMeTheme

private object Routes {

    const val FeatureList = "feature_list"
    const val YotiButtonSample = "yoti_button_sample"
    const val NavigationParam = "navigation_param"
}

private class Actions(navController: NavHostController) {

    val showYotiButtonSample: () -> Unit = {
        navController.navigate(Routes.YotiButtonSample)
    }
    val showNavigationParam: (String) -> Unit = { itemId ->
        navController.navigate(Routes.NavigationParam + "/$itemId")
    }
}

@Composable
fun HomeScreen(startDestination: String = Routes.FeatureList) {
    val navController = rememberNavController()
    val actions = remember(navController) { Actions(navController) }

    NavHost(navController, startDestination = startDestination) {
        composable(Routes.FeatureList) {
            FeatureListScreen(
                    showYotiButtonSample = actions.showYotiButtonSample,
                    showNavigationParam = actions.showNavigationParam
            )
        }
        composable(Routes.YotiButtonSample) {
            YotiButtonSampleScreen()
        }
        composable(
                Routes.NavigationParam + "/{itemId}",
                arguments = listOf(navArgument("itemId") { type = NavType.StringType })
        ) { backStackEntry ->
            val itemId = backStackEntry.arguments!!.getString("itemId")!!
            NavigationParamScreen(itemId = itemId)
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