package com.rupinderjeet.sample.fruits

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rupinderjeet.sample.data.Fruit
import com.rupinderjeet.sample.databinding.FruitItemBinding

class FruitsAdapter(
    private val adapterListener: FruitsAdapterListener
) : ListAdapter<Fruit, FruitsAdapter.FruitViewHolder>(
    FruitDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        val binding = FruitItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return FruitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
        val fruit = currentList[position]
        holder.setFruit(fruit)
    }

    inner class FruitViewHolder(
        private val binding: FruitItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private lateinit var fruit: Fruit

        init {
            binding.nameTextView.setOnClickListener {
                adapterListener.onFruitTapped(fruit)
            }
        }

        fun setFruit(fruit: Fruit) {
            this.fruit = fruit

            binding.nameTextView.text = fruit.name
            binding.nameTextView.isSelected = fruit.selected
        }
    }
}

