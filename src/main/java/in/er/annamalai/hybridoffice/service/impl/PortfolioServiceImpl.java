package in.er.annamalai.portfolio.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.er.annamalai.portfolio.dto.PortfolioDTO;
import in.er.annamalai.portfolio.entity.Portfolio;
import in.er.annamalai.portfolio.repository.PortfolioRepository;
import in.er.annamalai.portfolio.service.PortfolioService;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Override
    public PortfolioDTO getPortfolio(Long portfolioId) {
        Optional<Portfolio> optPortfolio = portfolioRepository.findById(portfolioId);
        if (optPortfolio.isPresent()) {
            return new PortfolioDTO(optPortfolio.get());
        }
        return null;
    }

    @Override
    public PortfolioDTO updatePortfolio(Long portfolioId, PortfolioDTO updatedPortfolio) {
        Optional<Portfolio> optPortfolio = portfolioRepository.findById(portfolioId);
        if (optPortfolio.isPresent()) {
            return new PortfolioDTO(portfolioRepository.save(new Portfolio(optPortfolio.get(), updatedPortfolio)));
        }
        return null;
    }

}
