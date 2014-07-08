package com.tinkerlad.chemistry.registry;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.block.BlockList;
import com.tinkerlad.chemistry.block.element.BlockElementBase;
import com.tinkerlad.chemistry.block.element.OreElementBase;
import com.tinkerlad.chemistry.item.ItemList;
import com.tinkerlad.chemistry.item.element.ItemElementBase;
import com.tinkerlad.chemistry.item.element.ItemElementIngot;
import com.tinkerlad.chemistry.logging.LogHelper;
import com.tinkerlad.chemistry.reference.recipes.backend.RecipesSiphon;
import com.tinkerlad.chemistry.rendering.PhialItemRender;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.MinecraftForgeClient;
import org.apache.logging.log4j.Level;

import java.lang.reflect.Field;

public class Register {

	public static void registerBlocks() {

		LogHelper.log(Level.INFO, "Beginning Block Registration");

		for (Field field : BlockList.class.getDeclaredFields()) {
			if (field.isAnnotationPresent(RegisterBlock.class)) {
				RegisterBlock annotation = field.getAnnotation(RegisterBlock.class);
				field.setAccessible(true);
				Object obj = ObfuscationReflectionHelper.getPrivateValue(BlockList.class, Chemistry.blockList,
						                                                        field.getName());

				if (obj instanceof Block) {
					LogHelper.log(Level.INFO, "---Registering " + field.getName());
					GameRegistry.registerBlock((Block) obj, annotation.blockName());
					if (obj instanceof OreElementBase) {
						boolean oreAdd = Chemistry.converter.addElementOre(((OreElementBase) obj).ELEMENT,
								                                                  (OreElementBase) obj);

						if (oreAdd) {
							LogHelper.log(Level.INFO, "----" + field.getName() + " added as ore for " + ((OreElementBase)
									                                                                             obj)
									                                                                            .ELEMENT.NAME);
						} else {
							LogHelper.log(Level.ERROR, "----" + field.getName() + " failed to add as ore for " + (
									                                                                                     (OreElementBase)
											                                                                                     obj)
									                                                                                     .ELEMENT.NAME);
						}
					} else if (obj instanceof BlockElementBase) {
						boolean oreAdd = Chemistry.converter.addElementPureBlock(((BlockElementBase) obj).ELEMENT,
								                                                        (BlockElementBase) obj);

						if (oreAdd) {
							LogHelper.log(Level.INFO, "----" + field.getName() + " added as ore for " + ((BlockElementBase)
									                                                                             obj)
									                                                                            .ELEMENT.NAME);
						} else {
							LogHelper.log(Level.ERROR, "----" + field.getName() + " failed to add as ore for " + (
									                                                                                     (BlockElementBase)
											                                                                                     obj)
									                                                                                     .ELEMENT.NAME);
						}
					}
				}
			}
		}
		LogHelper.log(Level.INFO, "Block Registration complete.");
	}

	public static void registerItems() {

		LogHelper.log(Level.INFO, "Beginning Item Registration");

		for (Field field : ItemList.class.getDeclaredFields()) {
			if (field.isAnnotationPresent(RegisterItem.class)) {
				RegisterItem annotation = field.getAnnotation(RegisterItem.class);
				field.setAccessible(true);
				Object obj = ObfuscationReflectionHelper.getPrivateValue(ItemList.class, Chemistry.itemList,
						                                                        field.getName());

				if (obj instanceof Item) {
					LogHelper.log(Level.INFO, "----Registering " + field.getName());
					GameRegistry.registerItem((Item) obj, annotation.itemName());

					if (obj instanceof ItemElementIngot) {
						Chemistry.converter.addElementIngot(((ItemElementIngot) obj).ELEMENT, (ItemElementIngot) obj);
					}

					if (obj instanceof ItemElementBase) {
						if (!(Chemistry.converter.getOreFromElement(((ItemElementBase) obj).ELEMENT) == null)) {
							ItemStack output = new ItemStack((ItemElementBase) obj);
							ItemStack input1 = new ItemStack(Chemistry.converter.getOreFromElement(((ItemElementBase)
									                                                                        obj).ELEMENT));
							ItemStack input2 = new ItemStack(ItemList.CATALYST_BASIC);
							RecipesSiphon.getInstance().addRecipe(output, input1, input2);
						}
						boolean baseItemAdd = Chemistry.converter.addElementBaseItem(((ItemElementBase) obj).ELEMENT,
								                                                            (ItemElementBase) obj);
						ItemElementBase itemElementBase = (ItemElementBase) obj;
						MinecraftForgeClient.registerItemRenderer(itemElementBase, new PhialItemRender());

						if (baseItemAdd) {
							LogHelper.log(Level.INFO, "----" + field.getName() + " added as base item for " + (
									                                                                                  (ItemElementBase)
											                                                                                  obj)
									                                                                                  .ELEMENT.NAME);
						} else {
							LogHelper.log(Level.ERROR, "----" + field.getName() + " failed to add as base item for " + (
									                                                                                           (ItemElementBase)
											                                                                                           obj)
									                                                                                           .ELEMENT.NAME);
						}
					}
				}
			}
		}

		LogHelper.log(Level.INFO, "Item Registration Complete");
	}
}
