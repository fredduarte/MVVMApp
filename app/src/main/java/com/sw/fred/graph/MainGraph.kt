package com.sw.fred.graph

import com.ramcosta.composedestinations.annotation.NavHostGraph
import com.ramcosta.composedestinations.annotation.parameters.CodeGenVisibility

@NavHostGraph(
    route = "preferred_route",
    visibility = CodeGenVisibility.INTERNAL,
)
annotation class MainGraph