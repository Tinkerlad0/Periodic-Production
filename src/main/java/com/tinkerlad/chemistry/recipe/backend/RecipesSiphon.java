package com.tinkerlad.chemistry.recipe.backend;

import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class RecipesSiphon {

	private static RecipesSiphon siphonRegistry = null;

	private List<RecipeSiphon> siphonRecipes;

	private RecipesSiphon() {
		siphonRecipes = new ArrayList<RecipeSiphon>();
	}

	public static RecipesSiphon getInstance() {
		if (siphonRegistry == null) {
			siphonRegistry = new RecipesSiphon();
		}

		return siphonRegistry;
	}

	public void addRecipe(ItemStack recipeOutput, ItemStack recipeInputStack, ItemStack recipeInputDust) {
		addRecipe(new RecipeSiphon(recipeOutput, recipeInputStack, recipeInputDust));
	}

	public void addRecipe(RecipeSiphon recipeSiphon) {
		if (!siphonRecipes.contains(recipeSiphon)) {
			siphonRecipes.add(recipeSiphon);
		}
	}

	public void addRecipe(ItemStack recipeOutput, OreStack recipeInputStack, ItemStack recipeInputDust) {
		addRecipe(new RecipeSiphon(recipeOutput, recipeInputStack, recipeInputDust));
	}

	public ItemStack getResult(ItemStack recipeInputStack, ItemStack recipeInputDust) {
		for (RecipeSiphon recipeSiphon : siphonRecipes) {
			if (recipeSiphon.matches(recipeInputStack, recipeInputDust)) {
				return recipeSiphon.getRecipeOutput();
			}
		}

		return null;
	}

	public RecipeSiphon getRecipe(ItemStack recipeInputStack, ItemStack recipeInputDust) {
		for (RecipeSiphon recipeSiphon : siphonRecipes) {
			if (recipeSiphon.matches(recipeInputStack, recipeInputDust)) {
				return recipeSiphon;
			}
		}

		return null;
	}

	public List<RecipeSiphon> getRecipes() {
		return siphonRecipes;
	}
}
