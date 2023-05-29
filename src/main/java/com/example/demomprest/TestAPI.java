package com.example.demomprest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("test")

public class TestAPI {
    @Autowired
    private ActivityDatabase activityDatabase;

    @GetMapping("v1")
    public String test() {
        return "test";
    }
    @PostMapping(value="activities", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void addActivity(@RequestBody Activity activity){
        activityDatabase.addActivity(activity);
    }

    @GetMapping(value="activities", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Activity> getActivities(){
        return activityDatabase.getAllActivities();
    }

    @DeleteMapping(value="activities", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteActivities(){
        activityDatabase.deleteAll();
    }

}
