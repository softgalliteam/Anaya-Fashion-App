package com.learning.exp.model.dataclasses.lahanga

data class LahangaDetails(
    var id: Int = 0,
    var name: String = "",
    var description: String = "",
    var imageUrl: String = "",
    var imageList: List<String> = emptyList()
)