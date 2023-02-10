package in.er.annamalai.hybridoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.er.annamalai.hybridoffice.entity.IdentityClient;

@Repository
public interface IdentityClientRepositorysitory extends JpaRepository<IdentityClient, Long>{
}
