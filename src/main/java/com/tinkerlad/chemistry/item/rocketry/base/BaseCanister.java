package com.tinkerlad.chemistry.item.rocketry.base;

import com.tinkerlad.chemistry.item.ItemGeneric;

public class BaseCanister extends ItemGeneric {

	public BaseCanister(String itemName, int colour) {
		super(itemName, colour);
		this.setCreativeTab(null);
	}

	public BaseCanister(String itemName) {
		super(itemName);
	}
}
