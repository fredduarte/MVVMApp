package com.sw.fred.ui.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.sw.fred.R
import com.sw.fred.graph.MainGraph
import com.sw.fred.ui.viewmodel.HomeViewModel

// The INITIAL screen of the app
@Destination<MainGraph>(start = true)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {


    Text(
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        text = stringResource(id = R.string.home_scree_title),
    )
}
