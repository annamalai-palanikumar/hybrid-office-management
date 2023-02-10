package in.er.annamalai.hybridoffice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "employee")
@Table(name = "employee")
public class Employee {
    @Id
    @Column("id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column("name")
    private String name;

    @Column("email")
    private String email;

    @Column("admin")
    private boolean admin;

    protected Employee() {
        super();
    }

    public Employee(String name, String email, boolean admin) {
        this.name = name;
        this.email = email;
        this.admin = admin;
    }

    @Override
    public String toString() {
        return String.format(
                "Employee[id=%d, name='%s', email='%s, admin=%b']",
                this.id, this.name, this.email, this.admin);
    }

    public Long getId() {
        return this.id;
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
