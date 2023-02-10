package in.er.annamalai.portfolio.dto;

import java.io.Serializable;

import in.er.annamalai.portfolio.entity.Education;
import lombok.Getter;

@Getter
public class EducationDTO implements Serializable {

    private Long id;

    private String degree;

    private String major;

    private String start;

    private String completed;

    private String university;

    private String location;

    private String summary;

    public EducationDTO() {
        super();
    }

    public EducationDTO(Education education) {
        this.id = education.getId();
        this.degree = education.getDegree();
        this.major = education.getMajor();
        this.start = education.getStart();
        this.completed = education.getCompleted();
        this.university = education.getUniversity();
        this.location = education.getLocation();
        this.summary = education.getSummary();
    }

}
