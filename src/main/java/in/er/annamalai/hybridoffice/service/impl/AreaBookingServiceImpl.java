package in.er.annamalai.hybridoffice.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.er.annamalai.hybridoffice.dto.AreaBookingDTO;
import in.er.annamalai.hybridoffice.entity.AreaBooking;
import in.er.annamalai.hybridoffice.repository.AreaBookingRepository;
import in.er.annamalai.hybridoffice.service.AreaBookingService;

@Service
public class AreaBookingServiceImpl implements AreaBookingService {

    @Autowired
    private AreaBookingRepository areaBookingRepository;

    @Override
    public AreaBookingDTO create(AreaBookingDTO areaBooking, Long areaId, Long employeeId) {
        return new AreaBookingDTO(areaBookingRepository.save(new AreaBooking(areaBooking.getStart(), areaBooking.getStop(), areaId, employeeId)));
    }

    @Override
    public List<AreaBookingDTO> createAll(List<AreaBookingDTO> areaBookings, Long areaId, Long employeeId) {
        List<AreaBookingDTO> createdAreaBookings = new ArrayList<>();
        List<AreaBooking> areaBookingEntities = new ArrayList<>();
        for(AreaBookingDTO areaBooking : areaBookings) {
            areaBookingEntities.add(new AreaBooking(areaBooking.getStart(), areaBooking.getStop(), areaId, employeeId));
        }
        areaBookingEntities = areaBookingRepository.saveAll(areaBookingEntities);
        for(AreaBooking areaBooking: areaBookingEntities) {
            createdAreaBookings.add(new AreaBookingDTO(areaBooking));
        }
        return createdAreaBookings;
    }

    @Override
    public List<AreaBookingDTO> createAll(List<AreaBookingDTO> areaBookings) {
        List<AreaBookingDTO> createdAreaBookings = new ArrayList<>();
        List<AreaBooking> areaBookingEntities = new ArrayList<>();
        for(AreaBookingDTO areaBooking : areaBookings) {
            areaBookingEntities.add(new AreaBooking(areaBooking.getStart(), areaBooking.getStop(), areaBooking.getArea().getId(), areaBooking.getEmployee().getId()));
        }
        areaBookingEntities = areaBookingRepository.saveAll(areaBookingEntities);
        for(AreaBooking areaBooking: areaBookingEntities) {
            createdAreaBookings.add(new AreaBookingDTO(areaBooking));
        }
        return createdAreaBookings;
    }

    @Override
    public AreaBookingDTO read(Long id) {
        return new AreaBookingDTO(areaBookingRepository.findById(id).orElseThrow());
    }

    @Override
    public List<AreaBookingDTO> readAll(Long employeeId) {
        List<AreaBookingDTO> areaBookings = new ArrayList<>();
        List<AreaBooking> employeeBookings = areaBookingRepository.findAllByEmployeeId(employeeId);
        for(AreaBooking booking: employeeBookings) {
            areaBookings.add(new AreaBookingDTO(booking));
        }
        return areaBookings;
    }

    @Override
    public List<AreaBookingDTO> readAllByAreaId(Long areaId) {
        List<AreaBookingDTO> areaBookings = new ArrayList<>();
        List<AreaBooking> employeeBookings = areaBookingRepository.findAllByAreaId(areaId);
        for(AreaBooking booking: employeeBookings) {
            areaBookings.add(new AreaBookingDTO(booking));
        }
        return areaBookings;
    }

    @Override
    public List<AreaBookingDTO> readAll(Date start, Date stop) {
        
    }

    @Override
    public List<AreaBookingDTO> readAll(Long employeeId, Date start, Date stop) {

    }

    @Override
    public List<AreaBookingDTO> readAllByAreaId(Long areaId, Date start, Date stop) {

    }

    @Override
    public AreaBookingDTO update(Long id, AreaBookingDTO areaBooking) {

    }

    @Override
    public List<AreaBookingDTO> updateAll(List<AreaBookingDTO> areaBookings) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void deleteAll(List<Long> ids) {

    }

    @Override
    public void deleteAll(Long employeeId) {

    }

    @Override
    public void deleteAllByAreaId(Long areaId) {

    }

    @Override
    public void deleteAll(Date start, Date stop) {

    }

    @Override
    public void deleteAll(Long employeeId, Date start, Date stop) {

    }

    @Override
    public void deleteAllByAreaId(Long areaId, Date start, Date stop) {

    }

    @Override
    public void deleteAll() {

    }

}
