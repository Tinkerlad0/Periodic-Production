package com.tinkerlad.chemistry.utils;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class Ticker {

	protected int ticks;

	public Ticker() {
		FMLCommonHandler.instance().bus().register(this);
	}

	public int getTicks() {
		return ticks;
	}

	@SubscribeEvent
	public void tick(TickEvent event) {
		ticks++;
	}
}
