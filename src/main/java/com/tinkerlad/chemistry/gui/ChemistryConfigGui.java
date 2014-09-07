package com.tinkerlad.chemistry.gui;

import com.tinkerlad.chemistry.config.ConfigHandler;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

public class ChemistryConfigGui extends GuiConfig {

    public ChemistryConfigGui(GuiScreen parent) {
        super(parent, new ConfigElement(ConfigHandler.configuration.getCategory(Configuration
                .CATEGORY_GENERAL))
                .getChildElements(), "TestMod", true, true, ChemistryConfigGui.getAbridgedConfigPath
                (ConfigHandler.configuration.toString()));
    }
}
