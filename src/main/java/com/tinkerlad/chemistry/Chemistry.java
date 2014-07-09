package com.tinkerlad.chemistry;

import com.tinkerlad.chemistry.block.BlockList;
import com.tinkerlad.chemistry.block.machine.TileEntitySiphon;
import com.tinkerlad.chemistry.item.ItemList;
import com.tinkerlad.chemistry.logging.LogHelper;
import com.tinkerlad.chemistry.reference.ElementList;
import com.tinkerlad.chemistry.reference.ElementMaterials;
import com.tinkerlad.chemistry.reference.ElementTools;
import com.tinkerlad.chemistry.registry.DynamicLocalisations;
import com.tinkerlad.chemistry.registry.Register;
import com.tinkerlad.chemistry.rendering.gui.GUIHandler;
import com.tinkerlad.chemistry.utils.ElementTypeConverter;
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
	public static final BlockList blockList = new BlockList();
	@Instance(MODID)
	public static Chemistry instance;
	public static ElementList elementList = new ElementList();
	public static ItemList itemList = new ItemList();
	public static ElementMaterials elementMaterials = new ElementMaterials();
	public static ElementTypeConverter converter = new ElementTypeConverter();
	public static ElementTools elementTools = new ElementTools();
	public static DynamicLocalisations localiser = new DynamicLocalisations();

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

		localiser.registerLocalisations();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GUIHandler());
		GameRegistry.registerTileEntity(TileEntitySiphon.class, "tile.siphon");
	}
}


