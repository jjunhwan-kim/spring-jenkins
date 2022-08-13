package com.example.jenkins.controller;

import com.example.jenkins.controller.dto.json.JsonRequestDto;
import com.example.jenkins.service.JenkinsService;
import com.example.jenkins.controller.dto.param.ParamDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class JenkinsController {

    private final ObjectMapper objectMapper;
    private final JenkinsService jenkinsService;

    @PostMapping("/jenkins/param")
    public void build(ParamDto paramDto) {
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("param1", paramDto.getParam1());
        parameters.add("param2", paramDto.getParam2());

        jenkinsService.requestBuild("Param", parameters);
    }

    @PostMapping("/jenkins/json")
    public void build(@RequestBody JsonRequestDto jsonRequestDto) throws JsonProcessingException {
        String json = objectMapper.writeValueAsString(jsonRequestDto);
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("json", json);

        jenkinsService.requestBuild("JSON", parameters);
    }
}
