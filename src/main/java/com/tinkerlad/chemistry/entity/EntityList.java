package com.tinkerlad.chemistry.entity;

import com.tinkerlad.chemistry.Chemistry;
import com.tinkerlad.chemistry.entity.rockets.EntityBasicRocket;
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityList {

    public static void init() {
        EntityRegistry.registerModEntity(EntityBasicRocket.class, "Basic Rocket", 0, Chemistry.instance, 100, 3, true);
    }
}
