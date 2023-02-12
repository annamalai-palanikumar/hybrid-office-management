package in.er.annamalai.portfolio.web.view;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.er.annamalai.portfolio.dto.PortfolioDTO;
import in.er.annamalai.portfolio.service.PortfolioService;

@Controller
public class PortfolioViewController {

    private static final Long DEFAULT_PORTFOLIO_ID = 1L;

    @Autowired
    private AreaBookingService portfolioService;

    @GetMapping
    public String portfolio(@RequestParam(name = "id", required = false) Optional<Long> portfolioId,
                            Model model) {
        if(portfolioId.isEmpty()) {
            portfolioId = Optional.of(DEFAULT_PORTFOLIO_ID);
        }
        PortfolioDTO portfolio = portfolioService.getPortfolio(portfolioId.get());
        model.addAttribute("portfolio", portfolio);
        return "portfolio";
    }

    @GetMapping("/privacy")
    public String privacy(Model model) {
        return "privacy";
    }
}
