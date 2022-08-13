package com.example.jenkins.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RequiredArgsConstructor
@Service
public class JenkinsService {

    private final RestTemplate restTemplate;

    public void requestBuild(String jobName, MultiValueMap<String, String> parameters) {
        if (parameters == null) {
            throw new IllegalArgumentException();
        }

        String url;

        if (parameters.size() == 0) {
            url = "/job/" + jobName + "/build";
        } else {
            url = "/job/" + jobName + "/buildWithParameters";
        }

        parameters.add("token", "Build");

        ResponseEntity<String> response = restTemplate.postForEntity(url, parameters, String.class);
        log.info("statusCode={}, body={}", response.getStatusCode(), response.getBody());
    }
}
