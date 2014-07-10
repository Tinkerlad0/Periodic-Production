package com.tinkerlad.chemistry.reference.dataTypes;

import java.util.ArrayList;
import java.util.List;

public class Alloy {

	private List<AlloyComponent> COMPONENTS = new ArrayList<AlloyComponent>();
	private CompoundType COMPOUND_TYPE;
	private int COLOR;
	private State STATE;
	private String NAME;

	public Alloy(CompoundType COMPOUND_TYPE, State STATE, int COLOR, List<AlloyComponent> components, String name) {
		this.COMPOUND_TYPE = COMPOUND_TYPE;
		this.STATE = STATE;
		this.COLOR = COLOR;
		this.COMPONENTS = components;
		this.NAME = name;
	}

	public Alloy(CompoundType COMPOUND_TYPE, State STATE, List<AlloyComponent> components, String name) {
		this.COMPOUND_TYPE = COMPOUND_TYPE;
		this.STATE = STATE;
		this.COMPONENTS = components;
		int colour = 0;
		int count = 0;
		for (AlloyComponent component : components) {
			colour += component.ELEMENT.COLOR;
			count++;
		}
		this.COLOR = colour / count;
		this.NAME = name;
	}

	public String getNAME() {
		if (NAME == null) {
			return getChemicalFormula();
		} else if (NAME.length() > 0) {
			return NAME;
		} else {
			return getChemicalFormula();
		}
	}

	public State getSTATE() {
		return STATE;
	}

	public String getChemicalFormula() {
		String formula = "";
		for (AlloyComponent component : COMPONENTS) {
			formula.concat(component.ELEMENT.SYMBOL);
			if (!(component.AMOUNT == 1)) {
				formula.concat(Integer.toString(component.AMOUNT));
			}
		}

		return formula;
	}

	public float getHardness() {

		double hardness = 0;
		int count = 0;
		for (AlloyComponent component : COMPONENTS) {
			count += component.AMOUNT;
			hardness += (component.ELEMENT.HARDNESS.getValue() * component.AMOUNT * component.ELEMENT.DENSITY);
		}
		return (float) (hardness / count);
	}

	public float getSharpness() {
		return getHardness() * COMPOUND_TYPE.getMalleability();
	}

	public float getDensity() {
		double density = 0F;
		int count = 0;
		for (AlloyComponent component : COMPONENTS) {
			density += component.AMOUNT * component.ELEMENT.DENSITY;
			count += component.AMOUNT;
		}
		return (float) ((density / count) * COMPOUND_TYPE.getDensityModifier());
	}

	public int getDurability() {
		return (int) (getDensity() * COMPOUND_TYPE.getMalleability());
	}

	public List<AlloyComponent> getCOMPONENTS() {
		return COMPONENTS;
	}

	public CompoundType getCOMPOUND_TYPE() {
		return COMPOUND_TYPE;
	}

	public int getCOLOR() {
		return COLOR;
	}

	public enum State {SOLID, LIQUID, GAS}

	public enum CompoundType {
		METALLIC(1.2F, 1F), IONIC(1F, 0.3F), COVALENT(0.9F, 0.5F), MOLECULAR(0.8F, 0.01F), ACID(0.8F, 0.01F);
		private float densityModifier;
		private float malleability;

		private CompoundType(float densityModifier, float malleability) {
			this.densityModifier = densityModifier;
			this.malleability = malleability;
		}

		public float getDensityModifier() {
			return densityModifier;
		}

		public float getMalleability() {
			return malleability;
		}
	}
}

