package com.tinkerlad.chemistry.reference.dataTypes;

public class ElementToolPart {

    Element edge;
    Element core;

    public ElementToolPart(Element edge, Element core) {
        this.edge = edge;
        this.core = core;
    }

    public String getName() {
        if (!(edge == core)) {
            return edge.NAME + " tipped " + core.NAME;
        } else {
            return core.NAME;
        }
    }

    public String getUnlocalisedName() {
        return edge.NAME + core.NAME;
    }

    public int getColor() {
        return (int) ((2 * edge.COLOR + core.COLOR) / 3);
    }

    public Element getEdge() {
        return edge;
    }

    public Element getCore() {
        return core;
    }

    public int getMiningLevel() {
        return edge.HARDNESS.getValue();
    }

    public int getDurability() {
        if (edge.HARDNESS.getValue() == 0 || core.HARDNESS.getValue() == 0) {
            return 5;
        }
        return edge.HARDNESS.getValue() * (1 / core.HARDNESS.getValue()) * 350;
    }

    public float getMineSpeed() {
        float value = edge.HARDNESS.getValue() * ((2 * edge.DENSITY + core.DENSITY) / 3);
        return value > 0 ? value : 1F;
    }

    public float getDamageDealt() {
        return (edge.HARDNESS.getValue() * ((2 * edge.DENSITY + core.DENSITY) / 3) / 5);
        //Divide by Five for balance reasons
    }

    public int getEnchantability() {
        return (int) (edge.DENSITY * 2 * (core.DENSITY / core.ATOMIC_NUMBER) * 8);
    }
}
