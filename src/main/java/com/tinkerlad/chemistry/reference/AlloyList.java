package com.tinkerlad.chemistry.reference;

import com.tinkerlad.chemistry.reference.dataTypes.Alloy;
import com.tinkerlad.chemistry.reference.dataTypes.AlloyComponent;
import com.tinkerlad.chemistry.registry.annotations.RegisterAlloy;

import java.util.Arrays;

import static com.tinkerlad.chemistry.reference.ElementList.*;
import static com.tinkerlad.chemistry.reference.dataTypes.Alloy.CompoundType.*;
import static com.tinkerlad.chemistry.reference.dataTypes.Alloy.State.LIQUID;
import static com.tinkerlad.chemistry.reference.dataTypes.Alloy.State.SOLID;

public class AlloyList {

	@RegisterAlloy
	public static final Alloy NaCl = new Alloy(IONIC, SOLID, 0xEEEEEF,
			                                          Arrays.asList(new AlloyComponent(SODIUM, 1),
					                                                       new AlloyComponent(CHLORINE, 1)),
			                                              "Table Salt"
	);
	@RegisterAlloy
	public static final Alloy HCl = new Alloy(ACID, LIQUID, 0xFFFFFF,
			                                         Arrays.asList(new AlloyComponent(HYDROGEN, 1),
					                                                      new AlloyComponent(CHLORINE, 1)),
			                                         "Hydrochloric Acid"
	);
	@RegisterAlloy
	public static final Alloy FeC = new Alloy(METALLIC, SOLID, 0xC2C2C2,
			                                         Arrays.asList(new AlloyComponent(IRON, 49),
					                                                      new AlloyComponent(CARBON, 1)),
			                                         "Steel"
	);
	@RegisterAlloy
	public static final Alloy KNO3 = new Alloy(COVALENT, SOLID, 0xFFFFEE,
			                                          Arrays.asList(new AlloyComponent(POTASSIUM, 1),
					                                                       new AlloyComponent(NITROGEN, 1),
					                                                       new AlloyComponent(OXYGEN, 3)),
			                                          "Potassium Nitrate"
	);
	@RegisterAlloy
	public static final Alloy C6H12O6 = new Alloy(COVALENT, SOLID, 0xFFFFFF,
			                                             Arrays.asList(new AlloyComponent(CARBON, 6),
					                                                          new AlloyComponent(HYDROGEN, 12),
					                                                          new AlloyComponent(OXYGEN, 6)),
			                                             "Glucose"
	);
	@RegisterAlloy
	public static final Alloy Fe20C4SiMn10P7S9Pb8 = new Alloy(METALLIC, SOLID, 0xAAAAAA,
			                                                         Arrays.asList(new AlloyComponent(IRON, 20),
					                                                                      new AlloyComponent(CARBON, 4),
					                                                                      new AlloyComponent(SILICON, 1),
					                                                                      new AlloyComponent(MANGANESE, 10),
					                                                                      new AlloyComponent(PHOSPHORUS, 7),
					                                                                      new AlloyComponent(SULFUR, 9),
					                                                                      new AlloyComponent(LEAD, 8)
			                                                         ),
			                                                         "AISI 12L14"
	);
}
