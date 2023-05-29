package com.example.demomprest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class ActivityDatabase {
    private List<Activity> activityList = new ArrayList<>();

    public List<Activity> getAllActivities(){
        return activityList;
    }
    public void addActivity (Activity activity){
        activityList.add(activity);
    }

    public void deleteAll(){
        activityList.clear();
    }
}
