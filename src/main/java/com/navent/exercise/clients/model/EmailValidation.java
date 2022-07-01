package com.navent.exercise.clients.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class EmailValidation implements Serializable {
    private static final long serialVersionUID = -1146322582622493922L;
    private String email;

    @JsonProperty("delivered_percent")
    private Long delivered;

    @JsonProperty("opened_percent")
    private Long opened;

    @JsonProperty("click_percent")
    private Long click;

    @JsonProperty("dropped_percent")
    private Long dropped;

    public String test() {
        return "hola";
    }


}
