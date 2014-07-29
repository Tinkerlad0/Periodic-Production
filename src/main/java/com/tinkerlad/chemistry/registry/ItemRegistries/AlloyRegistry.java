package com.tinkerlad.chemistry.registry.ItemRegistries;

import com.tinkerlad.chemistry.block.element.BlockElementBase;
import com.tinkerlad.chemistry.block.element.OreElementBase;
import com.tinkerlad.chemistry.item.element.ItemElementBase;
import com.tinkerlad.chemistry.item.element.ItemElementIngot;
import com.tinkerlad.chemistry.reference.dataTypes.Element;

import java.util.HashMap;
import java.util.Map;

public class AlloyRegistry {
	public static Map<Element, ItemElementBase> elementBaseMap = new HashMap<Element, ItemElementBase>();
	public static Map<Element, OreElementBase> oreElementBaseMap = new HashMap<Element, OreElementBase>();
	public static Map<Element, BlockElementBase> blockElementBaseMap = new HashMap<Element, BlockElementBase>();
	public static Map<Element, ItemElementIngot> elementIngotMap = new HashMap<Element, ItemElementIngot>();
}
