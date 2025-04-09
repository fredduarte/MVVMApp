package com.sw.fred.ui.widgets

import androidx.annotation.StringRes
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigation
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.ramcosta.composedestinations.generated.NavGraphs
import com.ramcosta.composedestinations.generated.destinations.HomeScreenDestination
import com.ramcosta.composedestinations.generated.destinations.SearchScreenDestination
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec
import com.ramcosta.composedestinations.utils.isRouteOnBackStackAsState
import com.ramcosta.composedestinations.utils.rememberDestinationsNavigator
import com.sw.fred.R

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    val navigator = navController.rememberDestinationsNavigator()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.primary,
    ) {
        BottomBarDestination.entries.forEach { destination ->
            val isCurrentDestOnBackStack by navController.isRouteOnBackStackAsState(destination.direction)
            BottomNavigationItem(
                selected = isCurrentDestOnBackStack,
                onClick = {
                    if (isCurrentDestOnBackStack) {
                        // When we click again on a bottom bar item
                        // and it was already selected
                        navigator.popBackStack(destination.direction, false)
                        return@BottomNavigationItem
                    }

                    navigator.navigate(destination.direction) {
                        // Pop up to the root of the graph to
                        popUpTo(NavGraphs.preferredRoute) {
                            saveState = true
                        }

                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        destination.icon,
                        contentDescription = stringResource(destination.label)
                    )
                },
                label = { Text(stringResource(destination.label)) },
            )
        }
    }
}

enum class BottomBarDestination(
    val direction: DirectionDestinationSpec,
    val icon: ImageVector,
    @StringRes val label: Int
) {
    Home(HomeScreenDestination, Icons.Default.Home, R.string.home_scree_title),
    Search(SearchScreenDestination, Icons.Default.Search, R.string.search_screen_bottom_bar_title),
}
