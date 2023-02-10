package in.er.annamalai.portfolio.dto;

import java.io.Serializable;
import java.util.List;

import in.er.annamalai.portfolio.entity.PortfolioArtifact;
import lombok.Getter;

@Getter
public class PortfolioArtifactDTO implements Serializable {

    private Long id;

    private String name;

    private List<String> previews;

    private String mainPreview;

    private String gitHub;

    private String gitLab;

    private String category;

    private String productionURL;

    private String testURL;

    private String testResults;

    public PortfolioArtifactDTO() {
        super();
    }

    public PortfolioArtifactDTO(PortfolioArtifact portfolioArtifact) {
        this.name = portfolioArtifact.getName();
        this.previews = portfolioArtifact.getPreviews();
        this.mainPreview = portfolioArtifact.getMainPreview();
        this.gitHub = portfolioArtifact.getGitHub();
        this.gitLab = portfolioArtifact.getGitLab();
        this.category = portfolioArtifact.getCategory();
        this.productionURL = portfolioArtifact.getProductionURL();
        this.testURL = portfolioArtifact.getTestURL();
        this.testResults = portfolioArtifact.getTestResults();
    }

}
