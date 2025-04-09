package com.sw.fred.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.ramcosta.composedestinations.annotation.Destination
import com.sw.fred.R
import com.sw.fred.graph.MainGraph

@Composable
@Destination<MainGraph>()
fun SearchScreen(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = modifier.fillMaxSize(),
            textAlign = TextAlign.Center,
            text = stringResource(id = R.string.search_screen_title),
        )
    }
}

@Preview
@Composable
fun SearchScreenPreview() {
    SearchScreen()
}
