package in.er.annamalai.hybridoffice.dto;

import java.io.Serializable;

import in.er.annamalai.hybridoffice.entity.Office;


public class OfficeDTO implements Serializable {
    private Long id;

    private String name;

    private String plan;

    public OfficeDTO() {
        super();
    }

    public OfficeDTO(Long id, String name, String plan) {
        this.id = id;
        this.name = name;
        this.plan = plan;
    }

    public OfficeDTO(Office office) {
        this(office.getId(), office.getName(), office.getPlan());
    }

    @Override
    public String toString() {
        return String.format(
                "OfficeArea[id=%d, name=%s, plan='%s']",
                id, name, plan);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPlan() {
        return plan;
    }
}
