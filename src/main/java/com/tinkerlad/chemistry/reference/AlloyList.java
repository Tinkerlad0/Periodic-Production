package com.tinkerlad.chemistry.reference;

import com.tinkerlad.chemistry.reference.dataTypes.Alloy;
import com.tinkerlad.chemistry.reference.dataTypes.AlloyComponent;

import java.util.Arrays;

import static com.tinkerlad.chemistry.reference.dataTypes.Alloy.CompoundType.*;
import static com.tinkerlad.chemistry.reference.dataTypes.Alloy.State.LIQUID;
import static com.tinkerlad.chemistry.reference.dataTypes.Alloy.State.SOLID;

public class AlloyList {

	public static final Alloy NaCl = new Alloy(IONIC, SOLID, 0xEEEEEF,
			                                          Arrays.asList(new AlloyComponent(ElementList.SODIUM, 1),
					                                                       new AlloyComponent(ElementList.CHLORINE,
							                                                                         1)
			                                          ), "Table Salt"
	);

	public static final Alloy HCl = new Alloy(ACID, LIQUID, 0xFFFFFF,
			                                         Arrays.asList(new AlloyComponent(ElementList.HYDROGEN, 1),
					                                                      new AlloyComponent(ElementList.CHLORINE,
							                                                                        1)
			                                         ),
			                                         "Hydrochloric Acid"
	);

	public static final Alloy FeC = new Alloy(METALLIC, SOLID, 0xC2C2C2, Arrays.asList(new AlloyComponent(ElementList.IRON, 49),
			                                                                                  new AlloyComponent(ElementList.CARBON, 1)
	),
			                                         "Steel"
	);
}
