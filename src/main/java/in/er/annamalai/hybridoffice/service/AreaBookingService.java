package in.er.annamalai.hybridoffice.service;

import java.util.Date;
import java.util.List;

import in.er.annamalai.hybridoffice.dto.AreaBookingDTO;

public interface AreaBookingService {
    AreaBookingDTO create(AreaBookingDTO areaBooking, Long areaId, Long employeeId);

    List<AreaBookingDTO> createAll(List<AreaBookingDTO> areaBookings, Long areaId, Long employeeId);

    List<AreaBookingDTO> createAll(List<AreaBookingDTO> areaBookings);

    AreaBookingDTO read(Long id);

    List<AreaBookingDTO> readAll(Long employeeId);

    List<AreaBookingDTO> readAllByAreaId(Long areaId);

    List<AreaBookingDTO> readAll(Date start, Date stop);

    List<AreaBookingDTO> readAll(Long employeeId, Date start, Date stop);

    List<AreaBookingDTO> readAllByAreaId(Long areaId, Date start, Date stop);

    AreaBookingDTO update(Long id, AreaBookingDTO areaBooking);

    List<AreaBookingDTO> updateAll(List<AreaBookingDTO> areaBookings);

    void delete(Long id);

    void deleteAll(List<Long> ids);

    void deleteAll(Long employeeId);

    void deleteAllByAreaId(Long areaId);

    void deleteAll(Date start, Date stop);

    void deleteAll(Long employeeId, Date start, Date stop);

    void deleteAllByAreaId(Long employeeId, Date start, Date stop);

    void deleteAll();
}
