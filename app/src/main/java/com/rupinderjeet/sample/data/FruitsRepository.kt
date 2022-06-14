package com.rupinderjeet.sample.data

import java.util.*

class FruitsRepository {

    private val fruits = mutableMapOf<String, Fruit>()

    init {
        repeat(10) { index ->
            val fruit = Fruit(
                id = UUID.randomUUID().toString(),
                name = "Fruit $index",
                selected = false,
                container = FruitContainer.BASKET
            )
            fruits[fruit.id] = fruit
        }
    }

    fun getFruits(): List<Fruit> = fruits.values.toList()

    fun updateFruit(fruit: Fruit) {
        fruits[fruit.id] = fruit
    }
}