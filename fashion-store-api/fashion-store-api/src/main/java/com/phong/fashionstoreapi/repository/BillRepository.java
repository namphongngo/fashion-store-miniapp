package com.phong.fashionstoreapi.repository;

import com.phong.fashionstoreapi.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {

}
