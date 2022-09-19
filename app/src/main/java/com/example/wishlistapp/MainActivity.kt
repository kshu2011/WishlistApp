package com.example.wishlistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var items: MutableList<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //get reference to the list
        items = ItemTracker.getItems()

        val adapter = ItemAdapter(items)

        val itemRecyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        itemRecyclerView.adapter = adapter
        itemRecyclerView.layoutManager = LinearLayoutManager(this)

        //from youtube trying to setup onclick listener
        adapter.setOnItemClickListener(object : ItemAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                Toast.makeText(getApplicationContext(), position.toString(), Toast.LENGTH_SHORT).show();
            }

        })


        //get the reference to the add button
        val addButton = findViewById<Button>(R.id.addButton)

        addButton.setOnClickListener {
            var name = findViewById<EditText>(R.id.itemName).getText().toString()
            var price = findViewById<EditText>(R.id.itemPrice).getText().toString()
            var description = findViewById<EditText>(R.id.itemDescription).getText().toString()

            val newItem = Item(name, price, description)
            ItemTracker.addItem(newItem)

            adapter.notifyDataSetChanged()

            Log.d("test", ItemTracker.getItems().toString())
        }
    }
}