package in.er.annamalai.portfolio.web.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.er.annamalai.portfolio.dto.PortfolioDTO;
import in.er.annamalai.portfolio.service.PortfolioService;

@RestController
@RequestMapping("/api/portfolio")
public class PortfolioPublicApiController {

    private static final Long DEFAULT_PORTFOLIO_ID = 1L;

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping(value = {"", "/{id}"})
    public ResponseEntity<PortfolioDTO> getPortfolio(@PathVariable(name = "id", required = false) Optional<Long> portfolioId) {
        if(portfolioId.isEmpty()) {
            portfolioId = Optional.of(DEFAULT_PORTFOLIO_ID);
        }
        PortfolioDTO portfolio = portfolioService.getPortfolio(portfolioId.get());
        if(portfolio != null) {
            return ResponseEntity.ok(portfolio);
        }
        return ResponseEntity.notFound().build();
    }
}
