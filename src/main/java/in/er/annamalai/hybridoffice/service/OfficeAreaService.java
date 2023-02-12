package in.er.annamalai.hybridoffice.service;

import java.util.List;

import in.er.annamalai.hybridoffice.dto.OfficeAreaDTO;

public interface OfficeAreaService {
    OfficeAreaDTO create(OfficeAreaDTO officeArea);

    List<OfficeAreaDTO> createAll(List<OfficeAreaDTO> officeAreas);

    List<OfficeAreaDTO> read(Long id);

    List<OfficeAreaDTO> readAll();

    OfficeAreaDTO update(Long id, OfficeAreaDTO officeArea);

    List<OfficeAreaDTO> updateAll(List<OfficeAreaDTO> officeAreas);

    void delete(Long id);

    void deleteAll(List<Long> ids);

    void deleteAll();
}
