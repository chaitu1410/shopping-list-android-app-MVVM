package com.chaittnyashinde.shoppingcart.ui.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.chaittnyashinde.shoppingcart.R
import com.chaittnyashinde.shoppingcart.data.db.entities.ShoppingItem
import com.chaittnyashinde.shoppingcart.other.ShoppingItemAdapter
import kotlinx.android.synthetic.main.activity_shoping.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class ShopingActivity : AppCompatActivity(), KodeinAware {

    override val kodein: Kodein by kodein()
    private val factory: ShoppingViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shoping)

        val viewModel = ViewModelProviders.of(this, factory).get(ShoppingViewModel::class.java)

        val adapter = ShoppingItemAdapter(listOf(), viewModel)
        rvShoppingItems.layoutManager = LinearLayoutManager(this)
        rvShoppingItems.adapter = adapter

        viewModel.getAll().observe(this, Observer{
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        fab.setOnClickListener {
            AddShopingItemDialog(
                this,
                object : AddDialogListener{
                    override fun onAddButtonClick(item: ShoppingItem) {
                        viewModel.upsert(item)
                    }
                }
            ).show()
        }
    }
}