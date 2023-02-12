package in.er.annamalai.hybridoffice.dto;

import java.io.Serializable;

import in.er.annamalai.hybridoffice.entity.OfficeArea;


public class OfficeAreaDTO implements Serializable {
    private Long id;

    private String shape;

    private String coords;

    private OfficeDTO office;

    public OfficeAreaDTO() {
        super();
    }

    public OfficeAreaDTO(Long id) {
        this.id = id;
    }

    public OfficeAreaDTO(Long id, String shape, String coords, Long officeId) {
        this.id = id;
        this.shape = shape;
        this.coords = coords;
    }

    public OfficeAreaDTO(OfficeArea officeArea) {
        this(officeArea.getId(), officeArea.getShape(), officeArea.getCoords(), officeArea.getOffice().getId());
    }

    @Override
    public String toString() {
        return String.format(
                "OfficeArea[id=%d, shape=%s, coords='%s', officeId=%d]",
                id, shape, coords, office.getId());
    }

    public Long getId() {
        return id;
    }

    public String getShape() {
        return shape;
    }

    public String getCoords() {
        return coords;
    }

    public OfficeDTO getOffice() {
        return office;
    }
}
