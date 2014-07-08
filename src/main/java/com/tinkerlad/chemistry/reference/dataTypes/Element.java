package com.tinkerlad.chemistry.reference.dataTypes;

public class Element {

	public String NAME;
	public String SYMBOL;
	public float DENSITY;
	public Type TYPE;
	public int COLOR;
	public int SERIES;
	public Hardness HARDNESS;
	public int ATOMIC_NUMBER;
	public State STATE;

	public Element(String name, String symbol, float density, Type type, int color, int series, Hardness hardness,
	               int atomicNumber) {
		NAME = name;
		SYMBOL = symbol;
		DENSITY = density;
		TYPE = type;
		COLOR = color;
		SERIES = series;
		HARDNESS = hardness;
		ATOMIC_NUMBER = atomicNumber;
		getState();
	}

	public Element(String name, String symbol, float density, Type type, int color, int series, Hardness hardness,
	               int atomicNumber, State state) {
		NAME = name;
		SYMBOL = symbol;
		DENSITY = density;
		TYPE = type;
		COLOR = color;
		SERIES = series;
		HARDNESS = hardness;
		ATOMIC_NUMBER = atomicNumber;
		STATE = state;
	}

	public Element(String name, String symbol, float density, Type type, int color, int series, int atomicNumber) {
		NAME = name;
		SYMBOL = symbol;
		DENSITY = density;
		TYPE = type;
		COLOR = color;
		SERIES = series;
		HARDNESS = Hardness.NA;
		ATOMIC_NUMBER = atomicNumber;
		getState();
	}

	public Element(String name, String symbol, float density, Type type, int color, int series, int atomicNumber,
	               State state) {
		NAME = name;
		SYMBOL = symbol;
		DENSITY = density;
		TYPE = type;
		COLOR = color;
		SERIES = series;
		HARDNESS = Hardness.NA;
		ATOMIC_NUMBER = atomicNumber;
		STATE = state;
	}

	public void getState() {
		if ((TYPE == Type.GAS || TYPE == Type.NOBLE_GAS || TYPE == Type.HALOGEN)) {
			STATE = State.GAS;
		} else {
			STATE = State.SOLID;
		}
	}

	public enum Type {ALKALINE_METAL, EARTH_METAL, TRANSITION, NON_METAL, METALLOID, GAS, HALOGEN, NOBLE_GAS}

	public enum State {SOLID, LIQUID, GAS}

	;

	public enum Hardness {
		NA(0), LOW(1), MEDIUM(2), HIGH(5), EXTREME(10);
		private int value;

		private Hardness(int value) {
			this.value = value;
		}

		int getValue() {return value;}
	}
}
