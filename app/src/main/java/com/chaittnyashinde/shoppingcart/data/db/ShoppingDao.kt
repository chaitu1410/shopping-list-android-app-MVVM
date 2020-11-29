package com.chaittnyashinde.shoppingcart.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.chaittnyashinde.shoppingcart.data.db.entities.ShoppingItem
import kotlin.collections.List

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)

    @Update
    suspend fun markTaken(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_items")
    fun getAll(): LiveData<List<ShoppingItem>>

}