package com.rupinderjeet.sample.fruits

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rupinderjeet.sample.data.Fruit
import com.rupinderjeet.sample.data.FruitContainer
import com.rupinderjeet.sample.data.FruitsRepository

class FruitsViewModel : ViewModel() {

    // TODO: Use Dependency Injection
    private val repository = FruitsRepository()

    private val _fruitsInBasket = MutableLiveData<List<Fruit>>()
    fun fruitsInBasket(): LiveData<List<Fruit>> = _fruitsInBasket

    private val _fruitsInCart = MutableLiveData<List<Fruit>>()
    fun fruitsICart(): LiveData<List<Fruit>> = _fruitsInCart

    init {
        fetchFruits()
    }

    private fun fetchFruits() {
        val fruits = repository.getFruits()

        _fruitsInBasket.value = fruits.filter { fruit ->
            fruit.container == FruitContainer.BASKET
        }

        _fruitsInCart.value = fruits.filter { fruit ->
            fruit.container == FruitContainer.CART
        }
    }

    fun onFruitTapped(fruit: Fruit) {
        val updatedFruit = fruit.copy(selected = !fruit.selected)
        repository.updateFruit(updatedFruit)
        fetchFruits()
    }

    fun onMoveToBasketButtonTapped() {
        moveFruitsToContainer(FruitContainer.BASKET)
        fetchFruits()
    }

    fun onMoveToCartButtonTapped() {
        moveFruitsToContainer(FruitContainer.CART)
        fetchFruits()
    }

    private fun moveFruitsToContainer(container: FruitContainer) {
        repository.getFruits()
            .filter { fruit ->
                (fruit.container != container && fruit.selected)
            }
            .forEach { fruit ->
                val updatedFruit = fruit.copy(container = container, selected = false)
                repository.updateFruit(updatedFruit)
            }
    }
}