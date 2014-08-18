package com.tinkerlad.chemistry.item.rocketry.base;

import com.tinkerlad.chemistry.item.ItemGeneric;

public class BaseModule extends ItemGeneric {

	public BaseModule(String itemName) {
		super(itemName);
		this.setCreativeTab(null);
	}

	public BaseModule(String itemName, int colour) {
		super(itemName, colour);
	}
}
