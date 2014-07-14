package com.tinkerlad.chemistry.config;

import com.tinkerlad.chemistry.Chemistry;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {

	public static Configuration configuration;

	public static boolean DEBUG = false;
	public static boolean VERBOSE = false;

	public static void preInit(File suggestedConfigurationFile) {
		configuration = new Configuration(suggestedConfigurationFile);
		syncConfig();
	}

	public static void syncConfig() {

		DEBUG = configuration.getBoolean("Debug Mode", Configuration.CATEGORY_GENERAL, DEBUG,
				                                "Output debug info to console?");
		VERBOSE = configuration.getBoolean("Verbose Mode", Configuration.CATEGORY_GENERAL, VERBOSE,
				                                  "Spam the console with info?");

		if (configuration.hasChanged()) {configuration.save();}
	}

	@SubscribeEvent
	public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
		if (eventArgs.modID.equals(Chemistry.MODID)) { syncConfig(); }
	}
}
