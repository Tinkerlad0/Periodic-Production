package com.tinkerlad.chemistry.recipe;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.block.BlockList;
import com.tinkerlad.chemistry.item.ItemList;
import com.tinkerlad.chemistry.item.alloy.ItemAlloy;
import com.tinkerlad.chemistry.recipe.alloy.AlloyCraftingManager;
import com.tinkerlad.chemistry.recipe.backend.RecipesSiphon;
import com.tinkerlad.chemistry.reference.ElementList;
import com.tinkerlad.chemistry.reference.dataTypes.AlloyComponent;
import com.tinkerlad.chemistry.reference.dataTypes.Element;
import com.tinkerlad.chemistry.registry.RegisterAlloy;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Recipes {

	public static void initRecipes() {
		initElementCommonRecipes();
		initMachineRecipes();
		initAlloyRecipes();
	}

	public static void initMachineRecipes() {
		GameRegistry.addShapedRecipe(new ItemStack(BlockList.MACHINE_SIPHON), "XYX", "YZY", "XYX", 'Z',
				                            ItemList.DUST_SILICON, 'Y', ItemList.INGOT_LITHIUM, 'X',
				                            ItemList.INGOT_IRON);

		RecipesSiphon.getInstance().addRecipe(new ItemStack(ItemList.CATALYST_BASIC, 2),
				                                     new ItemStack(BlockList.ORE_SILICON, 3),
				                                     new ItemStack(Items.redstone));
	}

	public static void initElementCommonRecipes() {


		for (Field field : Chemistry.elementList.getClass().getDeclaredFields()) {
			Object obj = ObfuscationReflectionHelper.getPrivateValue(ElementList.class, Chemistry.elementList,
					                                                        field.getName());
			if (obj instanceof Element) {
				Element element = (Element) obj;

				if (Chemistry.converter.getBlockFromElement(element) != null && Chemistry.converter
						                                                                .getBaseItemFromElement
								                                                                 (element) != null) {
					ItemStack itemStackInput = new ItemStack(Chemistry.converter.getIngotFromElement(element));
					ItemStack itemStackOutput = new ItemStack(Chemistry.converter.getBlockFromElement(element));
					GameRegistry.addShapedRecipe(itemStackOutput, "XXX", "XXX", "XXX", 'X', itemStackInput);
				}

				if (Chemistry.converter.getIngotFromElement(element) != null && Chemistry.converter
						                                                                .getBaseItemFromElement
								                                                                 (element) != null) {
					GameRegistry.addSmelting(Chemistry.converter.getBaseItemFromElement(element),
							                        new ItemStack(Chemistry.converter.getIngotFromElement(element)), 2F);
				}
			}
		}
	}

	public static void initAlloyRecipes() {

		for (Field field : ItemList.class.getDeclaredFields()) {
			if (field.isAnnotationPresent(RegisterAlloy.class)) {
				RegisterAlloy annotation = field.getAnnotation(RegisterAlloy.class);
				Object obj = ObfuscationReflectionHelper.getPrivateValue(ItemList.class, Chemistry.itemList,
						                                                        field.getName());
				if (obj instanceof ItemAlloy) {
					ItemAlloy alloy = (ItemAlloy) obj;
					switch (annotation.type()) {
						case Shapeless:
							List itemStackInputs = new ArrayList();
							for (AlloyComponent alloyComponent : alloy.ALLOY.getCOMPONENTS()) {
								ItemStack inputStack = new ItemStack(Chemistry.converter.getBaseItemFromElement(alloyComponent.ELEMENT), alloyComponent.AMOUNT);
								itemStackInputs.add(inputStack);
							}
							AlloyCraftingManager.getInstance().addShapelessRecipe(new ItemStack(alloy), itemStackInputs);
							break;
						case Shaped:
							break;
					}
				}
			}
		}
	}
}
