package com.tinkerlad.chemistry;

import com.tinkerlad.chemistry.block.BlockList;
import com.tinkerlad.chemistry.item.ItemList;
import com.tinkerlad.chemistry.logging.LogHelper;
import com.tinkerlad.chemistry.registry.Register;
import com.tinkerlad.chemistry.utils.ElementTypeConverter;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import static cpw.mods.fml.common.Mod.EventHandler;
import static cpw.mods.fml.common.Mod.Instance;

@Mod(modid = Chemistry.MODID, name = "Periodic Production", version = "@VERSION@")
public class Chemistry {

	public static final String MODID = "tnkchem";

	@Instance(value = "Periodic Production")
	public static Chemistry instance;

	public static BlockList blockList = new BlockList();
	public static ItemList itemList = new ItemList();
	public static ElementTypeConverter converter = new ElementTypeConverter();

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		LogHelper.logger = event.getModLog();

		Register.registerBlocks();
		Register.registerItems();
	}
}


