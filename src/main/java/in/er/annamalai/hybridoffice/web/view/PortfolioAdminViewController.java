package in.er.annamalai.portfolio.web.view;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import in.er.annamalai.portfolio.dto.AdminSessionDTO;
import in.er.annamalai.portfolio.dto.PortfolioDTO;
import in.er.annamalai.portfolio.service.PortfolioAdminSessionService;
import in.er.annamalai.portfolio.service.PortfolioService;

@Controller
@RequestMapping("/admin")
public class PortfolioAdminViewController {

    private static final Long DEFAULT_PORTFOLIO_ID = 1L;

    @Autowired
    private PortfolioAdminSessionService portfolioAdminSessionService;

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping(value = {"", "/{id}"})
    public String home(@CookieValue(name = "sessionId", required = false) String sessionId, 
                        @PathVariable(name = "id", required = false) Optional<Long> portfolioId,
                        Model model, HttpServletRequest request, HttpServletResponse response) {
        AdminSessionDTO adminSession = portfolioAdminSessionService.getSession(sessionId);
        if(adminSession != null && adminSession.getSessionId() != null && !adminSession.getSessionId().trim().isEmpty()) {
            if(portfolioId.isEmpty()) {
                portfolioId = Optional.of(DEFAULT_PORTFOLIO_ID);
            }
            PortfolioDTO portfolio = portfolioService.getPortfolio(portfolioId.get());
            model.addAttribute("portfolio", portfolio);
            return "admin/profile";
        }
        return "admin/login";
    }
}
