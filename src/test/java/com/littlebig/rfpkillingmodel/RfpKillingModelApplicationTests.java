package com.littlebig.rfpkillingmodel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.littlebig.rfpkillingmodel.domain.Mission;
import com.littlebig.rfpkillingmodel.domain.Quotation;
import com.littlebig.rfpkillingmodel.domain.RFP;
import com.littlebig.rfpkillingmodel.repo.QuotationRepository;
import com.littlebig.rfpkillingmodel.repo.RFPRepository;
import com.littlebig.rfpkillingmodel.service.MissionService;

@SpringBootTest
class RfpKillingModelApplicationTests {

  @Autowired
  private MissionService missionService;

  @Autowired
  private RFPRepository rfpRepository;

  @Autowired
  private QuotationRepository quotationRepository;

  @Test
  void testCreation() {

    RFP rfp = new RFP();
    rfp.setDescription("New RFP");
    rfp = rfpRepository.save(rfp);

    Quotation quotation = new Quotation();
    quotation.setName("New Quotation");
    quotation = quotationRepository.save(quotation);

    Mission<RFP> missionFromRFP = missionService.createMissionFromRFP(rfp.getId());
    missionFromRFP = missionService.getMission(missionFromRFP.getId());
    Mission<Quotation> missionFromQuotation = missionService.createMissionFromQuotation(quotation.getId());
    missionFromQuotation = missionService.getMission(missionFromQuotation.getId());

    System.out.println("Mission from RFP: " + missionFromRFP.getId());
    System.out.println("Mission from Quotation: " + missionFromQuotation.getId());

    Assertions.assertEquals(missionFromRFP.getSource().getId(), rfp.getId());

    Assertions.assertEquals(missionFromQuotation.getSource().getId(), quotation.getId());
  }
}