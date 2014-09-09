package com.tinkerlad.chemistry.reference.dataTypes;

import com.tinkerlad.chemistry.reference.Enums;

import static com.tinkerlad.chemistry.reference.Enums.ElementType;
import static com.tinkerlad.chemistry.reference.Enums.Hardness;

public class Element {

    public String NAME;
    public String SYMBOL;
    public float DENSITY;
    public ElementType ElementTYPE;
    public int COLOR;
    public int SERIES;
    public Hardness HARDNESS;
    public int ATOMIC_NUMBER;
    public Enums.State STATE;

    public Element(String name, String symbol, float density, ElementType elementType, int color, int series, Hardness hardness,
                   int atomicNumber) {
        NAME = name;
        SYMBOL = symbol;
        DENSITY = density;
        ElementTYPE = elementType;
        COLOR = color;
        SERIES = series;
        HARDNESS = hardness;
        ATOMIC_NUMBER = atomicNumber;
        getState();
    }

    public Element(String name, String symbol, float density, ElementType elementType, int color, int series, Hardness hardness,
                   int atomicNumber, Enums.State state) {
        NAME = name;
        SYMBOL = symbol;
        DENSITY = density;
        ElementTYPE = elementType;
        COLOR = color;
        SERIES = series;
        HARDNESS = hardness;
        ATOMIC_NUMBER = atomicNumber;
        STATE = state;
    }

    public Element(String name, String symbol, float density, ElementType elementType, int color, int series, int atomicNumber) {
        NAME = name;
        SYMBOL = symbol;
        DENSITY = density;
        ElementTYPE = elementType;
        COLOR = color;
        SERIES = series;
        HARDNESS = Hardness.NA;
        ATOMIC_NUMBER = atomicNumber;
        getState();
    }

    public Element(String name, String symbol, float density, ElementType elementType, int color, int series, int atomicNumber,
                   Enums.State state) {
        NAME = name;
        SYMBOL = symbol;
        DENSITY = density;
        ElementTYPE = elementType;
        COLOR = color;
        SERIES = series;
        HARDNESS = Hardness.NA;
        ATOMIC_NUMBER = atomicNumber;
        STATE = state;
    }

    public Enums.State getState() {
        if ((ElementTYPE == ElementType.GAS || ElementTYPE == ElementType.NOBLE_GAS || ElementTYPE == ElementType.HALOGEN)) {
            STATE = Enums.State.GAS;
        } else {
            STATE = Enums.State.SOLID;
        }
        return STATE;
    }
}

