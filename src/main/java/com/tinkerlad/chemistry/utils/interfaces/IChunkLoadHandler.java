package com.tinkerlad.chemistry.utils.interfaces;

import net.minecraftforge.common.ForgeChunkManager;

public interface IChunkLoadHandler {
	public void chunkLoaderInit(ForgeChunkManager.Ticket ticket);
}
