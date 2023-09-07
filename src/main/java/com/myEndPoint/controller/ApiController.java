package com.myEndPoint.controller;


import com.myEndPoint.DataException;
import com.myEndPoint.dto.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api")
public class ApiController {
        @GetMapping()
        public ResponseEntity<ApiResponse> getData(@RequestParam String slack_name, @RequestParam String track) {
            try {
                if (slack_name == null || slack_name.isEmpty() || track == null || track.isEmpty()) {
                    throw new DataException("Name and track must be provided");
                }

                DayOfWeek currentDayOfTheWeek = LocalDateTime.now(ZoneId.of("UTC")).getDayOfWeek();
                String current_day = currentDayOfTheWeek.name().substring(0, 1) + currentDayOfTheWeek.name().substring(1).toLowerCase();

                LocalDateTime currentTime = LocalDateTime.now(ZoneId.of("UTC"));
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
                String utc_time = formatter.format(currentTime);

                String github_file_url = "https://github.com/BlackTechyGirl/ApiEndPoints/blob/main/src/main/java/com/myEndPoint/controller/ApiController.java";
                String github_repo_url = "https://github.com/BlackTechyGirl/ApiEndPoints";
                int status_code = 200;

                ApiResponse response = new ApiResponse(slack_name, current_day, utc_time, track, github_file_url, github_repo_url, status_code);

                return ResponseEntity.ok(response);
            } catch (DataException e) {
                return ResponseEntity.badRequest().body(new ApiResponse("Error", e.getMessage(), "", "", "", "", 400));
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("Error", "An error occurred", "", "", "", "", 500));
            }
        }



//    @GetMapping()
//    public ApiResponse getData(@RequestParam String name, @RequestParam String track){
//        DayOfWeek currentDayOfTheWeek = LocalDateTime.now(ZoneId.of("UTC")).getDayOfWeek();
//        String currentDay = currentDayOfTheWeek.toString();
//
//        LocalDateTime currentTime = LocalDateTime.now(ZoneId.of("UTC"));
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
//        String utcTime = formatter.format(currentTime);
//
//        String githubFileUrl = "https://github.com/BlackTechyGirl/ApiEndPoints/blob/main/src/main/java/com/myEndPoint/controller/ApiController.java";
//        String githubRepoUrl = "https://github.com/BlackTechyGirl/ApiEndPoints";
//        int statusCode = 200;
//
//        return new ApiResponse(name, currentDay, utcTime, track, githubFileUrl,
//                githubRepoUrl, statusCode);
//    }

}
