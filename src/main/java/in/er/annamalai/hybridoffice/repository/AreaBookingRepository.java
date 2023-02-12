package in.er.annamalai.hybridoffice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.er.annamalai.hybridoffice.entity.AreaBooking;

public interface AreaBookingRepository extends JpaRepository<AreaBooking, Long>{
    List<AreaBooking> findAllByEmployeeId(Long employeeId);

    List<AreaBooking> findAllByAreaId(Long areaId);
}
