package com.tinkerlad.chemistry.creativetab;

import com.tinkerlad.chemistry.item.ItemList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTab {

    public static final CreativeTabs ELEMENTS_TAB = new CreativeTabs("PPElement") {
        @Override
        public Item getTabIconItem() {
            return ItemList.DUST_PHOSPHORUS;
        }
    };

    public static final CreativeTabs ALLOYS_TAB = new CreativeTabs("PPAlloy") {
        @Override
        public Item getTabIconItem() {
            return ItemList.CATALYST_BASIC;
        }
    };

    public static final CreativeTabs MACHINE_TAB = new CreativeTabs("PPMachine") {
        @Override
        public Item getTabIconItem() {
            return ItemList.CANISTER_ZINC_SULFUR;
        }
    };

    public static final CreativeTabs ROCKETRY_TAB = new CreativeTabs("PPRocketry") {
        @Override
        public Item getTabIconItem() {
            return ItemList.CANISTER_ZINC_SULFUR;
        }
    };
}
