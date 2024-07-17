package com.camunda.training.payment;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@ExternalTaskSubscription("creditCardCharging")
public class CreditCardHandler implements ExternalTaskHandler {

  private static final Logger LOG = LoggerFactory.getLogger(CreditCardHandler.class);

  @Override
  public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
    LOG.info("handle topic {} for task id {}", externalTask.getTopicName(), externalTask.getId());
    // TODO Add your business logic here
    
    
    System.out.println("Updating the CTM and getting the letter type  " );
    
    
    externalTaskService.complete(externalTask);

  }
  
}
