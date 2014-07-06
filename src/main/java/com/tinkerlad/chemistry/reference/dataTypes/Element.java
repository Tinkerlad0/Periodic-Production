package com.tinkerlad.chemistry.reference.dataTypes;

public class Element {

	public String NAME;
	public String SYMBOL;
	public float DENSITY;
	public Type TYPE;
	public int COLOR;
	public int SERIES;
	public Hardness Hardness;

	public Element(String name, String symbol, float density, Type type, int color, int series, Hardness hardness) {
		NAME = name;
		SYMBOL = symbol;
		DENSITY = density;
		TYPE = type;
		COLOR = color;
		SERIES = series;
		Hardness = hardness;
	}

	public Element(String name, String symbol, float density, Type type, int color, int series) {
		NAME = name;
		SYMBOL = symbol;
		DENSITY = density;
		TYPE = type;
		COLOR = color;
		SERIES = series;
		Hardness = Hardness.NA;
	}

	public enum Type {ALKALINE_METAL, EARTH_METAL, TRANSITION, NON_METAL, METALLOID, GAS, HALOGEN, NOBLE_GAS}

	public enum Hardness {
		NA(0), LOW(1), MEDIUM(2), HIGH(5), EXTREME(10);
		private int value;

		private Hardness(int value) {
			this.value = value;
		}
	}

	;
}
