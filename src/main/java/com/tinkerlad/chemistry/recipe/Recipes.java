package com.tinkerlad.chemistry.recipe;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.block.BlockList;
import com.tinkerlad.chemistry.item.ItemList;
import com.tinkerlad.chemistry.item.alloy.ItemAlloyDust;
import com.tinkerlad.chemistry.recipe.alloy.AlloyCraftingManager;
import com.tinkerlad.chemistry.recipe.backend.RecipesSiphon;
import com.tinkerlad.chemistry.recipe.rocketry.RocketCraftingManager;
import com.tinkerlad.chemistry.reference.AlloyList;
import com.tinkerlad.chemistry.reference.ElementList;
import com.tinkerlad.chemistry.reference.dataTypes.AlloyComponent;
import com.tinkerlad.chemistry.reference.dataTypes.Element;
import com.tinkerlad.chemistry.registry.annotations.RegisterAlloy;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Recipes {

	public static void initRecipes() {
		initElementCommonRecipes();
		initGameRecipes();
		initAlloyRecipes();
		initRocketRecipes();
	}

	public static void initGameRecipes() {
		GameRegistry.addShapedRecipe(new ItemStack(BlockList.MACHINE_SIPHON), "XYX", "YZY", "XYX", 'Z',
				                            ItemList.DUST_SILICON, 'Y', ItemList.INGOT_LITHIUM, 'X',
				                            ItemList.INGOT_IRON);

		RecipesSiphon.getInstance().addRecipe(new ItemStack(ItemList.CATALYST_BASIC, 2),
				                                     new ItemStack(BlockList.ORE_SILICON, 3),
				                                     new ItemStack(Items.redstone));

		GameRegistry.addShapedRecipe(new ItemStack(ItemList.CANISTER_EMPTY), "XXX", "YZY", "XXX", 'X',
				                            ItemList.INGOT_IRON, 'Y', ItemList.INGOT_COPPER, 'Z',
				                            Chemistry.ALLOY_REGISTRY.getAlloyDust(AlloyList.FeC));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemList.CANISTER_CANDY), new ItemStack(ItemList.CANISTER_EMPTY)
				                               , new ItemStack(Chemistry.ALLOY_REGISTRY.getAlloyDust(AlloyList.C6H12O6)),
				                               new ItemStack(Chemistry.ALLOY_REGISTRY.getAlloyDust(AlloyList.KNO3)));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemList.CANISTER_ZINC_SULFUR),
				                               new ItemStack(ItemList.CANISTER_EMPTY),
				                               new ItemStack(ItemList.DUST_ZINC),
				                               new ItemStack(ItemList.DUST_SULFUR));

		GameRegistry.addShapedRecipe(new ItemStack(ItemList.NOSE_CONE), " I ", "I I", "III", 'I',
				                            ItemList.INGOT_ALUMINIUM);

		GameRegistry.addShapedRecipe(new ItemStack(ItemList.FIN), "I  ", "II ", " II", 'I', ItemList.INGOT_ALUMINIUM);

		GameRegistry.addShapedRecipe(new ItemStack(ItemList.INVENTORY_MODULE), "IAI", "ACA", "IAI",
				                            'I', ItemList.INGOT_IRON,
				                            'A', ItemList.INGOT_ALUMINIUM,
				                            'C', Item.getItemFromBlock(Blocks.chest));

		GameRegistry.addShapelessRecipe(new ItemStack(ItemList.DEBUG), new ItemStack(Blocks.dirt));
	}

	public static void initRocketRecipes() {

		GameRegistry.addShapedRecipe(new ItemStack(ItemList.ROCKET_BASIC), " N ", " I ", "FRF",
				                            'N', ItemList.NOSE_CONE,
				                            'I', ItemList.INVENTORY_MODULE,
				                            'F', ItemList.FIN,
				                            'R', ItemList.CANISTER_CANDY);


		RocketCraftingManager.getInstance().addRecipe(new ItemStack(ItemList.ROCKET_BASIC),
				                                             "  F",
				                                             "NIB",
				                                             "  F",
				                                             'F', ItemList.FIN,
				                                             'N', ItemList.NOSE_CONE,
				                                             'I', ItemList.INVENTORY_MODULE,
				                                             'B', ItemList.CANISTER_CANDY);
	}

	public static void initElementCommonRecipes() {


		for (Field field : Chemistry.ELEMENT_LIST.getClass().getDeclaredFields()) {
			Object obj = ObfuscationReflectionHelper.getPrivateValue(ElementList.class, Chemistry.ELEMENT_LIST,
					                                                        field.getName());
			if (obj instanceof Element) {
				Element element = (Element) obj;

				if (Chemistry.ELEMENT_REGISTRY.getBlockFromElement(element) != null && Chemistry.ELEMENT_REGISTRY
						                                                                       .getBaseItemFromElement
								                                                                        (element) != null) {
					ItemStack itemStackInput = new ItemStack(Chemistry.ELEMENT_REGISTRY.getIngotFromElement(element));
					ItemStack itemStackOutput = new ItemStack(Chemistry.ELEMENT_REGISTRY.getBlockFromElement(element));
					GameRegistry.addShapedRecipe(itemStackOutput, "XXX", "XXX", "XXX", 'X', itemStackInput);
				}

				if (Chemistry.ELEMENT_REGISTRY.getIngotFromElement(element) != null && Chemistry.ELEMENT_REGISTRY
						                                                                       .getBaseItemFromElement
								                                                                        (element) != null) {
					GameRegistry.addSmelting(Chemistry.ELEMENT_REGISTRY.getBaseItemFromElement(element),
							                        new ItemStack(Chemistry.ELEMENT_REGISTRY.getIngotFromElement(element)), 2F);
				}
			}
		}
	}

	public static void initAlloyRecipes() {
		for (Field field : ItemList.class.getDeclaredFields()) {
			if (field.isAnnotationPresent(RegisterAlloy.class)) {
				RegisterAlloy annotation = field.getAnnotation(RegisterAlloy.class);
				Object obj = ObfuscationReflectionHelper.getPrivateValue(ItemList.class, Chemistry.ITEM_LIST,
						                                                        field.getName());
				if (obj instanceof ItemAlloyDust) {
					ItemAlloyDust alloy = (ItemAlloyDust) obj;
					switch (annotation.type()) {
						case Shapeless:
							List itemStackInputs = new ArrayList();
							for (AlloyComponent alloyComponent : alloy.ALLOY.getCOMPONENTS()) {
								ItemStack inputStack = new ItemStack(Chemistry.ELEMENT_REGISTRY.getBaseItemFromElement(alloyComponent.ELEMENT), alloyComponent.AMOUNT);
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
