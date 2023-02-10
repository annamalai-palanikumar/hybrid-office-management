package in.er.annamalai.portfolio.service;

import org.springframework.transaction.annotation.Transactional;

import in.er.annamalai.portfolio.dto.AdminSessionDTO;
import in.er.annamalai.portfolio.dto.IDToken;

public interface PortfolioAdminSessionService {
    AdminSessionDTO getSession(String sessionId);

    @Transactional
    AdminSessionDTO createSession(IDToken idToken);

    @Transactional
    void deleteSession(String sessionId);
}
