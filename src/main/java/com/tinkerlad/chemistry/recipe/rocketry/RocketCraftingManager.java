package com.tinkerlad.chemistry.recipe.rocketry;

import com.tinkerlad.chemistry.recipe.backend.RecipeSorter;
import com.tinkerlad.chemistry.recipe.backend.ShapedRecipes;
import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class RocketCraftingManager {

    public static final int WILDCARD_VALUE = Short.MAX_VALUE;
    private static final RocketCraftingManager instance = new RocketCraftingManager();
    private List recipes = new ArrayList();

    private RocketCraftingManager() {
        recipes = new ArrayList();

        //This is where your recipes will go

        Collections.sort(this.recipes, new RecipeSorter(this));
        System.out.println(this.recipes.size() + " recipes");
    }

    public static final RocketCraftingManager getInstance() {
        return instance;
    }

    public ShapedRecipes addRecipe(ItemStack par1ItemStack, Object... par2ArrayOfObj) {
        String var3 = "";
        int var4 = 0;
        int var5 = 0;
        int var6 = 0;

        if (par2ArrayOfObj[var4] instanceof String[]) {
            String[] var7 = (String[]) ((String[]) par2ArrayOfObj[var4++]);

            for (int var8 = 0; var8 < var7.length; ++var8) {
                String var9 = var7[var8];
                ++var6;
                var5 = var9.length();
                var3 = var3 + var9;
            }
        } else {
            while (par2ArrayOfObj[var4] instanceof String) {
                String var11 = (String) par2ArrayOfObj[var4++];
                ++var6;
                var5 = var11.length();
                var3 = var3 + var11;
            }
        }

        HashMap var12;

        for (var12 = new HashMap(); var4 < par2ArrayOfObj.length; var4 += 2) {
            Character var13 = (Character) par2ArrayOfObj[var4];
            ItemStack var14 = null;

            if (par2ArrayOfObj[var4 + 1] instanceof Item) {
                var14 = new ItemStack((Item) par2ArrayOfObj[var4 + 1]);
            } else if (par2ArrayOfObj[var4 + 1] instanceof Block) {
                var14 = new ItemStack((Block) par2ArrayOfObj[var4 + 1], 1, -1);
            } else if (par2ArrayOfObj[var4 + 1] instanceof ItemStack) {
                var14 = (ItemStack) par2ArrayOfObj[var4 + 1];
            }

            var12.put(var13, var14);
        }

        ItemStack[] var15 = new ItemStack[var5 * var6];

        for (int var16 = 0; var16 < var5 * var6; ++var16) {
            char var10 = var3.charAt(var16);

            if (var12.containsKey(Character.valueOf(var10))) {
                var15[var16] = ((ItemStack) var12.get(Character.valueOf(var10))).copy();
            } else {
                var15[var16] = null;
            }
        }

        ShapedRecipes var17 = new ShapedRecipes(var5, var6, var15, par1ItemStack);
        this.recipes.add(var17);
        return var17;
    }

    public ItemStack findMatchingRecipe(InventoryCrafting par1InventoryCrafting, World par2World) {
        int var3 = 0;
        ItemStack var4 = null;
        ItemStack var5 = null;
        int var6;

        for (var6 = 0; var6 < par1InventoryCrafting.getSizeInventory(); ++var6) {
            ItemStack var7 = par1InventoryCrafting.getStackInSlot(var6);

            if (var7 != null) {
                if (var3 == 0) {
                    var4 = var7;
                }

                if (var3 == 1) {
                    var5 = var7;
                }

                ++var3;
            }
        }

        if (var3 == 2 && var4.getItem() == var5.getItem() && var4.stackSize == 1 && var5.stackSize == 1 && var4.getItem()
                .isRepairable()) {
            Item var11 = var4.getItem();
            int var13 = var11.getMaxDamage() - var4.getItemDamageForDisplay();
            int var8 = var11.getMaxDamage() - var5.getItemDamageForDisplay();
            int var9 = var13 + var8 + var11.getMaxDamage() * 5 / 100;
            int var10 = var11.getMaxDamage() - var9;

            if (var10 < 0) {
                var10 = 0;
            }

            return new ItemStack(var4.getItem(), 1, var10);
        } else {
            for (var6 = 0; var6 < this.recipes.size(); ++var6) {
                IRecipe var12 = (IRecipe) this.recipes.get(var6);

                if (var12.matches(par1InventoryCrafting, par2World)) {
                    return var12.getCraftingResult(par1InventoryCrafting);
                }
            }

            return null;
        }
    }

    /**
     * returns the List<> of all recipes
     */
    public List getRecipeList() {
        return this.recipes;
    }
}
