package in.er.annamalai.portfolio.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import in.er.annamalai.portfolio.entity.Award;
import in.er.annamalai.portfolio.entity.Education;
import in.er.annamalai.portfolio.entity.Experiance;
import in.er.annamalai.portfolio.entity.Portfolio;
import in.er.annamalai.portfolio.entity.PortfolioArtifact;
import in.er.annamalai.portfolio.entity.Skill;
import lombok.Getter;

@Getter
public class PortfolioDTO implements Serializable {
    private Long id;

    private String name;

    private String about;

    private String company;

    private String job;

    private String country;

    private String address;

    private String mobile;

    private String email;

    private String linkedIn;

    private String gitHub;

    private String stackOverFlow;

    private String gitLab;

    private String googleDeveloper;

    private String twitter;

    private String faceBook;

    private String instagram;

    private String jobDescripton;

    private String jobSlogan;

    private String birthDay;

    private String webSite;

    private String city;

    private String degree;

    private String privateMail;

    private String outLookMail;

    private String gmail;

    private String freelance;

    private String skillsDescription;

    private List<SkillDTO> skills;

    private String resumeSummary;

    private Long careerStart;

    private Long careerEnd;

    private List<EducationDTO> educations;

    private List<ExperianceDTO> experiances;

    private List<PortfolioArtifactDTO> portfolio;

    private List<AwardDTO> awards;

    private String footerSlogan;

    public PortfolioDTO() {
        super();
    }

    public PortfolioDTO(Portfolio portfolio) {
        this.id = portfolio.getId();
        this.name = portfolio.getName();
        this.about = portfolio.getAbout();
        this.company = portfolio.getCompany();
        this.job = portfolio.getJob();
        this.country = portfolio.getCountry();
        this.address = portfolio.getAddress();
        this.mobile = portfolio.getMobile();
        this.email = portfolio.getEmail();
        this.linkedIn = portfolio.getLinkedIn();
        this.gitHub = portfolio.getGitHub();
        this.stackOverFlow = portfolio.getStackOverFlow();
        this.gitLab = portfolio.getGitLab();
        this.googleDeveloper = portfolio.getGoogleDeveloper();
        this.twitter = portfolio.getTwitter();
        this.faceBook = portfolio.getFaceBook();
        this.instagram = portfolio.getInstagram();
        this.jobDescripton = portfolio.getJobDescripton();
        this.jobSlogan = portfolio.getJobSlogan();
        this.birthDay = portfolio.getBirthDay();
        this.webSite = portfolio.getWebSite();
        this.city = portfolio.getCity();
        this.degree = portfolio.getDegree();
        this.privateMail = portfolio.getPrivateMail();
        this.outLookMail = portfolio.getOutLookMail();
        this.gmail = portfolio.getGmail();
        this.freelance = portfolio.getFreelance();
        this.skillsDescription = portfolio.getSkillsDescription();
        if(portfolio.getSkills() != null && !portfolio.getSkills().isEmpty()) {
            this.skills = new ArrayList<>();
            for(Skill skill: portfolio.getSkills()) {
                this.skills.add(new SkillDTO(skill));
            }
        }
        this.resumeSummary = portfolio.getResumeSummary();
        this.careerStart = portfolio.getCareerStart();
        this.careerEnd = portfolio.getCareerEnd();
        if(portfolio.getEducations() != null && !portfolio.getEducations().isEmpty()) {
            this.educations = new ArrayList<>();
            for(Education education: portfolio.getEducations()) {
                this.educations.add(new EducationDTO(education));
            }
        }
        if(portfolio.getExperiances() != null && !portfolio.getExperiances().isEmpty()) {
            this.experiances = new ArrayList<>();
            for(Experiance experiance: portfolio.getExperiances()) {
                this.experiances.add(new ExperianceDTO(experiance));
            }
        }
        if(portfolio.getPortfolio() != null && !portfolio.getPortfolio().isEmpty()) {
            this.portfolio = new ArrayList<>();
            for(PortfolioArtifact portfolioArtifact: portfolio.getPortfolio()) {
                this.portfolio.add(new PortfolioArtifactDTO(portfolioArtifact));
            }
        }
        if(portfolio.getAwards() != null && !portfolio.getAwards().isEmpty()) {
            this.awards = new ArrayList<>();
            for(Award award: portfolio.getAwards()) {
                this.awards.add(new AwardDTO(award));
            }
        }
        this.footerSlogan = portfolio.getFooterSlogan();
    }

    @Override
    public String toString() {
        return String.format(
                "Portfolio[id=%d, name='%s']",
                this.id, this.name);
    }
}
