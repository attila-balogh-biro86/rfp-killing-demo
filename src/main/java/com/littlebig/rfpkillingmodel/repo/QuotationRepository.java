package com.littlebig.rfpkillingmodel.repo;

import org.springframework.stereotype.Repository;

import com.littlebig.rfpkillingmodel.domain.Quotation;

@Repository
public interface QuotationRepository extends BaseRepository<Quotation, Long> {
}
