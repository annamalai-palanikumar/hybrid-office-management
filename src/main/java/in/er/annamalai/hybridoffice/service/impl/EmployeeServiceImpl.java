package in.er.annamalai.portfolio.service.impl;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.client.auth.openidconnect.IdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;

import in.er.annamalai.portfolio.dto.AdminSessionDTO;
import in.er.annamalai.portfolio.dto.IDToken;
import in.er.annamalai.portfolio.entity.Admin;
import in.er.annamalai.portfolio.entity.AdminSession;
import in.er.annamalai.portfolio.repository.AdminRepository;
import in.er.annamalai.portfolio.repository.AdminSessionRepository;
import in.er.annamalai.portfolio.service.PortfolioAdminSessionService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private AdminSessionRepository adminSessionRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public AdminSessionDTO getSession(String sessionId) {
        if (sessionId != null && !sessionId.trim().isEmpty()) {
            Optional<AdminSession> optAdminSession = adminSessionRepository.findBySessionId(sessionId);
            if (optAdminSession.isPresent()) {
                return new AdminSessionDTO(optAdminSession.get());
            }
        }
        return null;
    }

    @Override
    public AdminSessionDTO createSession(IDToken idToken) {
        if (idToken.getIdToken() != null && !idToken.getIdToken().trim().isEmpty()) {
            GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(),
                    new GsonFactory())
                    .setAudience(Collections
                            .singletonList("204034911117-a3ta87crrp5k68najd5affe5f6395eb1.apps.googleusercontent.com"))
                    .build();
            try {
                GoogleIdToken googleIDToken = verifier.verify(idToken.getIdToken());
                if (idToken != null) {
                    Payload payload = googleIDToken.getPayload();
                    String email = (String) payload.getOrDefault("email", null);
                    if (email != null && !email.trim().isEmpty()) {
                        Optional<Admin> optEmail = adminRepository.findByEmail(email);
                        if (optEmail.isPresent()) {
                            Admin admin = optEmail.get();
                            AdminSession adminSession = new AdminSession(admin.getId());
                            Optional<AdminSession> optExistingSession = adminSessionRepository
                                    .findBySessionId(adminSession.getSessionId());
                            if (optExistingSession.isPresent()) {
                                return new AdminSessionDTO(optExistingSession.get());
                            }
                            return new AdminSessionDTO(adminSessionRepository.save(adminSession));
                        }
                    }
                }
            } catch (GeneralSecurityException | IOException e) {
                //
            }
        }
        return null;
    }

    @Override
    public void deleteSession(String sessionId) {
        adminSessionRepository.deleteBySessionId(sessionId);
    }

}
