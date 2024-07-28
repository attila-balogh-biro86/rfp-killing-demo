package com.littlebig.rfpkillingmodel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.littlebig.rfpkillingmodel.domain.MissionSource;
import com.littlebig.rfpkillingmodel.domain.MissionSourceTypes;
import com.littlebig.rfpkillingmodel.repo.QuotationRepository;
import com.littlebig.rfpkillingmodel.repo.RFPRepository;

@Service
public class MissionSourceLoaderService{

  private final RFPRepository rfpRepository;
  private final QuotationRepository quotationRepository;

  @Autowired
  public MissionSourceLoaderService(RFPRepository rfpRepository, QuotationRepository quotationRepository) {
    this.rfpRepository = rfpRepository;
    this.quotationRepository = quotationRepository;
  }

  public <T extends MissionSource> T loadSource(Long sourceId, MissionSourceTypes sourceType) {
    if (MissionSourceTypes.RFP.equals(sourceType)) {
      return (T) rfpRepository.findById(sourceId).orElseThrow(() -> new IllegalStateException("Missing RFP with id: "+sourceId));
    } else if (MissionSourceTypes.QUOTATION.equals(sourceType)) {
      return (T) quotationRepository.findById(sourceId).orElseThrow(() -> new IllegalStateException("Missing Quotation with id: "+sourceId));
    }
    throw new IllegalArgumentException("Invalid sourceType: " + sourceType);
  }
}

