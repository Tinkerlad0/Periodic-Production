package com.tinkerlad.chemistry.item;

import com.tinkerlad.chemistry.item.element.ItemElementBase;
import com.tinkerlad.chemistry.item.element.ItemElementIngot;
import com.tinkerlad.chemistry.item.tool.*;
import com.tinkerlad.chemistry.reference.ElementList;
import com.tinkerlad.chemistry.registry.annotations.RegisterItem;
import net.minecraft.item.Item;

public class ItemList {

    @RegisterItem(itemName = "debug")
    public static ItemDebug DEBUG = new ItemDebug();

    @RegisterItem(itemName = "pick1")
    public static ItemElementPickaxe PICK1 = new ItemElementPickaxe(Item.ToolMaterial.WOOD);

    @RegisterItem(itemName = "pick2")
    public static ItemElementPickaxe PICK2 = new ItemElementPickaxe(Item.ToolMaterial.STONE);

    @RegisterItem(itemName = "pick3")
    public static ItemElementPickaxe PICK3 = new ItemElementPickaxe(Item.ToolMaterial.IRON);

    @RegisterItem(itemName = "pick4")
    public static ItemElementPickaxe PICK4 = new ItemElementPickaxe(Item.ToolMaterial.EMERALD);

    @RegisterItem(itemName = "axe1")
    public static ItemElementAxe AXE1 = new ItemElementAxe(Item.ToolMaterial.WOOD);

    @RegisterItem(itemName = "axe2")
    public static ItemElementAxe AXE2 = new ItemElementAxe(Item.ToolMaterial.STONE);

    @RegisterItem(itemName = "axe3")
    public static ItemElementAxe AXE3 = new ItemElementAxe(Item.ToolMaterial.IRON);

    @RegisterItem(itemName = "axe4")
    public static ItemElementAxe AXE4 = new ItemElementAxe(Item.ToolMaterial.EMERALD);

    @RegisterItem(itemName = "shovel1")
    public static ItemElementShovel SHOVEL1 = new ItemElementShovel(Item.ToolMaterial.WOOD);

    @RegisterItem(itemName = "shovel2")
    public static ItemElementShovel SHOVEL2 = new ItemElementShovel(Item.ToolMaterial.STONE);

    @RegisterItem(itemName = "shovel3")
    public static ItemElementShovel SHOVEL3 = new ItemElementShovel(Item.ToolMaterial.IRON);

    @RegisterItem(itemName = "shovel4")
    public static ItemElementShovel SHOVEL4 = new ItemElementShovel(Item.ToolMaterial.EMERALD);

    @RegisterItem(itemName = "hoe1")
    public static ItemElementHoe HOE1 = new ItemElementHoe(Item.ToolMaterial.WOOD);

    @RegisterItem(itemName = "hoe2")
    public static ItemElementHoe HOE2 = new ItemElementHoe(Item.ToolMaterial.STONE);

    @RegisterItem(itemName = "hoe3")
    public static ItemElementHoe HOE3 = new ItemElementHoe(Item.ToolMaterial.IRON);

    @RegisterItem(itemName = "hoe4")
    public static ItemElementHoe HOE4 = new ItemElementHoe(Item.ToolMaterial.EMERALD);

    @RegisterItem(itemName = "sword1")
    public static ItemElementSword SWORD1 = new ItemElementSword(Item.ToolMaterial.WOOD);

    @RegisterItem(itemName = "sword2")
    public static ItemElementSword SWORD2 = new ItemElementSword(Item.ToolMaterial.STONE);

    @RegisterItem(itemName = "sword3")
    public static ItemElementSword SWORD3 = new ItemElementSword(Item.ToolMaterial.IRON);

    @RegisterItem(itemName = "sword4")
    public static ItemElementSword SWORD4 = new ItemElementSword(Item.ToolMaterial.EMERALD);

    //Gas Elements

    @RegisterItem(itemName = "hydrogen")
    public static ItemElementBase DUST_HYDROGEN = new ItemElementBase(ElementList.HYDROGEN);

    @RegisterItem(itemName = "helium")
    public static ItemElementBase DUST_HELIUM = new ItemElementBase(ElementList.HELIUM);

    @RegisterItem(itemName = "nitrogen")
    public static ItemElementBase DUST_NITROGEN = new ItemElementBase(ElementList.NITROGEN);

    @RegisterItem(itemName = "oxygen")
    public static ItemElementBase DUST_OXYGEN = new ItemElementBase(ElementList.OXYGEN);

    @RegisterItem(itemName = "fluorine")
    public static ItemElementBase DUST_FLUORINE = new ItemElementBase(ElementList.FLUORINE);

    @RegisterItem(itemName = "neon")
    public static ItemElementBase DUST_NEON = new ItemElementBase(ElementList.NEON);

    @RegisterItem(itemName = "chlorine")
    public static ItemElementBase DUST_CHLORINE = new ItemElementBase(ElementList.CHLORINE);

    @RegisterItem(itemName = "argon")
    public static ItemElementBase DUST_ARGON = new ItemElementBase(ElementList.ARGON);

    @RegisterItem(itemName = "bromine")
    public static ItemElementBase DUST_BROMINE = new ItemElementBase(ElementList.BROMINE);

    @RegisterItem(itemName = "krypton")
    public static ItemElementBase DUST_KRYPTON = new ItemElementBase(ElementList.KRYPTON);

    //all solid elements

    @RegisterItem(itemName = "lithium")
    public static ItemElementBase DUST_LITHIUM = new ItemElementBase(ElementList.LITHIUM);

    @RegisterItem(itemName = "beryllium")
    public static ItemElementBase DUST_BERYLLIUM = new ItemElementBase(ElementList.BERYLLIUM);

    @RegisterItem(itemName = "boron")
    public static ItemElementBase DUST_BORON = new ItemElementBase(ElementList.BORON);

    @RegisterItem(itemName = "carbon")
    public static ItemElementBase DUST_CARBON = new ItemElementBase(ElementList.CARBON);

    @RegisterItem(itemName = "sodium")
    public static ItemElementBase DUST_SODIUM = new ItemElementBase(ElementList.SODIUM);

    @RegisterItem(itemName = "magnesium")
    public static ItemElementBase DUST_MAGNESIUM = new ItemElementBase(ElementList.MAGNESIUM);

    @RegisterItem(itemName = "aluminium")
    public static ItemElementBase DUST_ALUMINIUM = new ItemElementBase(ElementList.ALUMINIUM);

    @RegisterItem(itemName = "silicon")
    public static ItemElementBase DUST_SILICON = new ItemElementBase(ElementList.SILICON);

    @RegisterItem(itemName = "phosphorus")
    public static ItemElementBase DUST_PHOSPHORUS = new ItemElementBase(ElementList.PHOSPHORUS);

    @RegisterItem(itemName = "sulfur")
    public static ItemElementBase DUST_SULFUR = new ItemElementBase(ElementList.SULFUR);

    @RegisterItem(itemName = "potassium")
    public static ItemElementBase DUST_POTASSIUM = new ItemElementBase(ElementList.POTASSIUM);

    @RegisterItem(itemName = "calcium")
    public static ItemElementBase DUST_CALCIUM = new ItemElementBase(ElementList.CALCIUM);

    @RegisterItem(itemName = "scandium")
    public static ItemElementBase DUST_SCANDIUM = new ItemElementBase(ElementList.SCANDIUM);

    @RegisterItem(itemName = "titanium")
    public static ItemElementBase DUST_TITANIUM = new ItemElementBase(ElementList.TITANIUM);

    @RegisterItem(itemName = "vanadium")
    public static ItemElementBase DUST_VANADIUM = new ItemElementBase(ElementList.VANADIUM);

    @RegisterItem(itemName = "chromium")
    public static ItemElementBase DUST_CHROMIUM = new ItemElementBase(ElementList.CHROMIUM);

    @RegisterItem(itemName = "Manganese")
    public static ItemElementBase DUST_MANGANESE = new ItemElementBase(ElementList.MANGANESE);

    @RegisterItem(itemName = "Iron")
    public static ItemElementBase DUST_IRON = new ItemElementBase(ElementList.IRON);

    @RegisterItem(itemName = "Cobalt")
    public static ItemElementBase DUST_COBALT = new ItemElementBase(ElementList.COBALT);

    @RegisterItem(itemName = "Nickel")
    public static ItemElementBase DUST_NICKEL = new ItemElementBase(ElementList.NICKEL);

    @RegisterItem(itemName = "Copper")
    public static ItemElementBase DUST_COPPER = new ItemElementBase(ElementList.COPPER);

    @RegisterItem(itemName = "Zinc")
    public static ItemElementBase DUST_ZINC = new ItemElementBase(ElementList.ZINC);

    @RegisterItem(itemName = "Gallium")
    public static ItemElementBase DUST_GALLIUM = new ItemElementBase(ElementList.GALLIUM);

    @RegisterItem(itemName = "Germanium")
    public static ItemElementBase DUST_GERMANIUM = new ItemElementBase(ElementList.GERMANIUM);

    @RegisterItem(itemName = "Arsenic")
    public static ItemElementBase DUST_ARSENIC = new ItemElementBase(ElementList.ARSENIC);

    @RegisterItem(itemName = "Selenium")
    public static ItemElementBase DUST_SELENIUM = new ItemElementBase(ElementList.SELENIUM);

    @RegisterItem(itemName = "Rubidium")
    public static ItemElementBase DUST_RUBIDIUM = new ItemElementBase(ElementList.RUBIDIUM);

    //Ingots

    @RegisterItem(itemName = "ingot_lithium")
    public static ItemElementIngot INGOT_LITHIUM = new ItemElementIngot(ElementList.LITHIUM);

    @RegisterItem(itemName = "ingot_beryllium")
    public static ItemElementIngot INGOT_BERYLLIUM = new ItemElementIngot(ElementList.BERYLLIUM);

    @RegisterItem(itemName = "ingot_boron")
    public static ItemElementIngot INGOT_BORON = new ItemElementIngot(ElementList.BORON);

    @RegisterItem(itemName = "ingot_carbon")
    public static ItemElementIngot INGOT_CARBON = new ItemElementIngot(ElementList.CARBON);

    @RegisterItem(itemName = "ingot_sodium")
    public static ItemElementIngot INGOT_SODIUM = new ItemElementIngot(ElementList.SODIUM);

    @RegisterItem(itemName = "ingot_magnesium")
    public static ItemElementIngot INGOT_MAGNESIUM = new ItemElementIngot(ElementList.MAGNESIUM);

    @RegisterItem(itemName = "ingot_aluminium")
    public static ItemElementIngot INGOT_ALUMINIUM = new ItemElementIngot(ElementList.ALUMINIUM);

    @RegisterItem(itemName = "ingot_silicon")
    public static ItemElementIngot INGOT_SILICON = new ItemElementIngot(ElementList.SILICON);

    @RegisterItem(itemName = "ingot_phosphorus")
    public static ItemElementIngot INGOT_PHOSPHORUS = new ItemElementIngot(ElementList.PHOSPHORUS);

    @RegisterItem(itemName = "ingot_sulfur")
    public static ItemElementIngot INGOT_SULFUR = new ItemElementIngot(ElementList.SULFUR);

    @RegisterItem(itemName = "ingot_potassium")
    public static ItemElementIngot INGOT_POTASSIUM = new ItemElementIngot(ElementList.POTASSIUM);

    @RegisterItem(itemName = "ingot_calcium")
    public static ItemElementIngot INGOT_CALCIUM = new ItemElementIngot(ElementList.CALCIUM);

    @RegisterItem(itemName = "ingot_scandium")
    public static ItemElementIngot INGOT_SCANDIUM = new ItemElementIngot(ElementList.SCANDIUM);

    @RegisterItem(itemName = "ingot_titanium")
    public static ItemElementIngot INGOT_TITANIUM = new ItemElementIngot(ElementList.TITANIUM);

    @RegisterItem(itemName = "ingot_vanadium")
    public static ItemElementIngot INGOT_VANADIUM = new ItemElementIngot(ElementList.VANADIUM);

    @RegisterItem(itemName = "ingot_chromium")
    public static ItemElementIngot INGOT_CHROMIUM = new ItemElementIngot(ElementList.CHROMIUM);

    @RegisterItem(itemName = "ingot_Manganese")
    public static ItemElementIngot INGOT_MANGANESE = new ItemElementIngot(ElementList.MANGANESE);

    @RegisterItem(itemName = "ingot_Iron")
    public static ItemElementIngot INGOT_IRON = new ItemElementIngot(ElementList.IRON);

    @RegisterItem(itemName = "ingot_Cobalt")
    public static ItemElementIngot INGOT_COBALT = new ItemElementIngot(ElementList.COBALT);

    @RegisterItem(itemName = "ingot_Nickel")
    public static ItemElementIngot INGOT_NICKEL = new ItemElementIngot(ElementList.NICKEL);

    @RegisterItem(itemName = "ingot_Copper")
    public static ItemElementIngot INGOT_COPPER = new ItemElementIngot(ElementList.COPPER);

    @RegisterItem(itemName = "ingot_Zinc")
    public static ItemElementIngot INGOT_ZINC = new ItemElementIngot(ElementList.ZINC);

    @RegisterItem(itemName = "ingot_Gallium")
    public static ItemElementIngot INGOT_GALLIUM = new ItemElementIngot(ElementList.GALLIUM);

    @RegisterItem(itemName = "ingot_Germanium")
    public static ItemElementIngot INGOT_GERMANIUM = new ItemElementIngot(ElementList.GERMANIUM);

    @RegisterItem(itemName = "ingot_Arsenic")
    public static ItemElementIngot INGOT_ARSENIC = new ItemElementIngot(ElementList.ARSENIC);

    @RegisterItem(itemName = "ingot_Selenium")
    public static ItemElementIngot INGOT_SELENIUM = new ItemElementIngot(ElementList.SELENIUM);

    @RegisterItem(itemName = "ingot_Rubidium")
    public static ItemElementIngot INGOT_RUBIDIUM = new ItemElementIngot(ElementList.RUBIDIUM);
}
