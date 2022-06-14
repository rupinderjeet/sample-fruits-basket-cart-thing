package com.rupinderjeet.sample.fruits

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.rupinderjeet.sample.R
import com.rupinderjeet.sample.data.Fruit
import com.rupinderjeet.sample.data.FruitContainer
import com.rupinderjeet.sample.databinding.FruitsFragmentBinding

abstract class FruitsFragment : Fragment() {

    protected abstract fun getContainer(): FruitContainer

    protected abstract fun fruitsLiveData(): LiveData<List<Fruit>>

    protected abstract fun onFruitTapped(fruit: Fruit)

    private var _binding: FruitsFragmentBinding? = null
    private val binding get() = _binding!!

    private val fruitsAdapter by lazy {
        FruitsAdapter { fruit ->
            onFruitTapped(fruit)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FruitsFragmentBinding.inflate(inflater, container, false)

        val layoutManager = LinearLayoutManager(context)
        binding.fruitsRecyclerView.layoutManager = layoutManager
        binding.fruitsRecyclerView.adapter = fruitsAdapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.titleTextView.text = when (getContainer()) {
            FruitContainer.BASKET -> getString(R.string.basket)
            FruitContainer.CART -> getString(R.string.cart)
        }

        fruitsLiveData().observe(viewLifecycleOwner) { fruits ->
            fruitsAdapter.submitList(fruits)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}