package com.littlebig.rfpkillingmodel.domain;

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
public class Mission {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private Long sourceId;
  private MissionSource sourceType;
  private String missionDescription;

  @Transient
  private BaseEntity source;

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
}
