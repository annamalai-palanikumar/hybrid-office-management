package in.er.annamalai.portfolio.service;

import in.er.annamalai.portfolio.dto.PortfolioDTO;

public interface PortfolioService {
    PortfolioDTO getPortfolio(Long portfolioId);

    PortfolioDTO updatePortfolio(Long portfolioId, PortfolioDTO updatedPortfolio);
}
