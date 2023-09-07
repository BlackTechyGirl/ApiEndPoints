package com.myEndPoint.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {

    private String name;
    private String currentDay;
    private String utcTime;
    private String track;
    private String githubFileUrl;
    private String githubRepoUrl;
    private int statusCode;

}
