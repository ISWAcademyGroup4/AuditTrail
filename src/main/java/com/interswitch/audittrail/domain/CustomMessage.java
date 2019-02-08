package com.interswitch.audittrail.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;

@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,property="@id", scope = CustomMessage.class)
public class CustomMessage implements Serializable {

    private String description;
    private String role;
    private String event;
    private String eventdate;

    public CustomMessage() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEventdate() {
        return eventdate;
    }

    public void setEventdate(String eventdate) {
        this.eventdate = eventdate;
    }

    @Override
    public String toString() {
        return "CustomMessage{" +
                "description='" + description + '\'' +
                ", role='" + role + '\'' +
                ", event='" + event + '\'' +
                ", eventdate=" + eventdate +
                '}';
    }
}
