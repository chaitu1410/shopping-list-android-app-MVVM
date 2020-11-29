package com.chaittnyashinde.shoppingcart.data.repositories

import com.chaittnyashinde.shoppingcart.data.db.ShoppingDatabase
import com.chaittnyashinde.shoppingcart.data.db.entities.ShoppingItem

class ShoppingRepository(
    private val db: ShoppingDatabase
) {
    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)
    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)
    suspend fun markTaken(item: ShoppingItem) = db.getShoppingDao().markTaken(item)
    fun getAll() = db.getShoppingDao().getAll()
}