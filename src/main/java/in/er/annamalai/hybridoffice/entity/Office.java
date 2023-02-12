package in.er.annamalai.hybridoffice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "office")
@Table(name = "office")
public class Office {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "plan")
    private String plan;

    protected Office() {
        super();
    }

    public Office(Long id) {
        this.id = id;
    }

    public Office(String name, String plan) {
        this.name = name;
        this.plan = plan;
    }

    @Override
    public String toString() {
        return String.format(
                "Office[id=%d, name='%s', plan='%s']",
                this.id, this.name, this.plan);
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public String getPlan() {
        return plan;
    }
}
