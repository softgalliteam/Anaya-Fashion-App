package com.learning.exp.view.adapter

import com.learning.exp.model.dataclasses.lahanga.LahangaResponseDataItem

class CartAdapter(
    private val list: ArrayList<LahangaResponseDataItem>,
    private val listener: (Int) -> Unit
)