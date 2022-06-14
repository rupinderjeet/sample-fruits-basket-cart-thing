package com.rupinderjeet.sample.fruits

import com.rupinderjeet.sample.data.Fruit

fun interface FruitsAdapterListener {
    fun onFruitTapped(fruit: Fruit)
}