package com.chaittnyashinde.shoppingcart.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.chaittnyashinde.shoppingcart.data.db.entities.ShoppingItem
import com.chaittnyashinde.shoppingcart.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val repository: ShoppingRepository
): ViewModel() {
    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun markTaken(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.markTaken(item)
    }

    fun getAll() = repository.getAll()

}