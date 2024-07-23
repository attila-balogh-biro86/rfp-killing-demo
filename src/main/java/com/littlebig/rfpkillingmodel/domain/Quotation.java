package com.littlebig.rfpkillingmodel.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Quotation extends BaseEntity {
  private String name;
}