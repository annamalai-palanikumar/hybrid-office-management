package in.er.annamalai.hybridoffice.service;

import java.util.List;

import in.er.annamalai.hybridoffice.dto.OfficeDTO;

public interface OfficeService {
    OfficeDTO create(OfficeDTO office);

    List<OfficeDTO> createAll(List<OfficeDTO> offices);

    List<OfficeDTO> read(Long id);

    List<OfficeDTO> readAll();

    OfficeDTO update(Long id, OfficeDTO office);

    List<OfficeDTO> updateAll(List<OfficeDTO> offices);

    void delete(Long id);

    void deleteAll(List<Long> ids);

    void deleteAll();
}
