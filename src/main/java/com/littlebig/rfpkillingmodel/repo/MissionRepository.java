package com.littlebig.rfpkillingmodel.repo;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.littlebig.rfpkillingmodel.domain.Mission;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {
}

