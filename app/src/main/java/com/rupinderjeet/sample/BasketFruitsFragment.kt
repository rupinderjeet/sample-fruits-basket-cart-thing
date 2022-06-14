package com.rupinderjeet.sample

import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import com.rupinderjeet.sample.data.Fruit
import com.rupinderjeet.sample.data.FruitContainer
import com.rupinderjeet.sample.fruits.FruitsFragment
import com.rupinderjeet.sample.fruits.FruitsViewModel

class BasketFruitsFragment : FruitsFragment() {

    private val fruitsViewModel by activityViewModels<FruitsViewModel>()

    override fun getContainer(): FruitContainer {
        return FruitContainer.BASKET
    }

    override fun fruitsLiveData(): LiveData<List<Fruit>> {
        return fruitsViewModel.fruitsInBasket()
    }

    override fun onFruitTapped(fruit: Fruit) {
        fruitsViewModel.onFruitTapped(fruit)
    }
}