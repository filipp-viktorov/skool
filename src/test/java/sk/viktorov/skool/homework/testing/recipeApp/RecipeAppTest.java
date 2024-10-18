package sk.viktorov.skool.homework.testing.recipeApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecipeAppTest {
    private RecipeApp recipeApp;

    @BeforeEach
    void setUp() {
        recipeApp = new RecipeApp();
    }

    private RecipeApp initializeAppWithRecipe(RecipeApp recipeApp, String recipeName, ArrayList<Ingredient> ingredients) {
        Recipe recipe = new Recipe(recipeName);
        recipeApp.addRecipe(recipe, ingredients);

        return recipeApp;
    }

    private ArrayList<Ingredient> createDefaultIngredients() {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Spaghetti"));
        ingredients.add(new Ingredient("Egg"));
        ingredients.add(new Ingredient("Cheese"));
        ingredients.add(new Ingredient("Bacon"));

        return ingredients;
    }

    /**
     * Test the 'addRecipe' method
     */
    @Test
    void should_AddRecipeWithIngredients_When_IngredientsProvided() {
        ArrayList<Ingredient> ingredients = createDefaultIngredients();
        initializeAppWithRecipe(recipeApp, "Pasta Carbonara", ingredients);

        assertTrue(recipeApp.isRecipePresent("Pasta Carbonara"));
        assertEquals(ingredients, recipeApp.getIngredientsOfARecipe("Pasta Carbonara"));
    }

    @Test
    void should_AddRecipeWithoutIngredients_When_NoIngredientsProvided() {
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        initializeAppWithRecipe(recipeApp, "Pasta Carbonara", ingredients);

        assertTrue(recipeApp.isRecipePresent("Pasta Carbonara"));
        assertEquals(ingredients, recipeApp.getIngredientsOfARecipe("Pasta Carbonara"));
    }

//    @Test
//    void should_ThrowException_When_NullRecipeAdded() {
//        Recipe recipe = null;
//        ArrayList<Ingredient> ingredients = new ArrayList<>();
//
//        assertThrows(NullPointerException.class, () -> recipeApp.addRecipe(recipe, ingredients));
//    }

    @Test
    void should_OverrideRecipe_When_RecipeAlreadyPresent() {
        ArrayList<Ingredient> initialIngredients = createDefaultIngredients();
        initializeAppWithRecipe(recipeApp, "Pasta Carbonara", initialIngredients);
        ArrayList<Ingredient> newIngredients = new ArrayList<>(List.of(new Ingredient("Spaghetti"), new Ingredient("Cheese")));

        boolean result = recipeApp.addRecipe(new Recipe("Pasta Carbonara"), newIngredients);

        assertTrue(result);
        assertTrue(recipeApp.isRecipePresent("Pasta Carbonara"));
        assertEquals(newIngredients, recipeApp.getIngredientsOfARecipe("Pasta Carbonara"));
    }

    /**
     * Test the 'getIngredientsOfARecipe' method
     */
    @Test
    void should_ReturnIngredients_When_RecipeIsPresent() {
        ArrayList<Ingredient> ingredients = createDefaultIngredients();
        initializeAppWithRecipe(recipeApp, "Pasta Carbonara", ingredients);

        ArrayList<Ingredient> resultIngredients = recipeApp.getIngredientsOfARecipe("Pasta Carbonara");

        assertEquals(ingredients, resultIngredients);
    }

    @Test
    void should_ReturnEmptyList_When_RecipeIsNotPresent() {
        ArrayList<Ingredient> resultIngredients = recipeApp.getIngredientsOfARecipe("Pasta Carbonara");

        assertEquals(new ArrayList<>(), resultIngredients);
    }

    /**
     * Test the 'deleteRecipe' method
     */
    @Test
    void should_DeleteRecipe_When_RecipeIsPresent() {
        ArrayList<Ingredient> ingredients = createDefaultIngredients();
        initializeAppWithRecipe(recipeApp, "Pasta Carbonara", ingredients);

        assertTrue(recipeApp.isRecipePresent("Pasta Carbonara"));
        recipeApp.deleteRecipe(new Recipe("Pasta Carbonara"));

        assertFalse(recipeApp.isRecipePresent("Pasta Carbonara"));
    }

    /**
     * Test the 'updateRecipesIngredients' method
     */
    @Test
    void should_UpdateRecipesIngredients_When_NewIngredientsProvided() {
        ArrayList<Ingredient> initialIngredients = createDefaultIngredients();
        initializeAppWithRecipe(recipeApp, "Pasta Carbonara", initialIngredients);
        assertEquals(initialIngredients, recipeApp.getIngredientsOfARecipe("Pasta Carbonara"));

        ArrayList<Ingredient> newIngredients = new ArrayList<>(List.of(new Ingredient("Spaghetti"), new Ingredient("Garlic"), new Ingredient("Cheese")));
        recipeApp.updateRecipesIngredients(new Recipe("Pasta Carbonara"), newIngredients);

        assertEquals(newIngredients, recipeApp.getIngredientsOfARecipe("Pasta Carbonara"));
    }

    /**
     * Test the 'isRecipePresent' method
     */
    @Test
    void should_CheckRecipePresence_When_RecipeNameGiven() {
        ArrayList<Ingredient> ingredients = createDefaultIngredients();
        initializeAppWithRecipe(recipeApp, "Pasta Carbonara", ingredients);

        assertTrue(recipeApp.isRecipePresent("Pasta Carbonara"));
        assertFalse(recipeApp.isRecipePresent("Pasta Bolognese"));
    }
}
