package com.rupinderjeet.sample.data

data class Fruit(
    val id: String,
    val name: String,
    val selected: Boolean,
    val container: FruitContainer,
)

enum class FruitContainer {
    BASKET, CART
}