package com.tinkerlad.chemistry.reference;

import com.tinkerlad.chemistry.reference.dataTypes.Element;

import static com.tinkerlad.chemistry.reference.dataTypes.Element.Hardness;
import static com.tinkerlad.chemistry.reference.dataTypes.Element.Type;

public class ElementList {

	public static Element HYDROGEN = new Element("Hydrogen", "H", 0.0F, Type.GAS, 0xffffff, 1);
	public static Element HELIUM = new Element("Helium", "He", 0.1F, Type.NOBLE_GAS, 0xffffff, 1);
	public static Element LITHIUM = new Element("Lithium", "Li", 0.5F, Type.ALKALINE_METAL, 0xCCCCCC, 2, Hardness.LOW);
	public static Element BERYLLIUM = new Element("Beryllium", "Be", 1.85F, Type.EARTH_METAL, 0xBDBAB3, 2, Hardness.LOW);
	public static Element BORON = new Element("Boron", "B", 2.5F, Type.METALLOID, 0x999999, 2, Hardness.LOW);
	public static Element CARBON = new Element("Carbon", "C", 2.3F, Type.METALLOID, 0x999999, 2, Hardness.LOW);
	public static Element NITROGEN = new Element("Nitrogen", "N", 1.3F, Type.GAS, 0xffffff, 2);
	public static Element OXYGEN = new Element("Oxygen", "O", 1.4F, Type.GAS, 0xffffff, 2);
	public static Element FLUORINE = new Element("Fluorine", "F", 1.7F, Type.HALOGEN, 0xffffff, 2);
	public static Element NEON = new Element("Neon", "Ne", 0.9F, Type.NOBLE_GAS, 0xB8FFA6, 2);
	public static Element SODIUM = new Element("Sodium", "Na", 1.0F, Type.ALKALINE_METAL, 0xDBD8CE, 3, Hardness.LOW);
	public static Element MAGNESIUM = new Element("Magnesium", "Mg", 1.7F, Type.EARTH_METAL, 0xDBDBDB, 3, Hardness.LOW);
	public static Element ALUMINIUM = new Element("Aluminium", "Al", 2.7F, Type.METALLOID, 0xB3B3B3, 3, Hardness.MEDIUM);
	public static Element SILICON = new Element("Silicon", "Si", 2.3F, Type.METALLOID, 0xCFE8E6, 3, Hardness.LOW);
	public static Element PHOSPHORUS = new Element("Phosphorus", "P", 1.8F, Type.METALLOID, 0xB5917B, 3, Hardness.LOW);
	public static Element SULFUR = new Element("Sulfur", "S", 2.0F, Type.METALLOID, 0xFFFEAB, 3, Hardness.LOW);
	public static Element CHLORINE = new Element("Chlorine", "Cl", 3.2F, Type.HALOGEN, 0xE8FFA3, 3);
	public static Element ARGON = new Element("Argon", "Ar", 1.8F, Type.NOBLE_GAS, 0xffffff, 3);
	public static Element POTASSIUM = new Element("Potassium", "K", 0.9F, Type.ALKALINE_METAL, 0xA1A1A1, 4, Hardness.LOW);
	public static Element CALCIUM = new Element("Calcium", "Ca", 1.6F, Type.EARTH_METAL, 0xEFEFEF, 4, Hardness.LOW);
	public static Element SCANDIUM = new Element("Scandium", "Sc", 3.0F, Type.TRANSITION, 0xE3E3CF, 4, Hardness.EXTREME);
	public static Element TITANIUM = new Element("Titanium", "Ti", 4.5F, Type.TRANSITION, 0xB0B0B0, 4, Hardness.EXTREME);
	public static Element VANADIUM = new Element("Vanadium", "V", 6.1F, Type.TRANSITION, 0x9595AB, 4, Hardness.EXTREME);
	public static Element CHROMIUM = new Element("Chromium", "Cr", 7.1F, Type.TRANSITION, 0xE0E0E0, 4, Hardness.EXTREME);
	public static Element MANGANESE = new Element("Manganese", "Mn", 7.5F, Type.TRANSITION, 0xD9D9D9, 4, Hardness.MEDIUM);
	public static Element IRON = new Element("Iron", "Fe", 7.9F, Type.TRANSITION, 0xE0E0E0, 4, Hardness.HIGH);
	public static Element COBALT = new Element("Cobalt", "Co", 8.9F, Type.TRANSITION, 0xC5C6DB, 4, Hardness.EXTREME);
	public static Element NICKEL = new Element("Nickel", "Ni", 8.9F, Type.TRANSITION, 0xE6ECED, 4, Hardness.EXTREME);
	public static Element COPPER = new Element("Copper", "Cu", 8.9F, Type.TRANSITION, 0xFFE4D9, 4, Hardness.HIGH);
	public static Element ZINC = new Element("Zinc", "Zn", 7.1F, Type.TRANSITION, 0xF0F0F0, 4, Hardness.HIGH);
	public static Element GALLIUM = new Element("Gallium", "Ga", 5.9F, Type.TRANSITION, 0xE8E8E8, 4, Hardness.LOW);
	public static Element GERMANIUM = new Element("Germanium", "Ge", 5.3F, Type.NON_METAL, 0xEDE8E8, 4, Hardness.LOW);
	public static Element ARSENIC = new Element("Arsenic", "As", 5.7F, Type.NON_METAL, 0xEDEDED, 4, Hardness.EXTREME);
	public static Element SELENIUM = new Element("Selenium", "Se", 4.8F, Type.NON_METAL, 0xFFC2C2, 4, Hardness.HIGH);
	public static Element BROMINE = new Element("Bromine", "Br", 3.1F, Type.HALOGEN, 0xE1B6E3, 4);
	public static Element KRYPTON = new Element("Krypton", "Kr", 3.8F, Type.NOBLE_GAS, 0xffffff, 4);
	public static Element RUBIDIUM = new Element("Rubidium", "Rb", 1.5F, Type.ALKALINE_METAL, 0xDEDEDE, 5, Hardness.NA);
}
