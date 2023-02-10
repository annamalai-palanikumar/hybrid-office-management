package in.er.annamalai.portfolio.web.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.er.annamalai.portfolio.dto.PortfolioDTO;
import in.er.annamalai.portfolio.service.PortfolioService;

@RestController
@RequestMapping("/admin/api/portfolio")
public class PortfolioAdminApiController {

    private static final Long DEFAULT_PORTFOLIO_ID = 1L;

    @Autowired
    private PortfolioService portfolioService;

    @PatchMapping(value = {"", "/{id}"})
    public ResponseEntity<PortfolioDTO> updatePortfolio(@PathVariable(name = "id", required = false) Optional<Long> portfolioId, @RequestBody PortfolioDTO updatedPortfolio) {
        if(portfolioId.isEmpty()) {
            portfolioId = Optional.of(DEFAULT_PORTFOLIO_ID);
        }
        PortfolioDTO portfolio = portfolioService.updatePortfolio(portfolioId.get(), updatedPortfolio);
        if(portfolio != null) {
            return ResponseEntity.ok(portfolio);
        }
        return ResponseEntity.notFound().build();
    }
}
