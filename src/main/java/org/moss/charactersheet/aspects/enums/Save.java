package org.moss.charactersheet.aspects.enums;

public enum Save
{
    FORT("Fortitude", AbilityScore.CON),
    REF("Reflex", AbilityScore.DEX),
    WILL("Will", AbilityScore.WIS);

    private final String saveName;

    private final AbilityScore ability;


    private Save(String saveName, AbilityScore ability)
    {
        this.saveName = saveName;

        this.ability = ability;
    }

    public AbilityScore getAbility()
    {
        return ability;
    }

    public String getSaveName()
    {
        return saveName;
    }
}
