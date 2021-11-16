package com.example.androidbootcamp

import android.content.Context

open class Repository(context: Context) {

    private val itemModel: Model = Model(context)

    fun getFavoriteItem() = itemModel.getFavoriteItems()

    fun saveFavoriteItem(favItem: ItemDataClass) = itemModel.saveFavoriteItems(favItem)

    fun removeFavoriteItem() = itemModel.removeFavoriteItems()
}