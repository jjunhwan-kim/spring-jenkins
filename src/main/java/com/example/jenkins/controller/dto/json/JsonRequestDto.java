package com.example.jenkins.controller.dto.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonRequestDto {
    private String serverUrl;
    private Long id;
    private String status;
    private List<JsonDataDto> dataDtoList;
}
