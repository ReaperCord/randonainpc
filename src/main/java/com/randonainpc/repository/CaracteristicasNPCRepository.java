package com.randonainpc.repository;

import com.randonainpc.model.CaracteristicasNPC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaracteristicasNPCRepository extends JpaRepository<CaracteristicasNPC, Long> {


}
