package com.sw.fred.ui.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sw.fred.data.domain.Recipe
import com.sw.fred.data.utils.Constants

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeCard(
    recipe: Recipe,
    onClicked: (Recipe) -> Unit,
) {
    Card(
        modifier = Modifier.width(Constants.RECIPE_CARD_SIZE),
        onClick = {
            onClicked(recipe)
        }
    ) {
        Column {
            Box {
                AsyncImage(
                    model = recipe.thumbnailUrl,
                    contentDescription = recipe.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(Constants.RECIPE_CARD_SIZE)
                )
            }
            Column(modifier = Modifier.padding(8.dp)) {
                Spacer(modifier = Modifier.size(4.dp))
                Row {
                    Text(
                        text = recipe.name,
                        style = MaterialTheme.typography.bodyLarge,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 2,
                        minLines = 2
                    )

                }
            }
        }
    }
}