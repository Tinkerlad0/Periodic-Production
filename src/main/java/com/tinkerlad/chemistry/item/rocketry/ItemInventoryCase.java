package com.tinkerlad.chemistry.item.rocketry;

import com.tinkerlad.chemistry.creativetab.CreativeTab;
import com.tinkerlad.chemistry.item.rocketry.base.BaseModule;

public class ItemInventoryCase extends BaseModule {

	public ItemInventoryCase(String itemName) {
		super(itemName);
		this.setCreativeTab(CreativeTab.ROCKETRY_TAB);
	}
}
