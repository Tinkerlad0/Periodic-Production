package com.tinkerlad.chemistry.reference;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.logging.LogHelper;
import com.tinkerlad.chemistry.reference.dataTypes.Element;
import com.tinkerlad.chemistry.reference.dataTypes.ElementToolPart;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import org.apache.logging.log4j.Level;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElementMaterials {

	public static Map<ElementToolPart, Item.ToolMaterial> materialMap = new HashMap<ElementToolPart,
			                                                                               Item.ToolMaterial>();
	public static List<ElementToolPart> toolPartList = new ArrayList<ElementToolPart>();

	public static Map<ElementToolPart, Item.ToolMaterial> getMaterialMap() {
		return materialMap;
	}

	public Item.ToolMaterial getMaterialFromToolPart(ElementToolPart toolPart) {
		return materialMap.get(toolPart);
	}

	public void initMaterials() {

		for (Field field1 : Chemistry.elementList.getClass().getDeclaredFields()) {
			Object obj1 = ObfuscationReflectionHelper.getPrivateValue(ElementList.class,
					                                                         Chemistry.elementList,
					                                                         field1.getName());
			for (Field field2 : Chemistry.elementList.getClass().getDeclaredFields()) {

				Object obj2 = ObfuscationReflectionHelper.getPrivateValue(ElementList.class,
						                                                         Chemistry.elementList,
						                                                         field2.getName());


				Element edge = (Element) obj1;
				Element core = (Element) obj2;
				ElementToolPart toolPart = new ElementToolPart(edge, core);
				toolPartList.add(toolPart);
				materialMap.put(toolPart, EnumHelper.addToolMaterial(toolPart.getName(),
						                                                    toolPart.getMiningLevel(),
						                                                    toolPart.getDurability(),
						                                                    toolPart.getMineSpeed(),
						                                                    toolPart.getDamageDealt(),
						                                                    toolPart.getEnchantability()));
				if (Chemistry.configHandler.VERBOSE) {
					LogHelper.log(Level.INFO, "Created Tool Material " + toolPart.getName());
				}
			}
		}
	}

	public List<ElementToolPart> getToolPartList() {
		return toolPartList;
	}
}
