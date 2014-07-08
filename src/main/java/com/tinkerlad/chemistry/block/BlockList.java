package com.tinkerlad.chemistry.block;

import com.tinkerlad.chemistry.block.element.BlockElementBase;
import com.tinkerlad.chemistry.block.element.OreElementBase;
import com.tinkerlad.chemistry.block.machine.BlockElementSiphon;
import com.tinkerlad.chemistry.reference.ElementList;
import com.tinkerlad.chemistry.registry.RegisterBlock;

public class BlockList {

	//Machines

	@RegisterBlock(blockName = "machineSiphon")
	public static BlockElementSiphon MACHINE_SIPHON = new BlockElementSiphon();


//Elements

	@RegisterBlock(blockName = "oreLithium")
	public static OreElementBase ORE_LITHIUM = new OreElementBase(ElementList.LITHIUM);

	@RegisterBlock(blockName = "oreBeryllium")
	public static OreElementBase ORE_BERYLLIUM = new OreElementBase(ElementList.BERYLLIUM);

	@RegisterBlock(blockName = "oreBoron")
	public static OreElementBase ORE_BORON = new OreElementBase(ElementList.BORON);

	@RegisterBlock(blockName = "oreCarbon")
	public static OreElementBase ORE_CARBON = new OreElementBase(ElementList.CARBON);

	@RegisterBlock(blockName = "oreSodium")
	public static OreElementBase ORE_SODIUM = new OreElementBase(ElementList.SODIUM);

	@RegisterBlock(blockName = "oreMagnesium")
	public static OreElementBase ORE_MAGNESIUM = new OreElementBase(ElementList.MAGNESIUM);

	@RegisterBlock(blockName = "oreAluminium")
	public static OreElementBase ORE_ALUMINIUM = new OreElementBase(ElementList.ALUMINIUM);

	@RegisterBlock(blockName = "oreSilicon")
	public static OreElementBase ORE_SILICON = new OreElementBase(ElementList.SILICON);

	@RegisterBlock(blockName = "orePhosphorus")
	public static OreElementBase ORE_PHOSPHORUS = new OreElementBase(ElementList.PHOSPHORUS);

	@RegisterBlock(blockName = "oreSulfur")
	public static OreElementBase ORE_SULFUR = new OreElementBase(ElementList.SULFUR);

	@RegisterBlock(blockName = "orePotassium")
	public static OreElementBase ORE_POTASSIUM = new OreElementBase(ElementList.POTASSIUM);

	@RegisterBlock(blockName = "oreCalcium")
	public static OreElementBase ORE_CALCIUM = new OreElementBase(ElementList.CALCIUM);

	@RegisterBlock(blockName = "oreScandium")
	public static OreElementBase ORE_SCANDIUM = new OreElementBase(ElementList.SCANDIUM);

	@RegisterBlock(blockName = "oreTitanium")
	public static OreElementBase ORE_TITANIUM = new OreElementBase(ElementList.TITANIUM);

	@RegisterBlock(blockName = "oreVanadium")
	public static OreElementBase ORE_VANADIUM = new OreElementBase(ElementList.VANADIUM);

	@RegisterBlock(blockName = "oreChromium")
	public static OreElementBase ORE_CHROMIUM = new OreElementBase(ElementList.CHROMIUM);

	@RegisterBlock(blockName = "oreManganese")
	public static OreElementBase ORE_MANGANESE = new OreElementBase(ElementList.MANGANESE);

	@RegisterBlock(blockName = "oreIron")
	public static OreElementBase ORE_IRON = new OreElementBase(ElementList.IRON);

	@RegisterBlock(blockName = "oreCobalt")
	public static OreElementBase ORE_COBALT = new OreElementBase(ElementList.COBALT);

	@RegisterBlock(blockName = "oreNickel")
	public static OreElementBase ORE_NICKEL = new OreElementBase(ElementList.NICKEL);

	@RegisterBlock(blockName = "oreCopper")
	public static OreElementBase ORE_COPPER = new OreElementBase(ElementList.COPPER);

	@RegisterBlock(blockName = "oreZinc")
	public static OreElementBase ORE_ZINC = new OreElementBase(ElementList.ZINC);

	@RegisterBlock(blockName = "oreGallium")
	public static OreElementBase ORE_GALLIUM = new OreElementBase(ElementList.GALLIUM);

	@RegisterBlock(blockName = "oreGermanium")
	public static OreElementBase ORE_GERMANIUM = new OreElementBase(ElementList.GERMANIUM);

	@RegisterBlock(blockName = "oreArsenic")
	public static OreElementBase ORE_ARSENIC = new OreElementBase(ElementList.ARSENIC);

	@RegisterBlock(blockName = "oreSelenium")
	public static OreElementBase ORE_SELENIUM = new OreElementBase(ElementList.SELENIUM);

	@RegisterBlock(blockName = "oreRubidium")
	public static OreElementBase ORE_RUBIDIUM = new OreElementBase(ElementList.RUBIDIUM);


	/******************************End of Base Elements*****************************************/
	/**
	 * ***************************Begin 'Pure; Element Blocks*********************************
	 */

	@RegisterBlock(blockName = "blockLithium")
	public static BlockElementBase BLOCK_LITHIUM = new BlockElementBase(ElementList.LITHIUM);

	@RegisterBlock(blockName = "blockBeryllium")
	public static BlockElementBase BLOCK_BERYLLIUM = new BlockElementBase(ElementList.BERYLLIUM);

	@RegisterBlock(blockName = "blockBoron")
	public static BlockElementBase BLOCK_BORON = new BlockElementBase(ElementList.BORON);

	@RegisterBlock(blockName = "blockCarbon")
	public static BlockElementBase BLOCK_CARBON = new BlockElementBase(ElementList.CARBON);

	@RegisterBlock(blockName = "blockSodium")
	public static BlockElementBase BLOCK_SODIUM = new BlockElementBase(ElementList.SODIUM);

	@RegisterBlock(blockName = "blockMagnesium")
	public static BlockElementBase BLOCK_MAGNESIUM = new BlockElementBase(ElementList.MAGNESIUM);

	@RegisterBlock(blockName = "blockAluminium")
	public static BlockElementBase BLOCK_ALUMINIUM = new BlockElementBase(ElementList.ALUMINIUM);

	@RegisterBlock(blockName = "blockSilicon")
	public static BlockElementBase BLOCK_SILICON = new BlockElementBase(ElementList.SILICON);

	@RegisterBlock(blockName = "blockPhosphorus")
	public static BlockElementBase BLOCK_PHOSPHORUS = new BlockElementBase(ElementList.PHOSPHORUS);

	@RegisterBlock(blockName = "blockSulfur")
	public static BlockElementBase BLOCK_SULFUR = new BlockElementBase(ElementList.SULFUR);

	@RegisterBlock(blockName = "blockPotassium")
	public static BlockElementBase BLOCK_POTASSIUM = new BlockElementBase(ElementList.POTASSIUM);

	@RegisterBlock(blockName = "blockCalcium")
	public static BlockElementBase BLOCK_CALCIUM = new BlockElementBase(ElementList.CALCIUM);

	@RegisterBlock(blockName = "blockScandium")
	public static BlockElementBase BLOCK_SCANDIUM = new BlockElementBase(ElementList.SCANDIUM);

	@RegisterBlock(blockName = "blockTitanium")
	public static BlockElementBase BLOCK_TITANIUM = new BlockElementBase(ElementList.TITANIUM);

	@RegisterBlock(blockName = "blockVanadium")
	public static BlockElementBase BLOCK_VANADIUM = new BlockElementBase(ElementList.VANADIUM);

	@RegisterBlock(blockName = "blockChromium")
	public static BlockElementBase BLOCK_CHROMIUM = new BlockElementBase(ElementList.CHROMIUM);

	@RegisterBlock(blockName = "blockManganese")
	public static BlockElementBase BLOCK_MANGANESE = new BlockElementBase(ElementList.MANGANESE);

	@RegisterBlock(blockName = "blockIron")
	public static BlockElementBase BLOCK_IRON = new BlockElementBase(ElementList.IRON);

	@RegisterBlock(blockName = "blockCobalt")
	public static BlockElementBase BLOCK_COBALT = new BlockElementBase(ElementList.COBALT);

	@RegisterBlock(blockName = "blockNickel")
	public static BlockElementBase BLOCK_NICKEL = new BlockElementBase(ElementList.NICKEL);

	@RegisterBlock(blockName = "blockCopper")
	public static BlockElementBase BLOCK_COPPER = new BlockElementBase(ElementList.COPPER);

	@RegisterBlock(blockName = "blockZinc")
	public static BlockElementBase BLOCK_ZINC = new BlockElementBase(ElementList.ZINC);

	@RegisterBlock(blockName = "blockGallium")
	public static BlockElementBase BLOCK_GALLIUM = new BlockElementBase(ElementList.GALLIUM);

	@RegisterBlock(blockName = "blockGermanium")
	public static BlockElementBase BLOCK_GERMANIUM = new BlockElementBase(ElementList.GERMANIUM);

	@RegisterBlock(blockName = "blockArsenic")
	public static BlockElementBase BLOCK_ARSENIC = new BlockElementBase(ElementList.ARSENIC);

	@RegisterBlock(blockName = "blockSelenium")
	public static BlockElementBase BLOCK_SELENIUM = new BlockElementBase(ElementList.SELENIUM);

	@RegisterBlock(blockName = "blockRubidium")
	public static BlockElementBase BLOCK_RUBIDIUM = new BlockElementBase(ElementList.RUBIDIUM);
}
