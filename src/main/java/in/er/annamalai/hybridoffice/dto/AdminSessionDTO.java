package in.er.annamalai.portfolio.dto;

import java.io.Serializable;

import in.er.annamalai.portfolio.entity.AdminSession;

public class AdminSessionDTO implements Serializable {
    private Long id;

    private String sessionId;

    public AdminSessionDTO() {
        super();
    }

    public AdminSessionDTO(Long id, String sessionId) {
        this.id = id;
        this.sessionId = sessionId;
    }

    public AdminSessionDTO(AdminSession adminSession) {
        this(adminSession.getId(), adminSession.getSessionId());
    }

    @Override
    public String toString() {
        return String.format(
                "AdminSession[id=%d, sessionId='%s']",
                id, sessionId);
    }

    public Long getId() {
        return id;
    }

    public String getSessionId() {
        return sessionId;
    }
}
