package com.tinkerlad.chemistry.reference;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.item.tools.*;
import com.tinkerlad.chemistry.reference.dataTypes.ElementToolPart;
import cpw.mods.fml.common.registry.GameRegistry;

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
			GameRegistry.registerItem(pickaxe, pickaxe.getUnlocalizedName());
		}
	}

	public void initSwords() {
		for (ElementToolPart toolPart : Chemistry.elementMaterials.getToolPartList()) {
			ItemElementSword sword = new ItemElementSword(toolPart);
			swordMap.put(toolPart, sword);
			GameRegistry.registerItem(sword, sword.getUnlocalizedName());
		}
	}

	public void initHoes() {
		for (ElementToolPart toolPart : Chemistry.elementMaterials.getToolPartList()) {
			ItemElementHoe hoe = new ItemElementHoe(toolPart);
			hoeMap.put(toolPart, hoe);
			GameRegistry.registerItem(hoe, hoe.getUnlocalizedName());
		}
	}

	public void initAxes() {
		for (ElementToolPart toolPart : Chemistry.elementMaterials.getToolPartList()) {
			ItemElementAxe axe = new ItemElementAxe(toolPart);
			axeMap.put(toolPart, axe);
			GameRegistry.registerItem(axe, axe.getUnlocalizedName());
		}
	}

	public void initShovels() {
		for (ElementToolPart toolPart : Chemistry.elementMaterials.getToolPartList()) {
			ItemElementShovel shovel = new ItemElementShovel(toolPart);
			shovelMap.put(toolPart, shovel);
			GameRegistry.registerItem(shovel, shovel.getUnlocalizedName());
		}
	}
}
