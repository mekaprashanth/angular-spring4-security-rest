package com.prash.spring.batch.config;

import javax.transaction.Transactional;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.PersistJobDataAfterExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Component
@Transactional
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class MyQuartzJobBean extends QuartzJobBean {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
	public static final String COUNT = "count";
	private String name;

	@Autowired
	TestComponent testComponent;
	
	protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
		testComponent.runJob(this.getClass().getSimpleName());
		try {
			JobDataMap dataMap = ctx.getJobDetail().getJobDataMap();
			int cnt = Integer.parseInt(dataMap.getString(COUNT));
			JobKey jobKey = ctx.getJobDetail().getKey();
			System.out.println(jobKey + ": " + name + ": " + cnt);
			log.info(jobKey + ": " + name + ": " + cnt);
			cnt++;
			dataMap.put(COUNT, cnt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setName(String name) {
		this.name = name;
	}

}