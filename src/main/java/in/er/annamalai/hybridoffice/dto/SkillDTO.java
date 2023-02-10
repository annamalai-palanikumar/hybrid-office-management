package in.er.annamalai.portfolio.dto;

import java.io.Serializable;

import in.er.annamalai.portfolio.entity.Skill;
import lombok.Getter;

@Getter
public class SkillDTO implements Serializable {
    private Long id;
    private String name;
    private Integer percent;

    public SkillDTO() {
        super();
    }

    public SkillDTO(Skill skill) {
        this.id = skill.getId();
        this.name = skill.getName();
        this.percent = skill.getPercent();
    }
}
