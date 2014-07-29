package com.tinkerlad.chemistry.registry;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.block.BlockList;
import com.tinkerlad.chemistry.block.alloy.BlockAlloyBricks;
import com.tinkerlad.chemistry.block.element.BlockElementBase;
import com.tinkerlad.chemistry.block.element.OreElementBase;
import com.tinkerlad.chemistry.config.ConfigHandler;
import com.tinkerlad.chemistry.item.ItemList;
import com.tinkerlad.chemistry.item.alloy.ItemAlloyDust;
import com.tinkerlad.chemistry.item.alloy.ItemAlloyIngot;
import com.tinkerlad.chemistry.item.element.ItemElementBase;
import com.tinkerlad.chemistry.item.element.ItemElementIngot;
import com.tinkerlad.chemistry.logging.LogFile;
import com.tinkerlad.chemistry.logging.LogHelper;
import com.tinkerlad.chemistry.recipe.backend.RecipesSiphon;
import com.tinkerlad.chemistry.reference.AlloyList;
import com.tinkerlad.chemistry.reference.dataTypes.Alloy;
import com.tinkerlad.chemistry.registry.annotations.RegisterAlloy;
import com.tinkerlad.chemistry.registry.annotations.RegisterBlock;
import com.tinkerlad.chemistry.registry.annotations.RegisterItem;
import com.tinkerlad.chemistry.registry.itemRegistry.AlloyRegistry;
import com.tinkerlad.chemistry.rendering.ItemRenderer;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.MinecraftForgeClient;
import org.apache.logging.log4j.Level;

import java.lang.reflect.Field;

public class Register {

	public static void initialise() {
		registerBlocks();
		registerItems();
		registerAlloys();
	}

	public static void registerBlocks() {

		if (ConfigHandler.DEBUG) {LogHelper.log(Level.INFO, "Beginning Block Registration");}

		for (Field field : BlockList.class.getDeclaredFields()) {
			if (field.isAnnotationPresent(RegisterBlock.class)) {
				RegisterBlock annotation = field.getAnnotation(RegisterBlock.class);
				field.setAccessible(true);
				Object obj = ObfuscationReflectionHelper.getPrivateValue(BlockList.class, Chemistry.BLOCK_LIST,
						                                                        field.getName());

				if (obj instanceof Block) {
					if (ConfigHandler.VERBOSE) {
						LogHelper.info("---Registering " + field.getName());
					}
					LogFile.info("---Registering Block - " + field.getName());
					GameRegistry.registerBlock((Block) obj, annotation.blockName());
					if (obj instanceof OreElementBase) {
						boolean oreAdd = Chemistry.ELEMENT_REGISTRY.addElementOre(((OreElementBase) obj).ELEMENT,
								                                                         (OreElementBase) obj);

						if (oreAdd) {
							if (ConfigHandler.VERBOSE) {
								LogHelper.log(Level.INFO, "----" + field.getName() + " " +
										                          "added as ore for " + (
												                                                (OreElementBase)
														                                                obj)
												                                                .ELEMENT.NAME);
							}
						} else {
							LogHelper.log(Level.ERROR, "----" + field.getName() + " failed to add as ore for " + (
									                                                                                     (OreElementBase)
											                                                                                     obj)
									                                                                                     .ELEMENT.NAME);
						}
					} else if (obj instanceof BlockElementBase) {
						boolean oreAdd = Chemistry.ELEMENT_REGISTRY.addElementPureBlock(((BlockElementBase) obj).ELEMENT,
								                                                               (BlockElementBase) obj);

						if (oreAdd) {
							if (ConfigHandler.VERBOSE) {
								LogHelper.log(Level.INFO, "----" + field.getName() + " " +
										                          "added as ore for " + ((BlockElementBase)
												                                                 obj)
												                                                .ELEMENT.NAME);
							}
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
		if (ConfigHandler.DEBUG) {LogHelper.log(Level.INFO, "Block Registration complete.");}
	}

	public static void registerItems() {

		if (ConfigHandler.DEBUG) {LogHelper.log(Level.INFO, "Beginning Item Registration");}

		for (Field field : ItemList.class.getDeclaredFields()) {
			if (field.isAnnotationPresent(RegisterItem.class)) {
				RegisterItem annotation = field.getAnnotation(RegisterItem.class);
				field.setAccessible(true);
				Object obj = ObfuscationReflectionHelper.getPrivateValue(ItemList.class, Chemistry.ITEM_LIST,
						                                                        field.getName());

				if (obj instanceof Item) {
					if (ConfigHandler.VERBOSE) {
						LogHelper.info("----Registering " + field.getName());
					}
					LogFile.info("----Registering Item - " + field.getName());
					GameRegistry.registerItem((Item) obj, annotation.itemName());

					if (obj instanceof ItemElementIngot) {
						Chemistry.ELEMENT_REGISTRY.addElementIngot(((ItemElementIngot) obj).ELEMENT, (ItemElementIngot) obj);
					}
					LogHelper.info(((Item) obj).getUnlocalizedName());
					if (obj instanceof ItemAlloyDust) {
						LogHelper.error(((ItemAlloyDust) obj).getUnlocalizedName() + " as " + ((ItemAlloyDust) obj).ALLOY.getNAME());
					}

					if (obj instanceof ItemElementBase) {
						if (!(Chemistry.ELEMENT_REGISTRY.getOreFromElement(((ItemElementBase) obj).ELEMENT) == null)) {
							ItemStack output = new ItemStack((ItemElementBase) obj);
							ItemStack input1 = new ItemStack(Chemistry.ELEMENT_REGISTRY.getOreFromElement(((ItemElementBase)
									                                                                               obj).ELEMENT));
							ItemStack input2 = new ItemStack(ItemList.CATALYST_BASIC);
							RecipesSiphon.getInstance().addRecipe(output, input1, input2);
						}
						boolean baseItemAdd = Chemistry.ELEMENT_REGISTRY.addElementBaseItem(((ItemElementBase) obj).ELEMENT,
								                                                                   (ItemElementBase) obj);
						ItemElementBase itemElementBase = (ItemElementBase) obj;
						MinecraftForgeClient.registerItemRenderer(itemElementBase, new ItemRenderer());

						if (baseItemAdd) {
							if (ConfigHandler.VERBOSE) {
								LogHelper.log(Level.INFO, "----" + field.getName() + " " +
										                          "added as base item for " + (
												                                                      (ItemElementBase)
														                                                      obj)
												                                                      .ELEMENT.NAME);
							}
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
		if (ConfigHandler.DEBUG) {LogHelper.log(Level.INFO, "Item Registration Complete");}
	}

	public static void registerAlloys() {

		if (ConfigHandler.DEBUG) {LogHelper.log(Level.INFO, "Beginning Alloy Registration");}

		for (Field field : AlloyList.class.getDeclaredFields()) {
			if (field.isAnnotationPresent(RegisterAlloy.class)) {
				RegisterAlloy annotation = field.getAnnotation(RegisterAlloy.class);
				field.setAccessible(true);
				Object obj = ObfuscationReflectionHelper.getPrivateValue(AlloyList.class, Chemistry.ALLOY_LIST,
						                                                        field.getName());

				if (obj instanceof Alloy) {
					Alloy alloy = (Alloy) obj;
					if (alloy.getSTATE() == Alloy.State.SOLID) {
						registerAlloyDust(alloy);
						registerAlloyIngotAndBlock(alloy);
					} else {
						registerAlloyDust(alloy);
					}
				}
				if (ConfigHandler.DEBUG) {LogHelper.log(Level.INFO, "Alloy Registration Complete");}
			}
		}
	}

	public static void registerAlloyDust(Alloy alloy) {
		ItemAlloyDust alloyDust = new ItemAlloyDust(alloy, alloy.getNAME());
		if (Chemistry.ALLOY_REGISTRY.addAlloyDust(alloy, alloyDust)) {
			GameRegistry.registerItem(alloyDust, alloy.getNAME());
			return;
		}
		LogHelper.error("--FAILED to Register " + alloy.getNAME() + " Dust");
	}

	public static void registerAlloyIngotAndBlock(Alloy alloy) {
		ItemAlloyIngot itemAlloyIngot = new ItemAlloyIngot(alloy, alloy.getNAME());
		if (Chemistry.ALLOY_REGISTRY.addAlloyIngot(alloy, itemAlloyIngot)) {
			GameRegistry.registerItem(itemAlloyIngot, alloy.getNAME() + "_ingot");
			GameRegistry.addSmelting(AlloyRegistry.itemAlloyDustMap.get(alloy), new ItemStack(itemAlloyIngot), 3F);
		} else {
			LogHelper.error("--FAILED to Register " + alloy.getNAME() + "_ingot");
		}

		BlockAlloyBricks blockAlloyBricks = new BlockAlloyBricks(alloy);
		if (Chemistry.ALLOY_REGISTRY.addAlloyBlock(alloy, blockAlloyBricks)) {
			GameRegistry.registerBlock(blockAlloyBricks, alloy.getNAME() + "_block");
			GameRegistry.addShapedRecipe(new ItemStack(blockAlloyBricks), "XXX", "XXX", "XXX", 'X', itemAlloyIngot);
		} else {
			LogHelper.error("--FAILED to Register " + alloy.getNAME() + "_block");
		}
	}
}