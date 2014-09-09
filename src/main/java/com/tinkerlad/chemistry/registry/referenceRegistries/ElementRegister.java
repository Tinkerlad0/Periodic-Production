package com.tinkerlad.chemistry.registry.referenceRegistries;

import com.tinkerlad.chemistry.block.element.BlockElementBase;
import com.tinkerlad.chemistry.block.element.OreElementBase;
import com.tinkerlad.chemistry.item.element.ItemElementBase;
import com.tinkerlad.chemistry.item.element.ItemElementIngot;
import com.tinkerlad.chemistry.reference.dataTypes.Element;

import java.util.HashMap;
import java.util.Map;

public class ElementRegister {

    public static Map<Element, ItemElementBase> elementBaseMap = new HashMap<Element, ItemElementBase>();
    public static Map<Element, OreElementBase> oreElementBaseMap = new HashMap<Element, OreElementBase>();
    public static Map<Element, BlockElementBase> blockElementBaseMap = new HashMap<Element, BlockElementBase>();
    public static Map<Element, ItemElementIngot> elementIngotMap = new HashMap<Element, ItemElementIngot>();

    public ItemElementBase getBaseItemFromElement(Element element) {
        return elementBaseMap.get(element);
    }

    public OreElementBase getOreFromElement(Element element) {
        return oreElementBaseMap.get(element);
    }

    public BlockElementBase getBlockFromElement(Element element) {
        return blockElementBaseMap.get(element);
    }

    public ItemElementIngot getIngotFromElement(Element element) {
        return elementIngotMap.get(element);
    }

    public boolean addElementBaseItem(Element element, ItemElementBase baseItem) {
        if (elementBaseMap.containsKey(element)) {
            return false;
        }
        elementBaseMap.put(element, baseItem);
        return true;
    }

    public boolean addElementIngot(Element element, ItemElementIngot itemElementIngot) {
        if (elementIngotMap.containsKey(element)) {
            return false;
        }
        elementIngotMap.put(element, itemElementIngot);
        return true;
    }

    public boolean addElementOre(Element element, OreElementBase baseItem) {
        if (oreElementBaseMap.containsKey(element) || element == null || baseItem == null) {
            return false;
        }
        oreElementBaseMap.put(element, baseItem);
        return true;
    }

    public boolean addElementPureBlock(Element element, BlockElementBase pureBlock) {
        if (blockElementBaseMap.containsKey(element)) {
            return false;
        }
        blockElementBaseMap.put(element, pureBlock);
        return true;
    }
}
