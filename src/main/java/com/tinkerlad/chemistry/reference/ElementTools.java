package com.tinkerlad.chemistry.reference;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.item.tools.*;
import com.tinkerlad.chemistry.reference.dataTypes.Element;
import com.tinkerlad.chemistry.reference.dataTypes.ElementToolPart;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class ElementTools {

	public Map<ElementToolPart, ItemElementPickaxe> pickaxeMap = new HashMap<ElementToolPart, ItemElementPickaxe>();
	public Map<ElementToolPart, ItemElementSword> swordMap = new HashMap<ElementToolPart, ItemElementSword>();
	public Map<ElementToolPart, ItemElementAxe> axeMap = new HashMap<ElementToolPart, ItemElementAxe>();
	public Map<ElementToolPart, ItemElementHoe> hoeMap = new HashMap<ElementToolPart, ItemElementHoe>();
	public Map<ElementToolPart, ItemElementShovel> shovelMap = new HashMap<ElementToolPart, ItemElementShovel>();

	public void initPickaxes() {
		for (ElementToolPart toolPart : Chemistry.elementMaterials.getToolPartList()) {
			ItemElementPickaxe pickaxe = new ItemElementPickaxe(toolPart);
			pickaxeMap.put(toolPart, pickaxe);
			GameRegistry.addShapedRecipe(new ItemStack(pickaxe), "XYX", " Z ", " Z ", 'X',
					                            getItemForCrafting(toolPart.getEdge()), 'Y',
					                            getItemForCrafting(toolPart.getCore()), 'Z', Items.stick);
			GameRegistry.registerItem(pickaxe, pickaxe.getUnlocalizedName());
		}
	}

	public void initSwords() {
		for (ElementToolPart toolPart : Chemistry.elementMaterials.getToolPartList()) {
			ItemElementSword sword = new ItemElementSword(toolPart);
			swordMap.put(toolPart, sword);
			GameRegistry.addShapedRecipe(new ItemStack(sword), " X ", " Y ", " Z ", 'X', getItemForCrafting(toolPart.getEdge()), 'Y',
					                            getItemForCrafting(toolPart.getCore()), 'Z', Items.stick);
			GameRegistry.registerItem(sword, sword.getUnlocalizedName());
		}
	}

	public void initHoes() {
		for (ElementToolPart toolPart : Chemistry.elementMaterials.getToolPartList()) {
			ItemElementHoe hoe = new ItemElementHoe(toolPart);
			hoeMap.put(toolPart, hoe);
			GameRegistry.addShapedRecipe(new ItemStack(hoe), " YX", " Z ", " Z ", 'X', getItemForCrafting(toolPart.getEdge()), 'Y',
					                            getItemForCrafting(toolPart.getCore()), 'Z', Items.stick);
			GameRegistry.addShapedRecipe(new ItemStack(hoe), "XY ", " Z ", " Z ", 'X', getItemForCrafting(toolPart.getEdge()), 'Y',
					                            getItemForCrafting(toolPart.getCore()), 'Z', Items.stick);
			GameRegistry.registerItem(hoe, hoe.getUnlocalizedName());
		}
	}

	public void initAxes() {
		for (ElementToolPart toolPart : Chemistry.elementMaterials.getToolPartList()) {
			ItemElementAxe axe = new ItemElementAxe(toolPart);
			axeMap.put(toolPart, axe);
			GameRegistry.addShapedRecipe(new ItemStack(axe), "XY ", "XZ ", " Z ", 'X',
					                            getItemForCrafting(toolPart.getEdge()), 'Y',
					                            getItemForCrafting(toolPart.getCore()), 'Z', Items.stick);
			GameRegistry.addShapedRecipe(new ItemStack(axe), " YX", " ZX", " Z ", 'X', getItemForCrafting(toolPart.getEdge()), 'Y',
					                            getItemForCrafting(toolPart.getCore()), 'Z', Items.stick);
			GameRegistry.registerItem(axe, axe.getUnlocalizedName());
		}
	}

	public void initShovels() {
		for (ElementToolPart toolPart : Chemistry.elementMaterials.getToolPartList()) {
			ItemElementShovel shovel = new ItemElementShovel(toolPart);
			shovelMap.put(toolPart, shovel);
			GameRegistry.addShapedRecipe(new ItemStack(shovel), " X ", " Y ", " Z ", 'X',
					                            getItemForCrafting(toolPart.getEdge()), 'Y',
					                            getItemForCrafting(toolPart.getCore()), 'Z', Items.stick);
			GameRegistry.registerItem(shovel, shovel.getUnlocalizedName());
		}
	}

	public Item getItemForCrafting(Element element) {
		if (element.STATE == Element.State.SOLID) {
			return Chemistry.converter.getIngotFromElement(element);
		} else {
			return Chemistry.converter.getBaseItemFromElement(element);
		}
	}

	public ItemElementAxe getAxeFromToolPart(ElementToolPart toolPart) {
		return axeMap.get(toolPart);
	}

	public ItemElementSword getSwordFromToolPart(ElementToolPart toolPart) {
		return swordMap.get(toolPart);
	}

	public ItemElementHoe getHoeFromToolPart(ElementToolPart toolPart) {
		return hoeMap.get(toolPart);
	}

	public ItemElementShovel getShovelFromToolPart(ElementToolPart toolPart) {
		return shovelMap.get(toolPart);
	}

	public ItemElementPickaxe getPickaxeFromToolPart(ElementToolPart toolPart) {
		return pickaxeMap.get(toolPart);
	}
}
