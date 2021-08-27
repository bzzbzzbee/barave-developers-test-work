package com.example.bravedeveloperstestwork.data

data class Root (
    var count: Int = 0,
    var next: String? = null,
    var previous: String? = null,
    var results: List<Results>? = null
)

data class Results (
    var name: String,
    var url: String
)

