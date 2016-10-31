/**
 * 
 */
package com.prash.spring.batch.config;

import javax.transaction.Transactional;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Prashanth_Meka
 *
 */


@Component
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
@Transactional
public class MyJob implements Job {
    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    private String someParam;
    private String someParam2;
    
    @Autowired
	TestComponent testComponent;

    public void setSomeParam(String someParam) {
        this.someParam = someParam;
    }

    public void setSomeParam2(String someParam2) {
        this.someParam2 = someParam2;
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
		testComponent.runJob(this.getClass().getSimpleName());

        System.out.println("My job is running with "+someParam+' '+someParam2);
        log.info("My job is running with "+someParam+' '+someParam2);
    }}
