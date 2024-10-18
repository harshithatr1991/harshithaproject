package com.example.harshitha_code_test

data class Repository(
    val name: String,
    val description: String? = null, // Optional field
    val language: String? = null, // Optional field
    val stars: Int? = null, // Optional field
    val forks: Int? = null // Optional field
)
