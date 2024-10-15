package sk.viktorov.skool.homework.testing.recipeApp;

import java.util.ArrayList;
import java.util.HashMap;

public class RecipeApp {
    private final HashMap<Recipe, ArrayList<Ingredient>> recipes = new HashMap<>();

    public boolean addRecipe(Recipe recipe, ArrayList<Ingredient> ingredients) {
        recipes.put(recipe, ingredients);
        return true;
    }

    public ArrayList<Ingredient> getIngredientsOfARecipe(String recipeName) {
        for (Recipe recipe : recipes.keySet()) {
            if (recipe.getName().equals(recipeName)) {
                return recipes.get(recipe);
            }
        }
        return new ArrayList<>();
    }

    public boolean isRecipePresent(String recipeName) {
        for (Recipe recipe : recipes.keySet()) {
            if (recipe.getName().equals(recipeName)) {
                return true;
            }
        }
        return false;
    }

    public void deleteRecipe(Recipe recipe) {
        recipes.remove(recipe);
    }

    public void updateRecipesIngredients(Recipe recipe, ArrayList<Ingredient> ingredients) {
        recipes.put(recipe, ingredients);
    }
}
