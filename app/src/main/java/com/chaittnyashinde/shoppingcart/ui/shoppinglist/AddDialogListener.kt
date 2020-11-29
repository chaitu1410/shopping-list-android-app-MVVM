package com.chaittnyashinde.shoppingcart.ui.shoppinglist

import com.chaittnyashinde.shoppingcart.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClick(item: ShoppingItem)
}