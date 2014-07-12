package com.tinkerlad.chemistry.gui;

import com.tinkerlad.chemistry.Chemistry;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

public class ChemistryConfigGui extends GuiConfig {

	public ChemistryConfigGui(GuiScreen parent) {
		super(parent, new ConfigElement(Chemistry.configHandler.configuration.getCategory(Configuration
				                                                                                  .CATEGORY_GENERAL))
				              .getChildElements(), "TestMod", true, true, ChemistryConfigGui.getAbridgedConfigPath
						                                                                             (Chemistry
								                                                                              .configHandler.configuration.toString()));
	}
}
