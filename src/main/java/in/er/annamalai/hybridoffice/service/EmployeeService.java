package in.er.annamalai.hybridoffice.service;

import java.util.List;

import in.er.annamalai.hybridoffice.dto.EmployeeDTO;

public interface EmployeeService {
    EmployeeDTO create(EmployeeDTO employee);

    List<EmployeeDTO> createAll(List<EmployeeDTO> employees);

    List<EmployeeDTO> read(Long id);

    List<EmployeeDTO> readAll();

    EmployeeDTO update(Long id, EmployeeDTO employee);

    List<EmployeeDTO> updateAll(List<EmployeeDTO> employees);

    void delete(Long id);

    void deleteAll(List<Long> ids);

    void deleteAll();
}
