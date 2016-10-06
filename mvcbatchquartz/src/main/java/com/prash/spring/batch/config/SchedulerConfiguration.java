/**
 * 
 */
package com.prash.spring.batch.config;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.expression.ParseException;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author Prashanth_Meka
 *
 */

@Configuration
public class SchedulerConfiguration {
	
    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());


	@Autowired
	DataSource dataSource;

	@Autowired
	PlatformTransactionManager transactionManager;
	
	@Autowired
	private ApplicationContext applicationContext;

	@Bean
	public JobDetailFactoryBean testJob1() throws ClassNotFoundException, NoSuchMethodException {
		JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
		jobDetailFactory.setBeanName("test1");
		jobDetailFactory.setJobClass(MyQuartzJobBean.class);
		Map<String, Object> map = new HashMap<>();
		map.put("name", "RAM");
		map.put(MyQuartzJobBean.COUNT, "1");
		map.put("Date", (new Date()).toString());
		jobDetailFactory.setJobDataAsMap(map);
		jobDetailFactory.setGroup("mygroup");
		jobDetailFactory.setName("myjob1");
		jobDetailFactory.setDurability(true);
		return jobDetailFactory;
	}
	
	@Bean
	public JobDetailFactoryBean testJob2() throws ClassNotFoundException, NoSuchMethodException {
		JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
		jobDetailFactory.setBeanName("test2");
		jobDetailFactory.setJobClass(MyJob.class);
		Map<String, Object> map = new HashMap<>();
		map.put("someParam", "RAM");
		map.put("someParam2", "1");
		jobDetailFactory.setJobDataAsMap(map);
		jobDetailFactory.setGroup("mygroup");
		jobDetailFactory.setName("myjob2");
		jobDetailFactory.setDurability(true);
		return jobDetailFactory;
	}

	@Bean
	public CronTriggerFactoryBean testJob1Trigger()
			throws ParseException, ClassNotFoundException, NoSuchMethodException {
		CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
		cronTriggerFactoryBean.setBeanName("prash.testJobTrigger");
		cronTriggerFactoryBean.setJobDetail(testJob1().getObject());
		cronTriggerFactoryBean.setCronExpression("0/15 * * * * ?");
		cronTriggerFactoryBean.setName("mytrigger1");
		cronTriggerFactoryBean.setGroup("mygroup");
		return cronTriggerFactoryBean;
	}
	
	@Bean
	public CronTriggerFactoryBean testJob2Trigger()
			throws ParseException, ClassNotFoundException, NoSuchMethodException {
		CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
		cronTriggerFactoryBean.setBeanName("prash.testJobTrigger");
		cronTriggerFactoryBean.setJobDetail(testJob2().getObject());
		cronTriggerFactoryBean.setCronExpression("0/15 * * * * ?");
		cronTriggerFactoryBean.setName("mytrigger2");
		cronTriggerFactoryBean.setGroup("mygroup");
		return cronTriggerFactoryBean;
	}

	@Bean
	public SchedulerFactoryBean setupSchedulerFactoryBean()
			throws ClassNotFoundException, NoSuchMethodException, IOException {
		SchedulerFactoryBean schedulerfaFactoryBean = new SchedulerFactoryBean();
		schedulerfaFactoryBean.setDataSource(dataSource);
		schedulerfaFactoryBean.setTransactionManager(transactionManager);
		schedulerfaFactoryBean.setTriggers(testJob1Trigger().getObject(),testJob2Trigger().getObject());
		schedulerfaFactoryBean.setOverwriteExistingJobs(true);
		schedulerfaFactoryBean.setSchedulerName("prash-scheduler");
		schedulerfaFactoryBean.setWaitForJobsToCompleteOnShutdown(true);
		schedulerfaFactoryBean.setQuartzProperties(quartzProperties());

		AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
		jobFactory.setApplicationContext(applicationContext);
		schedulerfaFactoryBean.setJobFactory(jobFactory);

		return schedulerfaFactoryBean;
	}
	
	@Bean
	public Properties quartzProperties() {
		PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
		propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
		Properties properties = null;
		try {
			propertiesFactoryBean.afterPropertiesSet();
			properties = propertiesFactoryBean.getObject();

		} catch (IOException e) {
			log.warn("Cannot load quartz.properties.");
		}

		return properties;
	}

	@PostConstruct
	public void init() {
		log.debug("QuartzConfig initialized.");
	}

}
