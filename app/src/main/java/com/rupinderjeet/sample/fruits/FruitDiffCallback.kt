package com.rupinderjeet.sample.fruits

import androidx.recyclerview.widget.DiffUtil
import com.rupinderjeet.sample.data.Fruit

class FruitDiffCallback : DiffUtil.ItemCallback<Fruit>() {

    override fun areItemsTheSame(oldItem: Fruit, newItem: Fruit): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Fruit, newItem: Fruit): Boolean {
        return oldItem == newItem
    }
}