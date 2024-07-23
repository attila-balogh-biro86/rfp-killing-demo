package com.littlebig.rfpkillingmodel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.littlebig.rfpkillingmodel.domain.BaseEntity;
import com.littlebig.rfpkillingmodel.domain.MissionSource;
import com.littlebig.rfpkillingmodel.repo.QuotationRepository;
import com.littlebig.rfpkillingmodel.repo.RFPRepository;

@Service
public class MissionSourceLoaderService {

  private final RFPRepository rfpRepository;
  private final QuotationRepository quotationRepository;

  @Autowired
  public MissionSourceLoaderService(RFPRepository rfpRepository, QuotationRepository quotationRepository) {
    this.rfpRepository = rfpRepository;
    this.quotationRepository = quotationRepository;
  }

  public BaseEntity loadSource(Long sourceId, MissionSource sourceType) {
    if (MissionSource.RFP.equals(sourceType)) {
      return rfpRepository.findById(sourceId).orElse(null);
    } else if (MissionSource.QUOTATION.equals(sourceType)) {
      return quotationRepository.findById(sourceId).orElse(null);
    }
    throw new IllegalArgumentException("Invalid sourceType: " + sourceType);
  }
}

