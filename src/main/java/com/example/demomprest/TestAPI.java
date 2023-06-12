package com.example.demomprest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
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
    public List<Activity> getActivities(
            @Nullable @RequestParam ("priority") Integer priority,
            @Nullable @RequestParam("name") String name) {
        return activityDatabase.getActivityList(priority, name);
    }

    @DeleteMapping(value="activities", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteActivities(){
        activityDatabase.deleteAll();
    }


    @DeleteMapping(value="activities/{id}")
        public ResponseEntity deleteActivitiesById(@PathVariable("id") Integer id){
       if (activityDatabase.deleteActivityById(id)){
           return ResponseEntity.noContent().build();
       }
        return ResponseEntity.notFound().build();
    }


    @GetMapping(value = "activities/{id}",
    consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
            public ResponseEntity getActivityById(@PathVariable("id") Integer id){
        Activity activity = activityDatabase.getActivityById(id);
        if (activity == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(activity);
    }


}
