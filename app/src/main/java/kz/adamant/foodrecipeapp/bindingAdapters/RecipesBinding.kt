package kz.adamant.foodrecipeapp.bindingAdapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import kz.adamant.foodrecipeapp.data.database.RecipesEntity
import kz.adamant.foodrecipeapp.models.FoodRecipe
import kz.adamant.foodrecipeapp.util.NetworkResult

class RecipesBinding {

    companion object {

        @BindingAdapter("readApiResponse", "readDatabase", requireAll = true)
        @JvmStatic
        fun errorViewVisibility(
            view: View,
            apiResponse: NetworkResult<FoodRecipe>?,
            database: List<RecipesEntity>?
        ) {
            if (apiResponse == null || database == null) return
            if (apiResponse is NetworkResult.Error && database.isNullOrEmpty()) {
                view.visibility = View.VISIBLE
                if (view is TextView) {
                    view.text = apiResponse.message.toString()
                }
            } else if (apiResponse is NetworkResult.Loading) {
                view.visibility = View.INVISIBLE
            } else if (apiResponse is NetworkResult.Success) {
                view.visibility = View.INVISIBLE
            }
        }


    }

}