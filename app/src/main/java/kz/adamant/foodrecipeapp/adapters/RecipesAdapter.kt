package kz.adamant.foodrecipeapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kz.adamant.foodrecipeapp.databinding.RecipesRowLayoutBinding
import kz.adamant.foodrecipeapp.models.FoodRecipe
import kz.adamant.foodrecipeapp.models.Result
import kz.adamant.foodrecipeapp.util.DiffUtilImpl

class RecipesAdapter : RecyclerView.Adapter<RecipesAdapter.RecipeViewHolder>() {

    private var recipeList = emptyList<Result>()

    class RecipeViewHolder(private val binding: RecipesRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(result: Result) {
            binding.result = result
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): RecipeViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RecipesRowLayoutBinding.inflate(layoutInflater, parent, false)
                return RecipeViewHolder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val currentRecipe = recipeList[position]
        holder.bind(currentRecipe)
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    fun setData(newData: FoodRecipe) {
        val recipesDiffUtil = DiffUtilImpl<Result>(
            newList = newData.results,
            oldList = recipeList
        )
        val diffUtilResult = DiffUtil.calculateDiff(recipesDiffUtil)
        recipeList = newData.results
        diffUtilResult.dispatchUpdatesTo(this)
    }

}