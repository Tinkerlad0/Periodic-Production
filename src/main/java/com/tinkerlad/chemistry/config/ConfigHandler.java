package com.tinkerlad.chemistry.config;

import com.tinkerlad.chemistry.Chemistry;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {

	public Configuration configuration;

	public boolean DEBUG = false;
	public boolean VERBOSE = false;

	public ConfigHandler() {
		FMLCommonHandler.instance().bus().register(this);
	}

	public void preInit(File suggestedConfigurationFile) {
		configuration = new Configuration(suggestedConfigurationFile);
		syncConfig();
	}

	public void syncConfig() {

		DEBUG = configuration.getBoolean("Debug Mode", Configuration.CATEGORY_GENERAL, DEBUG,
				                                "Output debug info to console?");
		VERBOSE = configuration.getBoolean("Verbose Mode", Configuration.CATEGORY_GENERAL, VERBOSE,
				                                  "Spam the console with info?");

		if (configuration.hasChanged()) {configuration.save();}
	}

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
		if (eventArgs.modID.equals(Chemistry.MODID)) { syncConfig(); }
	}
}
