package com.chaittnyashinde.shoppingcart.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.chaittnyashinde.shoppingcart.R
import com.chaittnyashinde.shoppingcart.data.db.entities.ShoppingItem
import kotlinx.android.synthetic.main.dialog_add_shopping_item.*
import java.lang.Exception

class AddShopingItemDialog(context: Context, var addDialogListener: AddDialogListener): AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)
        tvAdd.setOnClickListener {
            val name = etName.text.toString()
            val amount = etAmount.text.toString()

            if(name.isEmpty() || amount.isEmpty()){
                Toast.makeText(context, "Please Enter All Information", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                val item: ShoppingItem = ShoppingItem(name, amount.toInt(), false)
                addDialogListener.onAddButtonClick(item)
            }catch(e: Exception){
                Toast.makeText(context, "Enter Valied Amount", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            dismiss()
        }

        tvCancel.setOnClickListener {
            cancel()
        }
    }
}