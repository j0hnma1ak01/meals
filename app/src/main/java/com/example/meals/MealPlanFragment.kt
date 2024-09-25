package com.example.meals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.meals.databinding.FragmentMealPlanBinding

class MealPlanFragment : Fragment() {


    private lateinit var binding : FragmentMealPlanBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMealPlanBinding.inflate(inflater,container,false)
        return binding.root
    }
}