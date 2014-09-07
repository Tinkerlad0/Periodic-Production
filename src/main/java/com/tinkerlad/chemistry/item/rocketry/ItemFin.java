package com.tinkerlad.chemistry.item.rocketry;

import com.tinkerlad.chemistry.creativetab.CreativeTab;
import com.tinkerlad.chemistry.item.rocketry.base.BaseFin;

public class ItemFin extends BaseFin {

    public ItemFin(String itemName) {
        super(itemName);
        this.setCreativeTab(CreativeTab.ROCKETRY_TAB);
    }
}
