package com.tinkerlad.chemistry.item.rocketry.base;

import com.tinkerlad.chemistry.item.ItemGeneric;

public class BaseFin extends ItemGeneric {

	public BaseFin(String itemName, int colour) {
		super(itemName, colour);
		this.setCreativeTab(null);
	}

	public BaseFin(String itemName) {
		super(itemName);
	}
}
