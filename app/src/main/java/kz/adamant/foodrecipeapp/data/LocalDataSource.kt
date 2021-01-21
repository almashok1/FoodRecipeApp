package kz.adamant.foodrecipeapp.data

import kotlinx.coroutines.flow.Flow
import kz.adamant.foodrecipeapp.data.database.RecipesDao
import kz.adamant.foodrecipeapp.data.database.RecipesEntity
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val recipesDao : RecipesDao
) {

    fun readDatabase() : Flow<List<RecipesEntity>> {
        return recipesDao.readRecipes()
    }

    suspend fun insertRecipes(recipesEntity: RecipesEntity) {
        recipesDao.insertRecipes(recipesEntity)
    }

}