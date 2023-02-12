package in.er.annamalai.hybridoffice.dto;

import java.io.Serializable;
import java.util.Date;

import in.er.annamalai.hybridoffice.entity.AreaBooking;


public class AreaBookingDTO implements Serializable {
    private Long id;

    private Date start;

    private Date stop;

    private OfficeAreaDTO area;

    private EmployeeDTO employee;

    public AreaBookingDTO() {
        super();
    }

    public AreaBookingDTO(Long id, Date start, Date stop, Long areaId, Long employeeId) {
        this.id = id;
        this.start = start;
        this.stop = stop;
        this.area = new OfficeAreaDTO(areaId);
        this.employee = new EmployeeDTO(employeeId);
    }

    public AreaBookingDTO(AreaBooking areaBooking) {
        this(areaBooking.getId(), areaBooking.getStart(), areaBooking.getStop(), areaBooking.getArea().getId(), areaBooking.getEmployee().getId());
    }

    @Override
    public String toString() {
        return String.format(
                "AreaBooking[id=%d, start=%s, stop='%s', areaId=%d, employeeId=%d]",
                id, start, stop, area.getId(), employee.getId());
    }

    public Long getId() {
        return id;
    }

    public Date getStart() {
        return start;
    }

    public Date getStop() {
        return stop;
    }

    public OfficeAreaDTO getArea() {
        return area;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }
}
