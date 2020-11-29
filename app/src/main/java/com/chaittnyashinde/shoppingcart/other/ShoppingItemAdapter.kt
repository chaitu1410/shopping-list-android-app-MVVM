package com.chaittnyashinde.shoppingcart.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chaittnyashinde.shoppingcart.R
import com.chaittnyashinde.shoppingcart.data.db.entities.ShoppingItem
import com.chaittnyashinde.shoppingcart.ui.shoppinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
): RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currentShoppingItem = items[position]

        holder.itemView.tvName.text = currentShoppingItem.name
        holder.itemView.tvAmount.text = currentShoppingItem.amount.toString()
        holder.itemView.cbIsTaken.isChecked = currentShoppingItem.isTaken

        holder.itemView.ivDelete.setOnClickListener {
            viewModel.delete(currentShoppingItem)
        }

        holder.itemView.ivPlus.setOnClickListener {
            currentShoppingItem.amount++
            viewModel.upsert(currentShoppingItem)
        }

        holder.itemView.setOnClickListener {
            if(currentShoppingItem.amount > 0){
                currentShoppingItem.amount--
                viewModel.upsert(currentShoppingItem)
            }
        }

        holder.itemView.cbIsTaken.setOnClickListener {
            currentShoppingItem.isTaken = !currentShoppingItem.isTaken
            viewModel.markTaken(currentShoppingItem)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


    inner class ShoppingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}