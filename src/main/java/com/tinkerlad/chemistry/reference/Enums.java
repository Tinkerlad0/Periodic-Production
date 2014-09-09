package com.tinkerlad.chemistry.reference;

public class Enums {

    public enum ElementType {ALKALINE_METAL, EARTH_METAL, TRANSITION, NON_METAL, METALLOID, GAS, HALOGEN, NOBLE_GAS}

    public enum State {SOLID, LIQUID, GAS}

    ;

    public enum Hardness {
        NA(0), LOW(1), MEDIUM(2), HIGH(5), EXTREME(10);
        private int value;

        private Hardness(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
