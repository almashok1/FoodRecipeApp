package kz.adamant.foodrecipeapp.data

import kz.adamant.foodrecipeapp.data.network.FoodRecipesApi
import kz.adamant.foodrecipeapp.models.FoodRecipe
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val foodRecipesApi: FoodRecipesApi
) {

    suspend fun getRecipes(queries: Map<String, String>) : Response<FoodRecipe> {
        return foodRecipesApi.getRecipes(queries)
    }

}