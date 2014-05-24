package org.moss.charactersheet.aspects.enums;

public enum AbilityScore
{
    STR("Strength"),
    DEX("Dexterity"),
    CON("Consitituion"),
    INT("Intelligence"),
    WIS("Wisdom"),
    CHA("Charisma");

    private final String abilityName;


    private AbilityScore(String abilityName)
    {
        this.abilityName = abilityName;
    }

    public String getAbilityName()
    {
        return abilityName;
    }
}
