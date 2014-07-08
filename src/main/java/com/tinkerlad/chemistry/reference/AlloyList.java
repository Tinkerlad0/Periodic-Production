package com.tinkerlad.chemistry.reference;

import com.tinkerlad.chemistry.reference.dataTypes.Alloy;
import com.tinkerlad.chemistry.reference.dataTypes.AlloyComponent;

import java.util.Arrays;

public class AlloyList {

	public static final Alloy NaCl = new Alloy(Alloy.CompoundType.IONIC, Alloy.State.SOLID, 0xEEEEEF,
			                                          Arrays.asList(new AlloyComponent(ElementList.SODIUM, 1),
					                                                       new AlloyComponent(ElementList.CHLORINE,
							                                                                         1)
			                                          ), "Salt"
	);
}
