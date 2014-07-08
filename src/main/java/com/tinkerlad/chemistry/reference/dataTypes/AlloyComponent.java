package com.tinkerlad.chemistry.reference.dataTypes;

public class AlloyComponent {

	public Element ELEMENT;
	public int AMOUNT;

	public AlloyComponent(Element ELEMENT, int AMOUNT) {
		this.ELEMENT = ELEMENT;
		this.AMOUNT = AMOUNT;
	}

	public Element getELEMENT() {
		return ELEMENT;
	}

	public int getAMOUNT() {
		return AMOUNT;
	}
}
