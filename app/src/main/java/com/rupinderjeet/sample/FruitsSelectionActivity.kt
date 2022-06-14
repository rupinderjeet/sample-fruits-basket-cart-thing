package com.rupinderjeet.sample

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.rupinderjeet.sample.databinding.FruitsSelectionActivityBinding
import com.rupinderjeet.sample.fruits.FruitsViewModel

class FruitsSelectionActivity : AppCompatActivity() {

    private lateinit var binding: FruitsSelectionActivityBinding
    private val fruitsViewModel: FruitsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FruitsSelectionActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.moveToCartButton.setOnClickListener {
            fruitsViewModel.onMoveToCartButtonTapped()
        }

        binding.moveToBasketButton.setOnClickListener {
            fruitsViewModel.onMoveToBasketButtonTapped()
        }
    }
}