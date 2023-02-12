package in.er.annamalai.hybridoffice.dto;

import java.io.Serializable;

import in.er.annamalai.hybridoffice.entity.Employee;


public class EmployeeDTO implements Serializable {
    private Long id;

    private String name;

    private String email;

    private boolean admin;

    public EmployeeDTO() {
        super();
    }

    public EmployeeDTO(Long id) {
        this.id = id;
    }

    public EmployeeDTO(Long id, String name, String email, boolean admin) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.admin = admin;
    }

    public EmployeeDTO(Employee employee) {
        this(employee.getId(), employee.getName(), employee.getEmail(), employee.isAdmin());
    }

    @Override
    public String toString() {
        return String.format(
                "Employee[id=%d, name=%s, email='%s', admin=%b]",
                id, name, email, admin);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAdmin() {
        return admin;
    }
}
