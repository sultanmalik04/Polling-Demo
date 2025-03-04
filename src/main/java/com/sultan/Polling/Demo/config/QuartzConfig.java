package com.sultan.Polling.Demo.config;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sultan.Polling.Demo.job.ApiPollingJob;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail jobDetail() {
        return JobBuilder.newJob(ApiPollingJob.class)
                .withIdentity("apiPollingJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger trigger(JobDetail jobDetail) {
        return TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .withIdentity("apiPollingTrigger")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInMinutes(2)
                        // .withIntervalInHours(2)
                        .repeatForever())
                .build();
    }
}
