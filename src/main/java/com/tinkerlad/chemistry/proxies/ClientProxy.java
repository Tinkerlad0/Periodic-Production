package com.tinkerlad.chemistry.proxies;

import com.tinkerlad.chemistry.block.machine.alloyMaker.TileEntityAlloyMaker;
import com.tinkerlad.chemistry.block.machine.alloyMaker.TileEntityAlloyMakerRenderer;
import com.tinkerlad.chemistry.entity.rockets.EntityBasicRocket;
import com.tinkerlad.chemistry.entity.rockets.RenderBasicRocket;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	@Override

	public void registerRenderers() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAlloyMaker.class, new TileEntityAlloyMakerRenderer());
		RenderingRegistry.registerEntityRenderingHandler(EntityBasicRocket.class, new RenderBasicRocket());
	}
}
