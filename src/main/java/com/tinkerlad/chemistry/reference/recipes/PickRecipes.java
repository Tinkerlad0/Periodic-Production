package com.tinkerlad.chemistry.reference.recipes;

import com.tinkerlad.chemistry.item.element.ItemElementIngot;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class PickRecipes implements IRecipe {

	public final int recipeWidth;
	public final int recipeHeight;

	public final ItemStack[] recipeItems;

	private ItemStack recipeOutput;

	public PickRecipes(int recipeWidth, int recipeHeight, ItemStack[] recipeItems) {
		this.recipeWidth = recipeWidth;
		this.recipeHeight = recipeHeight;
		this.recipeItems = recipeItems;
	}

	@Override
	public boolean matches(InventoryCrafting crafting, World world) {

		boolean flag = true;

		flag = (crafting.getStackInRowAndColumn(0, 0).getItem() instanceof ItemElementIngot) ? flag : false;
		flag = (crafting.getStackInRowAndColumn(0, 1).getItem() instanceof ItemElementIngot) ? flag : false;
		flag = (crafting.getStackInRowAndColumn(0, 2).getItem() instanceof ItemElementIngot) ? flag : false;
		flag = (crafting.getStackInRowAndColumn(0, 2).getItem() == crafting.getStackInRowAndColumn(0, 0).getItem()) ? flag : false;
		flag = (crafting.getStackInRowAndColumn(1, 1).getItem() == Items.stick) ? flag : false;
		flag = (crafting.getStackInRowAndColumn(2, 1).getItem() == Items.stick) ? flag : false;

		return flag;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting crafting) {

		Item edge = crafting.getStackInRowAndColumn(0, 0).getItem();
		Item centre = crafting.getStackInRowAndColumn(0, 1).getItem();

		return null;
	}

	@Override
	public int getRecipeSize() {
		return 0;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return this.recipeOutput;
	}
}
