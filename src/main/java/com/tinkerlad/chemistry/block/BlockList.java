package com.tinkerlad.chemistry.block;

import com.tinkerlad.chemistry.block.element.BlockElementBase;
import com.tinkerlad.chemistry.block.element.OreElementBase;
import com.tinkerlad.chemistry.block.machine.siphon.BlockElementSiphon;
import com.tinkerlad.chemistry.reference.ElementList;
import com.tinkerlad.chemistry.registry.RegisterBlock;
import com.tinkerlad.chemistry.registry.RegisterOreGen;

public class BlockList {

	//Machines

	@RegisterBlock(blockName = "machineSiphon")
	public static BlockElementSiphon MACHINE_SIPHON = new BlockElementSiphon();

	//Elements
	@RegisterOreGen(partsPerMillion = 0.00002)
	@RegisterBlock(blockName = "oreLithium")
	public static OreElementBase ORE_LITHIUM = new OreElementBase(ElementList.LITHIUM);

	@RegisterOreGen(partsPerMillion = 0.0000028)
	@RegisterBlock(blockName = "oreBeryllium")
	public static OreElementBase ORE_BERYLLIUM = new OreElementBase(ElementList.BERYLLIUM);

	@RegisterOreGen(partsPerMillion = 0.00001)
	@RegisterBlock(blockName = "oreBoron")
	public static OreElementBase ORE_BORON = new OreElementBase(ElementList.BORON);

	@RegisterOreGen(partsPerMillion = 0.0002)
	@RegisterBlock(blockName = "oreCarbon")
	public static OreElementBase ORE_CARBON = new OreElementBase(ElementList.CARBON);

	@RegisterOreGen(partsPerMillion = 0.0236)
	@RegisterBlock(blockName = "oreSodium")
	public static OreElementBase ORE_SODIUM = new OreElementBase(ElementList.SODIUM);

	@RegisterOreGen(partsPerMillion = 0.0233)
	@RegisterBlock(blockName = "oreMagnesium")
	public static OreElementBase ORE_MAGNESIUM = new OreElementBase(ElementList.MAGNESIUM);

	@RegisterOreGen(partsPerMillion = 0.0823)
	@RegisterBlock(blockName = "oreAluminium")
	public static OreElementBase ORE_ALUMINIUM = new OreElementBase(ElementList.ALUMINIUM);

	@RegisterOreGen(partsPerMillion = 0.282)
	@RegisterBlock(blockName = "oreSilicon")
	public static OreElementBase ORE_SILICON = new OreElementBase(ElementList.SILICON);

	@RegisterOreGen(partsPerMillion = 0.00105)
	@RegisterBlock(blockName = "orePhosphorus")
	public static OreElementBase ORE_PHOSPHORUS = new OreElementBase(ElementList.PHOSPHORUS);

	@RegisterOreGen(partsPerMillion = 0.00035)
	@RegisterBlock(blockName = "oreSulfur")
	public static OreElementBase ORE_SULFUR = new OreElementBase(ElementList.SULFUR);

	@RegisterOreGen(partsPerMillion = 0.029)
	@RegisterBlock(blockName = "orePotassium")
	public static OreElementBase ORE_POTASSIUM = new OreElementBase(ElementList.POTASSIUM);

	@RegisterOreGen(partsPerMillion = 0.0415)
	@RegisterBlock(blockName = "oreCalcium")
	public static OreElementBase ORE_CALCIUM = new OreElementBase(ElementList.CALCIUM);

	@RegisterOreGen(partsPerMillion = 0.000022)
	@RegisterBlock(blockName = "oreScandium")
	public static OreElementBase ORE_SCANDIUM = new OreElementBase(ElementList.SCANDIUM);

	@RegisterOreGen(partsPerMillion = 0.00565)
	@RegisterBlock(blockName = "oreTitanium")
	public static OreElementBase ORE_TITANIUM = new OreElementBase(ElementList.TITANIUM);

	@RegisterOreGen(partsPerMillion = 0.00014)
	@RegisterBlock(blockName = "oreVanadium")
	public static OreElementBase ORE_VANADIUM = new OreElementBase(ElementList.VANADIUM);

	@RegisterOreGen(partsPerMillion = 0.000102)
	@RegisterBlock(blockName = "oreChromium")
	public static OreElementBase ORE_CHROMIUM = new OreElementBase(ElementList.CHROMIUM);

	@RegisterOreGen(partsPerMillion = 0.00095)
	@RegisterBlock(blockName = "oreManganese")
	public static OreElementBase ORE_MANGANESE = new OreElementBase(ElementList.MANGANESE);

	@RegisterOreGen(partsPerMillion = 0.0563)
	@RegisterBlock(blockName = "oreIron")
	public static OreElementBase ORE_IRON = new OreElementBase(ElementList.IRON);

	@RegisterOreGen(partsPerMillion = 0.000025)
	@RegisterBlock(blockName = "oreCobalt")
	public static OreElementBase ORE_COBALT = new OreElementBase(ElementList.COBALT);

	@RegisterOreGen(partsPerMillion = 0.000084)
	@RegisterBlock(blockName = "oreNickel")
	public static OreElementBase ORE_NICKEL = new OreElementBase(ElementList.NICKEL);

	@RegisterOreGen(partsPerMillion = 0.00006)
	@RegisterBlock(blockName = "oreCopper")
	public static OreElementBase ORE_COPPER = new OreElementBase(ElementList.COPPER);

	@RegisterOreGen(partsPerMillion = 0.00007)
	@RegisterBlock(blockName = "oreZinc")
	public static OreElementBase ORE_ZINC = new OreElementBase(ElementList.ZINC);

	@RegisterOreGen(partsPerMillion = 0.000019)
	@RegisterBlock(blockName = "oreGallium")
	public static OreElementBase ORE_GALLIUM = new OreElementBase(ElementList.GALLIUM);

	@RegisterOreGen(partsPerMillion = 0.0000015)
	@RegisterBlock(blockName = "oreGermanium")
	public static OreElementBase ORE_GERMANIUM = new OreElementBase(ElementList.GERMANIUM);

	@RegisterOreGen(partsPerMillion = 0.0000018)
	@RegisterBlock(blockName = "oreArsenic")
	public static OreElementBase ORE_ARSENIC = new OreElementBase(ElementList.ARSENIC);

	@RegisterOreGen(partsPerMillion = 0.00000005)
	@RegisterBlock(blockName = "oreSelenium")
	public static OreElementBase ORE_SELENIUM = new OreElementBase(ElementList.SELENIUM);

	@RegisterOreGen(partsPerMillion = 0.00009)
	@RegisterBlock(blockName = "oreRubidium")
	public static OreElementBase ORE_RUBIDIUM = new OreElementBase(ElementList.RUBIDIUM);


	/******************************End of Base Elements*****************************************/
	/**
	 * *************************Begin 'Pure' Element Blocks***********************************
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
