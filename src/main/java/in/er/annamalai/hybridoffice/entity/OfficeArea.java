package in.er.annamalai.hybridoffice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "office_area")
@Table(name = "office_area")
public class OfficeArea {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shape")
    private String shape;

    @Column(name = "coords")
    private String coords;

    @ManyToOne
    @JoinColumn(name="office_id", nullable=false)
    private Office office;

    protected OfficeArea() {
        super();
    }

    public OfficeArea(Long id) {
        this.id = id;
    }

    public OfficeArea(String shape, String coords, Long officeId) {
        this.shape = shape;
        this.coords = coords;
        this.office = new Office(officeId);
    }

    @Override
    public String toString() {
        return String.format(
                "OfficeArea[id=%d, shape='%s', coords='%s', officeId=%d]",
                this.id, this.shape, this.coords, this.office.getId());
    }

    public Long getId() {
        return this.id;
    }

    public String getShape() {
        return shape;
    }

    public String getCoords() {
        return coords;
    }

    public Office getOffice() {
        return office;
    }
}
