package com.example.meals

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.meals.MealModel
import com.example.meals.databinding.ItemMealBinding

class MealAdapter (val data: List<MealModel>,val mealClickListener: MealClickListener) : ListAdapter<MealModel, MealAdapter.MyViewHolder>(UserItemDiffCallback()) {

    class MyViewHolder(val itemMealBinding: ItemMealBinding) :
        RecyclerView.ViewHolder(itemMealBinding.root) {
        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemMealBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }
    }
    interface MealClickListener {
        fun onMealClicked(meal: MealModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemMealBinding.meal= data.get(position)
        holder.itemMealBinding.mealimg.setImageResource(data.get(position).image)
        holder.itemMealBinding.root.setOnClickListener{
            mealClickListener.onMealClicked(data.get(position))
        }
    }

    class UserItemDiffCallback : DiffUtil.ItemCallback<MealModel>() {
        override fun areItemsTheSame(oldItem: MealModel, newItem: MealModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: MealModel, newItem: MealModel): Boolean {
            return oldItem == newItem
        }

    }
}