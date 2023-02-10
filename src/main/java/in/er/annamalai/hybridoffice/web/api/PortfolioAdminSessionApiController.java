package in.er.annamalai.portfolio.web.api;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.er.annamalai.portfolio.dto.AdminSessionDTO;
import in.er.annamalai.portfolio.dto.IDToken;
import in.er.annamalai.portfolio.service.PortfolioAdminSessionService;

@RestController
@RequestMapping("/admin/api/session")
public class PortfolioAdminSessionApiController {

    @Autowired
    private PortfolioAdminSessionService portfolioAdminSessionService;

    @GetMapping
    public ResponseEntity<AdminSessionDTO> getSession(@CookieValue(name = "sessionId", required = false) String sessionId) {
        AdminSessionDTO adminSession = portfolioAdminSessionService.getSession(sessionId);
        if(adminSession != null) {
            return ResponseEntity.ok(adminSession);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AdminSessionDTO> createSession(@RequestBody IDToken idToken, HttpServletRequest request, HttpServletResponse response) {
        AdminSessionDTO adminSession = portfolioAdminSessionService.createSession(idToken);
        ResponseCookie cookie = ResponseCookie.from("sessionId", adminSession.getSessionId())
        .maxAge(86400)
        .secure(true)
        .httpOnly(true)
        .path("/admin")
        .sameSite("Strict")
        .build();
        response.setHeader(HttpHeaders.SET_COOKIE, cookie.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(adminSession);
    }

    @DeleteMapping
    public void deleteSession(@CookieValue(name = "sessionId", required = false) String sessionId, HttpServletResponse response) {
        portfolioAdminSessionService.deleteSession(sessionId);
        Cookie sessionCookie = new Cookie("sessionId", null);
        sessionCookie.setMaxAge(0);
        sessionCookie.setSecure(true);
        sessionCookie.setHttpOnly(true);
        sessionCookie.setPath("/");
        response.addCookie(sessionCookie);
    }
}
