package com.example.wishlist

import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items: ArrayList<Item> = ArrayList()
        val rvItems = findViewById<RecyclerView>(R.id.itemList)
        val addButton = findViewById<Button>(R.id.addButton)

        addButton.setOnClickListener{

            val itemName = findViewById<EditText>(R.id.name).text.toString()
            val itemPrice = findViewById<EditText>(R.id.price).text.toString().toDouble()
            val itemLink = findViewById<EditText>(R.id.storeUrl).text.toString()

            val newItem = Item(itemName, itemPrice, itemLink)
            items.add(newItem)
            //create adapter passing in the data
            val adapter = ItemAdapter(items)

            rvItems.adapter = adapter
            rvItems.layoutManager = LinearLayoutManager(this)
        }
    }
}

