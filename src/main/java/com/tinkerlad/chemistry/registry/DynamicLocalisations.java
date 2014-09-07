package com.tinkerlad.chemistry.registry;

import cpw.mods.fml.common.registry.LanguageRegistry;

import java.util.HashMap;

public class DynamicLocalisations {

    private HashMap<String, String> localisations = new HashMap<String, String>();

    public void registerLocalisations() {
        LanguageRegistry.instance().injectLanguage("en_US", localisations);
    }

    public void addLocalisation(String itemName, String localisation) {
        localisations.put(itemName + ".name",
                localisation);
    }
}
