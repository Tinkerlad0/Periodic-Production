package com.tinkerlad.chemistry.recipe.alloy;

import net.minecraft.item.crafting.IRecipe;

import java.util.Comparator;

public class RecipeSorter implements Comparator {

	final AlloyCraftingManager alloyCraftingManager;

	public RecipeSorter(AlloyCraftingManager manager) {
		this.alloyCraftingManager = manager;
	}

	public int compareRecipes(IRecipe par1IRecipe, IRecipe par2IRecipe) {
		return par1IRecipe instanceof ShapelessRecipes && par2IRecipe instanceof ShapedRecipes ? 1 : (par2IRecipe instanceof ShapelessRecipes && par1IRecipe instanceof ShapedRecipes ? -1 : (par2IRecipe.getRecipeSize() < par1IRecipe.getRecipeSize() ? -1 : (par2IRecipe.getRecipeSize() > par1IRecipe.getRecipeSize() ? 1 : 0)));
	}

	public int compare(Object par1Obj, Object par2Obj) {
		return this.compareRecipes((IRecipe) par1Obj, (IRecipe) par2Obj);
	}
}
