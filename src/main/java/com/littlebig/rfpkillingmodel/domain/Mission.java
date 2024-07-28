package com.littlebig.rfpkillingmodel.domain;

import java.util.Optional;

import com.littlebig.rfpkillingmodel.service.MissionSourceLoaderService;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Mission<T extends MissionSource>{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private Long sourceId;
  private MissionSourceTypes sourceType;
  private String missionDescription;

  @Transient
  private T source;

  @Transient
  private static MissionSourceLoaderService sourceLoaderService;

  @PostLoad
  public void loadSource() {
    if (sourceLoaderService != null) {
      this.source = sourceLoaderService.loadSource(this.sourceId, this.sourceType);
    }
  }

  public static void setSourceLoaderService(MissionSourceLoaderService sourceLoaderService) {
    Mission.sourceLoaderService = sourceLoaderService;
  }

  public Optional<Long> getRfpId(){
    return MissionSourceTypes.RFP == sourceType ? Optional.of(this.sourceId) : Optional.empty();
  }

  public Optional<Long> getQuotationId(){
    return MissionSourceTypes.QUOTATION == sourceType ? Optional.of(this.sourceId) : Optional.empty();
  }


}
