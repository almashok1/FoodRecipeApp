package kz.adamant.foodrecipeapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import kz.adamant.foodrecipeapp.models.FoodRecipe
import kz.adamant.foodrecipeapp.util.Constants.Companion.RECIPES_TABLE


@Entity(tableName = RECIPES_TABLE)
class RecipesEntity(
    val foodRecipe: FoodRecipe
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}
