package com.tinkerlad.chemistry.item;

import com.tinkerlad.chemistry.reference.AlloyList;
import com.tinkerlad.chemistry.reference.ElementList;
import com.tinkerlad.chemistry.registry.RegisterItem;

public class ItemList {

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

	//Alloys xD
	@RegisterItem(itemName = "sodiumChloride")
	public static ItemAlloy ALLOY_NACL = new ItemAlloy(AlloyList.NaCl);
}
