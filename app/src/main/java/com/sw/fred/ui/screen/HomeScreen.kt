package com.sw.fred.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.sw.fred.R
import com.sw.fred.data.domain.Recipe
import com.sw.fred.graph.MainGraph
import com.sw.fred.ui.viewmodel.HomeViewModel
import com.sw.fred.ui.widgets.RecipeCard

// The INITIAL screen of the app
@Destination<MainGraph>(start = true)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val viewState = viewModel.viewState.collectAsState(
        initial = HomeViewModel.ViewState.Loading,
    ).value

    HomeScreenContent(
        modifier = Modifier.fillMaxSize(),
        viewState = viewState,
        onRecipyClicked = { recipe ->
            // TODO: Navigate to recipe detail screen
        }
    )
}

@Composable
fun HomeScreenContent(
    modifier: Modifier,
    viewState: HomeViewModel.ViewState,
    onRecipyClicked: (Recipe) -> Unit
) {
    when (viewState) {
        is HomeViewModel.ViewState.Success -> {
            val categoryRecipes = viewState.categoryRecipes
            LazyColumn(
                modifier = modifier,
                contentPadding = PaddingValues(vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(32.dp),
            ) {
                items(categoryRecipes) { item ->
                    RecipeList(
                        recipes = item.recipes,
                        title = item.category.name,
                        onClicked = onRecipyClicked
                    )
                }
            }
        }
        is HomeViewModel.ViewState.Error -> {
            Box(
                modifier = modifier,
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.home_error_message),
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
        HomeViewModel.ViewState.Loading -> {
            Box(
                modifier = modifier,
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.loading),
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
        HomeViewModel.ViewState.NoResults -> {
            Box(
                modifier = modifier,
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.no_results),
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Composable
fun RecipeList(
    modifier: Modifier = Modifier,
    title: String = "",
    recipes: List<Recipe>,
    onClicked: (Recipe) -> Unit
) {
    Column {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            modifier = modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.size(12.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(recipes) { recipe ->
                RecipeCard(
                    recipe = recipe,
                    onClicked = { onClicked(it) },
                )
            }
        }
    }
}
