package com.ttknp.springbootondockerapp.repository;

import com.ttknp.springbootondockerapp.entity.Romance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RomanceRepository extends JpaRepository<Romance,String> {

}
