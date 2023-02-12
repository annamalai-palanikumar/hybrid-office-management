package in.er.annamalai.hybridoffice.service;

import java.util.List;

import in.er.annamalai.hybridoffice.dto.IdentityClientDTO;

public interface IdentityClientService {
    IdentityClientDTO create(IdentityClientDTO identityClient);

    List<IdentityClientDTO> createAll(List<IdentityClientDTO> identityClients);

    List<IdentityClientDTO> read(Long id);

    List<IdentityClientDTO> readAll();

    IdentityClientDTO update(Long id, IdentityClientDTO identityClient);

    List<IdentityClientDTO> updateAll(List<IdentityClientDTO> identityClients);

    void delete(Long id);

    void deleteAll(List<Long> ids);

    void deleteAll();
}
