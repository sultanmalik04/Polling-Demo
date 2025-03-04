package com.sultan.Polling.Demo.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiPollingJob implements Job {

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String apiUrl = "https://catfact.ninja/fact";
        String response = restTemplate.getForObject(apiUrl, String.class);
        System.out.println("API response: " + response);
        // Process the response as needed
    }
}
