package com.littlebig.rfpkillingmodel.repo;

import org.springframework.stereotype.Repository;

import com.littlebig.rfpkillingmodel.domain.RFP;

@Repository
public interface RFPRepository extends org.springframework.data.jpa.repository.JpaRepository<RFP, Long> {
}
