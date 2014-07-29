package com.tinkerlad.chemistry.reference;

import com.tinkerlad.chemistry.reference.dataTypes.Element;

import static com.tinkerlad.chemistry.reference.dataTypes.Element.Hardness;
import static com.tinkerlad.chemistry.reference.dataTypes.Element.Type;

public class ElementList {

	public static final Element HYDROGEN = new Element("Hydrogen", "H", 0.0F, Type.GAS, 0xffffff, 1, 1);
	public static final Element HELIUM = new Element("Helium", "He", 0.1F, Type.NOBLE_GAS, 0xffffff, 1, 2);
	public static final Element LITHIUM = new Element("Lithium", "Li", 0.5F, Type.ALKALINE_METAL, 0xCCCCCC, 2,
			                                                 Hardness.LOW, 3);
	public static final Element BERYLLIUM = new Element("Beryllium", "Be", 1.85F, Type.EARTH_METAL, 0xBDBAB3, 2,
			                                                   Hardness.LOW, 4);
	public static final Element BORON = new Element("Boron", "B", 2.5F, Type.METALLOID, 0x999999, 2, Hardness.LOW, 5);
	public static final Element CARBON = new Element("Carbon", "C", 2.3F, Type.METALLOID, 0x999999, 2, Hardness.LOW, 6);
	public static final Element NITROGEN = new Element("Nitrogen", "N", 1.3F, Type.GAS, 0xffffff, 2, 7);
	public static final Element OXYGEN = new Element("Oxygen", "O", 1.4F, Type.GAS, 0xffffff, 2, 8);
	public static final Element FLUORINE = new Element("Fluorine", "F", 1.7F, Type.HALOGEN, 0xffffff, 2, 9);
	public static final Element NEON = new Element("Neon", "Ne", 0.9F, Type.NOBLE_GAS, 0xB8FFA6, 2, 10);
	public static final Element SODIUM = new Element("Sodium", "Na", 1.0F, Type.ALKALINE_METAL, 0xDBD8CE, 3, Hardness.LOW, 11);
	public static final Element MAGNESIUM = new Element("Magnesium", "Mg", 1.7F, Type.EARTH_METAL, 0xDBDBDB, 3,
			                                                   Hardness.LOW, 12);
	public static final Element ALUMINIUM = new Element("Aluminium", "Al", 2.7F, Type.METALLOID, 0xB3B3B3, 3,
			                                                   Hardness.MEDIUM, 13);
	public static final Element SILICON = new Element("Silicon", "Si", 2.3F, Type.METALLOID, 0xCFE8E6, 3, Hardness.LOW, 14);
	public static final Element PHOSPHORUS = new Element("Phosphorus", "P", 1.8F, Type.METALLOID, 0xB5917B, 3,
			                                                    Hardness.LOW, 15);
	public static final Element SULFUR = new Element("Sulfur", "S", 2.0F, Type.METALLOID, 0xFFFEAB, 3, Hardness.LOW, 16);
	public static final Element CHLORINE = new Element("Chlorine", "Cl", 3.2F, Type.HALOGEN, 0xE8FFA3, 3, 17);
	public static final Element ARGON = new Element("Argon", "Ar", 1.8F, Type.NOBLE_GAS, 0xffffff, 3, 18);
	public static final Element POTASSIUM = new Element("Potassium", "K", 0.9F, Type.ALKALINE_METAL, 0xA1A1A1, 4,
			                                                   Hardness.LOW, 19);
	public static final Element CALCIUM = new Element("Calcium", "Ca", 1.6F, Type.EARTH_METAL, 0xEFEFEF, 4, Hardness.LOW, 20);
	public static final Element SCANDIUM = new Element("Scandium", "Sc", 3.0F, Type.TRANSITION, 0xE3E3CF, 4,
			                                                  Hardness.EXTREME, 21);
	public static final Element TITANIUM = new Element("Titanium", "Ti", 4.5F, Type.TRANSITION, 0xB0B0B0, 4,
			                                                  Hardness.EXTREME, 22);
	public static final Element VANADIUM = new Element("Vanadium", "V", 6.1F, Type.TRANSITION, 0x9595AB, 4,
			                                                  Hardness.EXTREME, 23);
	public static final Element CHROMIUM = new Element("Chromium", "Cr", 7.1F, Type.TRANSITION, 0xE0E0E0, 4,
			                                                  Hardness.EXTREME, 24);
	public static final Element MANGANESE = new Element("Manganese", "Mn", 7.5F, Type.TRANSITION, 0xD9D9D9, 4,
			                                                   Hardness.MEDIUM, 25);
	public static final Element IRON = new Element("Iron", "Fe", 7.9F, Type.TRANSITION, 0xE0E0E0, 4, Hardness.HIGH, 26);
	public static final Element COBALT = new Element("Cobalt", "Co", 8.9F, Type.TRANSITION, 0xC5C6DB, 4, Hardness.EXTREME, 27);
	public static final Element NICKEL = new Element("Nickel", "Ni", 8.9F, Type.TRANSITION, 0xE6ECED, 4, Hardness.EXTREME, 28);
	public static final Element COPPER = new Element("Copper", "Cu", 8.9F, Type.TRANSITION, 0xFFE4D9, 4, Hardness.HIGH, 29);
	public static final Element ZINC = new Element("Zinc", "Zn", 7.1F, Type.TRANSITION, 0xF0F0F0, 4, Hardness.HIGH, 30);
	public static final Element GALLIUM = new Element("Gallium", "Ga", 5.9F, Type.TRANSITION, 0xE8E8E8, 4, Hardness.LOW, 31);
	public static final Element GERMANIUM = new Element("Germanium", "Ge", 5.3F, Type.NON_METAL, 0xEDE8E8, 4, Hardness.LOW,
			                                                   32);
	public static final Element ARSENIC = new Element("Arsenic", "As", 5.7F, Type.NON_METAL, 0xEDEDED, 4, Hardness.EXTREME,
			                                                 33);
	public static final Element SELENIUM = new Element("Selenium", "Se", 4.8F, Type.NON_METAL, 0xFFC2C2, 4, Hardness.HIGH, 34);
	public static final Element BROMINE = new Element("Bromine", "Br", 3.1F, Type.HALOGEN, 0xE1B6E3, 4, 35);
	public static final Element KRYPTON = new Element("Krypton", "Kr", 3.8F, Type.NOBLE_GAS, 0xffffff, 4, 36);
	public static final Element RUBIDIUM = new Element("Rubidium", "Rb", 1.5F, Type.ALKALINE_METAL, 0xDEDEDE, 5,
			                                                  Hardness.NA, 37);

	public static final Element LEAD = new Element("Lead", "Pb", 11.3F, Type.TRANSITION, 0xEBEBEB, 6, Hardness.LOW, 82);
}
