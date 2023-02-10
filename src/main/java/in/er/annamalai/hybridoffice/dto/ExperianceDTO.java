package in.er.annamalai.portfolio.dto;

import java.io.Serializable;
import java.util.List;

import in.er.annamalai.portfolio.entity.Experiance;
import lombok.Getter;

@Getter
public class ExperianceDTO implements Serializable {

    private Long id;

    private String jobName;

    private String companyName;

    private String location;

    private String start;

    private String finish;

    private List<String> achievements;

    public ExperianceDTO() {
        super();
    }

    public ExperianceDTO(Experiance experiance) {
        this.id = experiance.getId();
        this.jobName = experiance.getJobName();
        this.companyName = experiance.getCompanyName();
        this.location = experiance.getLocation();
        this.start = experiance.getStart();
        this.finish = experiance.getFinish();
        this.achievements = experiance.getAchievements();
    }

}
