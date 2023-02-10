package in.er.annamalai.portfolio.dto;

import java.io.Serializable;

import in.er.annamalai.portfolio.entity.Award;
import lombok.Getter;

@Getter
public class AwardDTO implements Serializable {

    private Long id;

    private String name;

    private String issuedBy;

    private String associatedWith;

    private String issuedOn;

    public AwardDTO() {
        super();
    }

    public AwardDTO(Award award) {
        this.id = award.getId();
        this.name = award.getName();
        this.issuedBy = award.getIssuedBy();
        this.associatedWith = award.getAssociatedWith();
        this.issuedOn = award.getIssuedOn();
    }

}
