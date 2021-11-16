package com.example.androidbootcamp

import android.content.Context

open class ItemRepository(context: Context) {

    private val itemModel: ItemModel = ItemModel(context)

    fun getFavoriteItem() = itemModel.getFavoriteItems()

    fun saveFavoriteItem(favItem: DataItem) = itemModel.saveFavoriteItems(favItem)

    fun removeFavoriteItem() = itemModel.removeFavoriteItems()
}