package scripts.data.presets;

import lombok.Data;
import org.tribot.script.sdk.Skill;
@Data
public class SkillRequirement {
    private Skill skill;
    private int level;

    public SkillRequirement(Skill skill, int level) {
        this.skill = skill;
        this.level = level;
    }

    public boolean greaterThanOrEqualTo(SkillRequirement skillRequirement){
        return skillRequirement.getSkill().equals(this.getSkill()) && this.getLevel() >= skillRequirement.getLevel();
    }

    @Override
    public boolean equals(Object obj){
        boolean equals = false;

        if (obj instanceof SkillRequirement){
            SkillRequirement skillReq = (SkillRequirement) obj;
            equals =  skillReq.skill.equals(this.skill) &&  skillReq.level >= this.level;
        }

        return equals;
    }

}
