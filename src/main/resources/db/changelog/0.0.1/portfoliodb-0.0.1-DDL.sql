--liquibase formatted sql
--changeset annamalai.palanikumar:table_admin_ddl_0.0.1
CREATE TABLE admin (
    id BIGINT NOT NULL AUTO_INCREMENT,
    email VARCHAR(255),
    PRIMARY KEY (id)
);
--rollback DROP TABLE IF EXISTS admin CASCADE;

--changeset annamalai.palanikumar:table_session_ddl_0.0.1
CREATE TABLE session (
    id BIGINT NOT NULL AUTO_INCREMENT,
    session_id VARCHAR(255),
    PRIMARY KEY (id)
);
--rollback DROP TABLE IF EXISTS session CASCADE;

--changeset annamalai.palanikumar:table_portfolio_ddl_0.0.1
CREATE TABLE portfolio (
    id BIGINT NOT NULL AUTO_INCREMENT,
    about TEXT,
    address VARCHAR(255),
    birth_day VARCHAR(255),
    career_end BIGINT,
    career_start BIGINT,
    city VARCHAR(255),
    company VARCHAR(255),
    country VARCHAR(255),
    degree VARCHAR(255),
    email VARCHAR(255),
    face_book VARCHAR(255),
    footer_slogan VARCHAR(255),
    freelance VARCHAR(255),
    git_hub VARCHAR(255),
    git_lab VARCHAR(255),
    gmail VARCHAR(255),
    google_developer VARCHAR(255),
    instagram VARCHAR(255),
    job VARCHAR(255),
    job_descripton VARCHAR(255),
    job_slogan VARCHAR(255),
    linked_in VARCHAR(255),
    mobile VARCHAR(255),
    name VARCHAR(255),
    out_look_mail VARCHAR(255),
    private_mail VARCHAR(255),
    resume_summary VARCHAR(255),
    skills_description VARCHAR(255),
    stack_over_flow VARCHAR(255),
    twitter VARCHAR(255),
    web_site VARCHAR(255),
    PRIMARY KEY (id)
);
--rollback DROP TABLE IF EXISTS portfolio CASCADE;

--changeset annamalai.palanikumar:table_award_ddl_0.0.1
CREATE TABLE award (
    id BIGINT NOT NULL AUTO_INCREMENT,
    associated_with VARCHAR(255),
    issued_by VARCHAR(255),
    issued_on VARCHAR(255),
    name VARCHAR(255),
    portfolio_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (portfolio_id) REFERENCES portfolio (id)
);
--rollback DROP TABLE IF EXISTS award CASCADE;

--changeset annamalai.palanikumar:table_education_ddl_0.0.1
CREATE TABLE education (
    id BIGINT NOT NULL AUTO_INCREMENT,
    completed VARCHAR(255),
    degree VARCHAR(255),
    location VARCHAR(255),
    major VARCHAR(255),
    start VARCHAR(255),
    summary VARCHAR(255),
    university VARCHAR(255),
    portfolio_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (portfolio_id) REFERENCES portfolio (id)
);
--rollback DROP TABLE IF EXISTS education CASCADE;

--changeset annamalai.palanikumar:table_experiance_ddl_0.0.1
CREATE TABLE experiance (
    id BIGINT NOT NULL AUTO_INCREMENT,
    company_name VARCHAR(255),
    finish VARCHAR(255),
    job_name VARCHAR(255),
    location VARCHAR(255),
    start VARCHAR(255),
    portfolio_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (portfolio_id) REFERENCES portfolio (id)
);
--rollback DROP TABLE IF EXISTS experiance CASCADE;

--changeset annamalai.palanikumar:table_experiance_achievements_ddl_0.0.1
CREATE TABLE experiance_achievements (
    experiance_id BIGINT NOT NULL,
    achievements VARCHAR(255),
    FOREIGN KEY (experiance_id) REFERENCES experiance (id)
);
--rollback DROP TABLE IF EXISTS experiance_achievements CASCADE;

--changeset annamalai.palanikumar:table_portfolio_artifact_ddl_0.0.1
CREATE TABLE portfolio_artifact (
    id BIGINT NOT NULL AUTO_INCREMENT,
    category VARCHAR(255),
    git_hub VARCHAR(255),
    git_lab VARCHAR(255),
    main_preview VARCHAR(255),
    name VARCHAR(255),
    productionurl VARCHAR(255),
    test_results VARCHAR(255),
    testurl VARCHAR(255),
    portfolio_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (portfolio_id) REFERENCES portfolio (id)
);
--rollback DROP TABLE IF EXISTS portfolio_artifact CASCADE;

--changeset annamalai.palanikumar:table_portfolio_artifact_previews_ddl_0.0.1
CREATE TABLE portfolio_artifact_previews (
    portfolio_artifact_id BIGINT NOT NULL,
    previews VARCHAR(255),
    FOREIGN KEY (portfolio_artifact_id) REFERENCES portfolio_artifact (id)
);
--rollback DROP TABLE IF EXISTS portfolio_artifact_previews CASCADE;

--changeset annamalai.palanikumar:table_skill_previews_ddl_0.0.1
CREATE TABLE skill (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    percent INTEGER,
    portfolio_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (portfolio_id) REFERENCES portfolio (id)
);
--rollback DROP TABLE IF EXISTS skill CASCADE;