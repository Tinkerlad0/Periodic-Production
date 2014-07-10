package com.tinkerlad.chemistry.utils;

import com.tinkerlad.chemistry.block.element.BlockElementBase;
import com.tinkerlad.chemistry.block.element.OreElementBase;
import com.tinkerlad.chemistry.item.element.ItemElementBase;
import com.tinkerlad.chemistry.item.element.ItemElementIngot;
import com.tinkerlad.chemistry.reference.dataTypes.Element;
import com.tinkerlad.chemistry.reference.dataTypes.ElementToolPart;

import java.util.HashMap;
import java.util.Map;

public class ElementTypeConverter {

	public static Map<Element, ItemElementBase> baseItemMap = new HashMap<Element, ItemElementBase>();
	public static Map<Element, OreElementBase> oreMap = new HashMap<Element, OreElementBase>();
	public static Map<Element, BlockElementBase> blockPureMap = new HashMap<Element, BlockElementBase>();
	public static Map<Element, ItemElementIngot> ingotMap = new HashMap<Element, ItemElementIngot>();
	public static Map<Element, ElementToolPart> toolPartMap = new HashMap<Element, ElementToolPart>();

	public ItemElementBase getBaseItemFromElement(Element element) {
		return baseItemMap.get(element);
	}

	public OreElementBase getOreFromElement(Element element) {
		return oreMap.get(element);
	}

	public BlockElementBase getBlockFromElement(Element element) {
		return blockPureMap.get(element);
	}

	public ItemElementIngot getIngotFromElement(Element element) { return ingotMap.get(element);}

	public boolean addElementBaseItem(Element element, ItemElementBase baseItem) {
		if (baseItemMap.containsKey(element)) {
			return false;
		}
		baseItemMap.put(element, baseItem);
		return true;
	}

	public boolean addElementIngot(Element element, ItemElementIngot itemElementIngot) {
		if (ingotMap.containsKey(element)) {
			return false;
		}
		ingotMap.put(element, itemElementIngot);
		return true;
	}

	public boolean addElementOre(Element element, OreElementBase baseItem) {
		if (oreMap.containsKey(element) || element == null || baseItem == null) {
			return false;
		}
		oreMap.put(element, baseItem);
		return true;
	}

	public boolean addElementPureBlock(Element element, BlockElementBase pureBlock) {
		if (blockPureMap.containsKey(element)) {
			return false;
		}
		blockPureMap.put(element, pureBlock);
		return true;
	}
}
