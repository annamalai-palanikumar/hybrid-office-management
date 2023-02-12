package in.er.annamalai.hybridoffice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.er.annamalai.hybridoffice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
}
