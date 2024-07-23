package com.littlebig.rfpkillingmodel.domain;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class RFP extends BaseEntity {
  private String description;
}