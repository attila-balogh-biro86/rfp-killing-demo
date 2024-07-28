package com.littlebig.rfpkillingmodel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.littlebig.rfpkillingmodel.domain.Mission;
import com.littlebig.rfpkillingmodel.domain.MissionSourceTypes;
import com.littlebig.rfpkillingmodel.repo.MissionRepository;

@Service
public class MissionService {

  private final MissionRepository missionRepository;

  @Autowired
  public MissionService(MissionRepository missionRepository) {
    this.missionRepository = missionRepository;
  }

  public Mission createMissionFromRFP(Long rfpId) {
    Mission mission = new Mission();
    mission.setSourceId(rfpId);
    mission.setSourceType(MissionSourceTypes.RFP);
    mission.setMissionDescription("Mission from RFP");
    return missionRepository.save(mission);
  }

  public Mission createMissionFromQuotation(Long quotationId) {
    Mission mission = new Mission();
    mission.setSourceId(quotationId);
    mission.setSourceType(MissionSourceTypes.QUOTATION);
    mission.setMissionDescription("Mission from quotation");
    return missionRepository.save(mission);
  }

  public Mission getMission(Long id) {
    return missionRepository.findById(id).orElse(null);
  }
}
