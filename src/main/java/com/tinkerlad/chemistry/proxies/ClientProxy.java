package com.tinkerlad.chemistry.proxies;

import com.tinkerlad.chemistry.block.machine.alloyMaker.TileEntityAlloyMaker;
import com.tinkerlad.chemistry.block.machine.alloyMaker.TileEntityAlloyMakerRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {

	@Override

	public void registerRenderers() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAlloyMaker.class, new TileEntityAlloyMakerRenderer());
	}
}
