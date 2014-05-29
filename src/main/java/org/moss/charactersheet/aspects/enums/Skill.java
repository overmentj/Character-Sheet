package org.moss.charactersheet.aspects.enums;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.moss.charactersheet.aspects.enums.AbilityScore;

/**
 * Skill class. Currently contains a static map of all known skills and their corresponding
 * ability modifier.
 * @author Jacq
 *
 */
public class Skill
{
    private static final Map<String, Skill> SKILLS_MAP = new TreeMap<String, Skill>();
    static
    {
        SKILLS_MAP.put("Appraise", new Skill("Appraise", AbilityScore.INT));
        SKILLS_MAP.put("Autohypnosis", new Skill("Autohypnosis", AbilityScore.WIS));
        SKILLS_MAP.put("Balance", new Skill("Balance", AbilityScore.DEX));
        SKILLS_MAP.put("Bluff", new Skill("Bluff", AbilityScore.CHA));
        SKILLS_MAP.put("Climb", new Skill("Climb", AbilityScore.STR));
        SKILLS_MAP.put("Concentration", new Skill("Concentration", AbilityScore.CON));
        SKILLS_MAP.put("Decipher Script", new Skill("Decipher Script", AbilityScore.INT));
        SKILLS_MAP.put("Diplomacy", new Skill("Diplomacy", AbilityScore.CHA));
        SKILLS_MAP.put("Disable Device", new Skill("Disable Device", AbilityScore.INT));
        SKILLS_MAP.put("Disguise", new Skill("Disguise", AbilityScore.CHA));
        SKILLS_MAP.put("Escape Artist", new Skill("Escape Artist", AbilityScore.DEX));
        SKILLS_MAP.put("Forgery", new Skill("AutohForgeryypnosis", AbilityScore.INT));
        SKILLS_MAP.put("Gather Information", new Skill("Gather Information", AbilityScore.CHA));
        SKILLS_MAP.put("Handle Animal", new Skill("Handle Animal", AbilityScore.CHA));
        SKILLS_MAP.put("Heal", new Skill("Heal", AbilityScore.WIS));
        SKILLS_MAP.put("Hide", new Skill("Hide", AbilityScore.DEX));
        SKILLS_MAP.put("Intimidate", new Skill("Intimidate", AbilityScore.CHA));
        SKILLS_MAP.put("Jump", new Skill("Jump", AbilityScore.DEX));
        SKILLS_MAP.put("Knowledge (Arcana)", new Skill("Knowledge (Arcana)", AbilityScore.INT));
        SKILLS_MAP.put("Knowledge (Arch/Eng)", new Skill("Knowledge (Arch/Eng)", AbilityScore.INT));
        SKILLS_MAP.put("Knowledge (Dungeoneering)", new Skill("Knowledge (Dungeoneering)", AbilityScore.INT));
        SKILLS_MAP.put("Knowledge (Geography)", new Skill("Knowledge (Geography)", AbilityScore.INT));
        SKILLS_MAP.put("Knowledge (History)", new Skill("Knowledge (History)", AbilityScore.INT));
        SKILLS_MAP.put("Knowledge (Local)", new Skill("Knowledge (Local)", AbilityScore.INT));
        SKILLS_MAP.put("Knowledge (Nature)", new Skill("Knowledge (Nature)", AbilityScore.INT));
        SKILLS_MAP.put("Knowledge (Nobility/Royalty)", new Skill("Knowledge (Nobility/Royalty)", AbilityScore.INT));
        SKILLS_MAP.put("Knowledge (The Planes)", new Skill("Knowledge (The Planes)", AbilityScore.INT));
        SKILLS_MAP.put("Knowledge (Psionics)", new Skill("Knowledge (Psionics)", AbilityScore.INT));
        SKILLS_MAP.put("Knowledge (Religion)", new Skill("Knowledge (Religion)", AbilityScore.INT));
        SKILLS_MAP.put("Listen", new Skill("Listen", AbilityScore.WIS));
        SKILLS_MAP.put("Move Silently", new Skill("Move Silently", AbilityScore.DEX));
        SKILLS_MAP.put("Open Lock", new Skill("Open Lock", AbilityScore.DEX));
        SKILLS_MAP.put("Perform (Act)", new Skill("Perform (Act)", AbilityScore.CHA));
        SKILLS_MAP.put("Perform (Comedy)", new Skill("Perform (Comedy)", AbilityScore.CHA));
        SKILLS_MAP.put("Perform (Dance)", new Skill("Perform (Dance)", AbilityScore.CHA));
        SKILLS_MAP.put("Perform (Keyboard)", new Skill("Perform (Keyboard)", AbilityScore.CHA));
        SKILLS_MAP.put("Perform (Oratory)", new Skill("Perform (Oratory)", AbilityScore.CHA));
        SKILLS_MAP.put("Perform (Percussion)", new Skill("Perform (Percussion)", AbilityScore.CHA));
        SKILLS_MAP.put("Perform (String Instrument)", new Skill("Perform (String Instrument)", AbilityScore.CHA));
        SKILLS_MAP.put("Perform (Wind Instrument)", new Skill("Perform (Wind Instrument)", AbilityScore.CHA));
        SKILLS_MAP.put("Psicraft", new Skill("Intimidate", AbilityScore.INT));
        SKILLS_MAP.put("Ride", new Skill("Intimidate", AbilityScore.DEX));
        SKILLS_MAP.put("Search", new Skill("Intimidate", AbilityScore.INT));
        SKILLS_MAP.put("Sense Motive", new Skill("Intimidate", AbilityScore.WIS));
        SKILLS_MAP.put("Sleight of Hand", new Skill("Intimidate", AbilityScore.DEX));
        SKILLS_MAP.put("Spellcraft", new Skill("Intimidate", AbilityScore.INT));
        SKILLS_MAP.put("Spot", new Skill("Intimidate", AbilityScore.WIS));
        SKILLS_MAP.put("Survival", new Skill("Intimidate", AbilityScore.WIS));
        SKILLS_MAP.put("Swim", new Skill("Intimidate", AbilityScore.STR));
        SKILLS_MAP.put("Tumble", new Skill("Intimidate", AbilityScore.DEX));
        SKILLS_MAP.put("Use Magic Device", new Skill("Intimidate", AbilityScore.CHA));
        SKILLS_MAP.put("Use Psionic Device", new Skill("Intimidate", AbilityScore.CHA));
        SKILLS_MAP.put("Use Rope", new Skill("Intimidate", AbilityScore.DEX));
    }

    private String skillName;
    private AbilityScore ability;


    public Skill(String name, AbilityScore ability)
    {
        this.skillName = name;
        this.ability = ability;
    }

    public String getSkillName()
    {
        return skillName;
    }

    public AbilityScore getAbility()
    {
        return ability;
    }

    /**
     * Returns key set of skill names from <code>SKILLS_MAP</code>
     * @return
     */
    public static Set<String> getValues()
    {
        return SKILLS_MAP.keySet();
    }

    public static Skill getSkill(String name)
    {
        return SKILLS_MAP.get(name);
    }
}
