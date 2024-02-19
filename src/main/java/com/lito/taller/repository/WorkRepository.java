package com.lito.taller.repository;

import com.lito.taller.dto.work.WorkDataDTO;
import com.lito.taller.entity.Vehicle;
import com.lito.taller.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface WorkRepository extends JpaRepository<Work, Long> {

    @Query(value = "select w.id, w.summary, w.status, w.date_reception, w.date_pickup, w.vehicle_id from work w where w.client_id  = :id", nativeQuery = true )
    Set<WorkDataDTO> findByClientId(long id);

    @Query(value = "select w.id, w.summary, w.status, w.date_reception, w.date_pickup, w.client_id from work w where w.vehicle_id  = :id", nativeQuery = true )
    Set<WorkDataDTO> findByVehicleId(long id);

}
