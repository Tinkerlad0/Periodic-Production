package com.tinkerlad.chemistry.reference.recipes;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.block.BlockList;
import com.tinkerlad.chemistry.item.ItemList;
import com.tinkerlad.chemistry.reference.ElementList;
import com.tinkerlad.chemistry.reference.dataTypes.Element;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;

import java.lang.reflect.Field;

public class ElementCommonRecipes {

	public static void init() {

		GameRegistry.addShapedRecipe(new ItemStack(BlockList.MACHINE_SIPHON), "XYX", "YZY", "XYX", 'Z',
				                            ItemList.DUST_SILICON, 'Y', ItemList.INGOT_LITHIUM, 'X',
				                            ItemList.INGOT_IRON);

		for (Field field : Chemistry.elementList.getClass().getDeclaredFields()) {
			Object obj = ObfuscationReflectionHelper.getPrivateValue(ElementList.class, Chemistry.elementList,
					                                                        field.getName());
			if (obj instanceof Element) {
				Element element = (Element) obj;

				if (Chemistry.converter.getBlockFromElement(element) != null && Chemistry.converter
						                                                                .getBaseItemFromElement
								                                                                 (element) != null) {
					ItemStack itemStackInput = new ItemStack(Chemistry.converter.getBaseItemFromElement(element));
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
}
