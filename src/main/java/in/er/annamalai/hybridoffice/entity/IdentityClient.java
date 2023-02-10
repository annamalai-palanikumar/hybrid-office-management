package in.er.annamalai.hybridoffice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "identity_client")
@Table(name = "identity_client")
public class IdentityClient {
    @Id
    @Column("id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column("name")
    private String name;

    @Column("client_id")
    private String clientId;

    protected IdentityClient() {
        super();
    }

    public IdentityClient(String name, String clientId) {
        this.name = name;
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return String.format(
                "IdentityClient[id=%d, name='%s', clientId='%s']",
                this.id, this.name, this.clientId);
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public String getClientId() {
        return clientId;
    }
}
