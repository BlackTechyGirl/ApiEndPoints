package com.myEndPoint.controller;


import com.myEndPoint.dto.request.ApiRequest;
import com.myEndPoint.dto.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    @GetMapping("/data")
    public ApiResponse getData(String name, String track){
        DayOfWeek currentDayOfTheWeek = LocalDateTime.now(ZoneId.of("UTC")).getDayOfWeek();
        String currentDay = currentDayOfTheWeek.toString();

        LocalDateTime currentTime = LocalDateTime.now(ZoneId.of("UTC"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String utcTime = formatter.format(currentTime);

        String githubFileUrl = "";
        String githubRepoUrl = "";
        HttpStatus statusCode = HttpStatus.OK;

        return new ApiResponse(name, currentDay, utcTime, track, githubFileUrl,
                githubRepoUrl, statusCode);
    }

}
