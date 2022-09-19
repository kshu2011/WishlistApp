package com.example.wishlistapp

/**This class will be used to keep track of items. It can add items to a list
 * and return that list of items.*/
class ItemTracker {
    companion object {

        var itemList = mutableListOf<Item>()

        fun addItem(inputItem: Item) {
            itemList.add(inputItem)
        }

        fun getItems(): MutableList<Item> {
            return itemList
        }
    }
}