package com.acabes.imageapiapplication

data class ImageResult(val photos:List<Results>)

data class Results(
    val url: String,
    val title: String
)
