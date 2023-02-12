package in.er.annamalai.hybridoffice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "area_booking")
@Table(name = "area_booking")
public class AreaBooking {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start")
    private Date start;

    @Column(name = "stop")
    private Date stop;

    @ManyToOne
    @JoinColumn(name="area_id", nullable=false)
    private OfficeArea area;

    @ManyToOne
    @JoinColumn(name="employee_id", nullable=false)
    private Employee employee;

    protected AreaBooking() {
        super();
    }

    public AreaBooking(Date start, Date stop, Long areaId, Long employeeId) {
        this.start = start;
        this.stop = stop;
        this.area = new OfficeArea(areaId);
        this.employee = new Employee(employeeId);
    }

    @Override
    public String toString() {
        return String.format(
                "AreaBooking[id=%d, start='%s', stop='%s', officeId=%d, employeeId=%d]",
                this.id, this.start, this.stop, this.area.getId(), this.employee.getId());
    }

    public Long getId() {
        return this.id;
    }

    public Date getStart() {
        return start;
    }

    public Date getStop() {
        return stop;
    }

    public OfficeArea getArea() {
        return area;
    }

    public Employee getEmployee() {
        return employee;
    }
}
