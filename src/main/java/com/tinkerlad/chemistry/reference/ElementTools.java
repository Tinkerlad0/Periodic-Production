package com.tinkerlad.chemistry.reference;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.item.tools.ItemElementPickaxe;
import com.tinkerlad.chemistry.item.tools.ItemElementSword;
import com.tinkerlad.chemistry.reference.dataTypes.ElementToolPart;
import cpw.mods.fml.common.registry.GameRegistry;

import java.util.HashMap;
import java.util.Map;

public class ElementTools {

	public Map<ElementToolPart, ItemElementPickaxe> pickaxeMap = new HashMap<ElementToolPart, ItemElementPickaxe>();
	public Map<ElementToolPart, ItemElementSword> swordMap = new HashMap<ElementToolPart, ItemElementSword>();

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
}
