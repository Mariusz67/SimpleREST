package com.example.demomprest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.Value;

@JsonSerialize
@Data
public class Activity {

    @JsonProperty("id")
    private Integer id;

   @JsonProperty("nazwa")
    private String name;

   @JsonProperty ("priorytet")
    private Integer priority;

}
