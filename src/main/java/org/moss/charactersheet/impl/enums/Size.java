package org.moss.charactersheet.impl.enums;

/**
 * Size enum to bridge between combo box and <code>CharacterInfo</code>
 * @author Jacq
 *
 */
public enum Size {
	F("Fine"),
	D("Diminuitive"),
	T("Tiny"),
	S("Small"),
	M("Medium"),
	L("Large"),
	H("Huge"),
	G("Gargantuan"),
	C("Collosal");
	
	private String size;
	
	private Size(String size) {
		this.size = size;
	}
	
	public Size getSizeAbrr() {
		return Size.valueOf(size);
	}
	
	public String getSize() {
		return size;
	}
}
