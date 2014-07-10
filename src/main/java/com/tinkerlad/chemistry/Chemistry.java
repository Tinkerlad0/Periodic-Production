package com.tinkerlad.chemistry;

import com.tinkerlad.chemistry.block.BlockList;
import com.tinkerlad.chemistry.block.machine.TileEntitySiphon;
import com.tinkerlad.chemistry.item.ItemList;
import com.tinkerlad.chemistry.logging.LogHelper;
import com.tinkerlad.chemistry.reference.ElementList;
import com.tinkerlad.chemistry.reference.ElementMaterials;
import com.tinkerlad.chemistry.reference.ElementTools;
import com.tinkerlad.chemistry.reference.recipes.ElementCommonRecipes;
import com.tinkerlad.chemistry.registry.DynamicLocalisations;
import com.tinkerlad.chemistry.registry.Register;
import com.tinkerlad.chemistry.rendering.gui.GUIHandler;
import com.tinkerlad.chemistry.utils.ElementTypeConverter;
import com.tinkerlad.chemistry.world.OreGen;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

import static cpw.mods.fml.common.Mod.EventHandler;
import static cpw.mods.fml.common.Mod.Instance;

@Mod(modid = Chemistry.MODID, name = "Periodic Production", version = "@VERSION@")
public class Chemistry {

	public static final String MODID = "tnkchem";
	public static final DynamicLocalisations localiser = new DynamicLocalisations();
	public static final OreGen oreGen = new OreGen();
	public static final BlockList blockList = new BlockList();
	public static final ElementList elementList = new ElementList();
	public static final ItemList itemList = new ItemList();
	public static final ElementMaterials elementMaterials = new ElementMaterials();
	public static final ElementTypeConverter converter = new ElementTypeConverter();
	public static final ElementTools elementTools = new ElementTools();
	@Instance(MODID)
	public static Chemistry instance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		LogHelper.logger = event.getModLog();

		Register.registerBlocks();
		Register.registerItems();

		elementMaterials.initMaterials();
		elementTools.initPickaxes();
		elementTools.initSwords();
		elementTools.initAxes();
		elementTools.initHoes();
		elementTools.initShovels();

		ElementCommonRecipes.init();

		oreGen.getDefaultOres();

		GameRegistry.registerWorldGenerator(oreGen, 0);

		localiser.registerLocalisations();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GUIHandler());
		GameRegistry.registerTileEntity(TileEntitySiphon.class, "tile.siphon");
	}
}


