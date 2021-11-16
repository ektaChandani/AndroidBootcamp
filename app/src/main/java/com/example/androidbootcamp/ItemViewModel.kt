package com.example.androidbootcamp

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class ItemViewModel(application: Application): AndroidViewModel(application) {

    private val context = getApplication<Application>().applicationContext
    private val itemRepository: ItemRepository = ItemRepository(context)
    val isItemFavorite: MutableLiveData<Boolean> = itemRepository.getFavoriteItem()
    private val TAG = ItemViewModel::class.java.simpleName

    fun removeFromFavorite(){
        itemRepository.removeFavoriteItem()
        isItemFavorite.value = itemRepository.getFavoriteItem().value
        Log.i(TAG, "Remove Fav ${itemRepository.getFavoriteItem().value}")
    }

    fun saveInFavorite(favoriteItem: DataItem) {
        itemRepository.saveFavoriteItem(favoriteItem)
        isItemFavorite.value = itemRepository.getFavoriteItem().value
        Log.i(TAG, "Save Fav ${itemRepository.getFavoriteItem().value}")
    }
}