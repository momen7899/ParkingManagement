package com.momen.parking.service.impl;

import com.momen.parking.common.exception.NotFoundException;
import com.momen.parking.model.Parking;
import com.momen.parking.model.PriceRate;
import com.momen.parking.model.Vehicle;
import com.momen.parking.repository.ParkingRepository;
import com.momen.parking.service.ParkingService;
import com.momen.parking.service.PriceRateService;
import com.momen.parking.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ParkingServiceImpl implements ParkingService {

    private ParkingRepository repository;
    private VehicleService vehicleService;
    private PriceRateService priceRateService;

    @Override
    public Parking addParking(Parking parking) {
        Vehicle vehicle = vehicleService.getVehicle(parking.getVehicle().getId());
        PriceRate priceRate = priceRateService.getPriceRate(parking.getPriceRate().getId());
        parking.setVehicle(vehicle);
        parking.setPriceRate(priceRate);
        parking.setEntryTime(new Date());
        return repository.save(parking);
    }

    @Override
    public Parking leaveParking(Parking parking) {
        Parking savedBefore = getParking(parking.getId());
        savedBefore.setExitTime(new Date());
        savedBefore.setTotalPrice(calculatePrice(savedBefore));
        return repository.save(savedBefore);
    }

    @Override
    public void deleteParking(Long parkingId) {
        Parking savedBefore = getParking(parkingId);
        repository.delete(savedBefore);
    }

    @Override
    public Parking getParking(Long parkingId) {
        Optional<Parking> optionalParking = repository.findById(parkingId);

        if (optionalParking.isPresent())
            return optionalParking.get();

        throw new NotFoundException("Parking not found");
    }

    @Override
    public Page<Parking> paging(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page, size, Sort.by("id").ascending()));
    }

    @Override
    public List<Parking> getAll() {
        return (List<Parking>) repository.findAll();
    }

    private Long calculatePrice(Parking parking) {
        long time_difference = parking.getExitTime().getTime() - parking.getEntryTime().getTime();
        long hours_difference = (time_difference / (1000 * 60 * 60)) % 24;
        long days_difference = (time_difference / (1000 * 60 * 60 * 24));
        long month_difference = days_difference / 30;
        days_difference %= 30;

        Long answer = parking.getPriceRate().getEntry();
        answer += hours_difference * parking.getPriceRate().getHourly();
        if (days_difference == 0)
            return answer;

        answer += days_difference * parking.getPriceRate().getDaily();

        if (month_difference == 0) {
            return answer;
        }

        answer += month_difference * parking.getPriceRate().getMonthly();

        return answer;
    }

    @Override
    public Parking confirmPayment(Long parkingId) {
        Parking savedBefore = getParking(parkingId);
        savedBefore.setIsPaid(true);
        return repository.save(savedBefore);
    }

    @Override
    public List<Parking> vehicleTrafficReport(Vehicle vehicle) {
        return repository.findAllByVehicle_Id(vehicle.getId());
    }

    @Override
    public Page<Parking> pagingVehicleTrafficReport(Integer page, Integer size, Vehicle vehicle) {
        return repository.findAllByVehicle_Id(vehicle.getId(), PageRequest.of(page, size, Sort.by("id").ascending()));
    }

}
