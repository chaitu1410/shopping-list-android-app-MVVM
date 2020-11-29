package com.chaittnyashinde.shoppingcart.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items")
class ShoppingItem(

    @ColumnInfo(name="item_name")
    var name: String,
    @ColumnInfo(name="item_amount")
    var amount: Int,
    @ColumnInfo(name="item_taken")
    var isTaken: Boolean

) {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

}