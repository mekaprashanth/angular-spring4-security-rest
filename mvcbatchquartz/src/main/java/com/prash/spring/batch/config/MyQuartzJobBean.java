package com.prash.spring.batch.config;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Component
public class MyQuartzJobBean extends QuartzJobBean {

	public static final String COUNT = "count";
	private String name;

	protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
		try {
			JobDataMap dataMap = ctx.getJobDetail().getJobDataMap();
			int cnt = dataMap.getInt(COUNT);
			JobKey jobKey = ctx.getJobDetail().getKey();
			System.out.println(jobKey + ": " + name + ": " + cnt);
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