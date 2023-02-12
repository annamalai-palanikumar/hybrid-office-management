package in.er.annamalai.hybridoffice.dto;

import java.io.Serializable;

import in.er.annamalai.hybridoffice.entity.IdentityClient;


public class IdentityClientDTO implements Serializable {
    private Long id;

    private String name;

    private String clientId;

    public IdentityClientDTO() {
        super();
    }

    public IdentityClientDTO(Long id, String name, String clientId) {
        this.id = id;
        this.name = name;
        this.clientId = clientId;
    }

    public IdentityClientDTO(IdentityClient identityClient) {
        this(identityClient.getId(), identityClient.getName(), identityClient.getClientId());
    }

    @Override
    public String toString() {
        return String.format(
                "IdentityClient[id=%d, name=%s, clientId='%s']",
                id, name, clientId);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getClientId() {
        return clientId;
    }
}
