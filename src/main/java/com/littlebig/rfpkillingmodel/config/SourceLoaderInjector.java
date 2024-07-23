package com.littlebig.rfpkillingmodel.config;


import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import com.littlebig.rfpkillingmodel.domain.Mission;
import com.littlebig.rfpkillingmodel.service.MissionSourceLoaderService;

@Component
public class SourceLoaderInjector implements ApplicationContextAware {

  private final MissionSourceLoaderService sourceLoaderService;

  @Autowired
  public SourceLoaderInjector(MissionSourceLoaderService sourceLoaderService) {
    this.sourceLoaderService = sourceLoaderService;
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) {
    Mission.setSourceLoaderService(sourceLoaderService);
  }
}
