package com._2mozz.wtool.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Workout name is required")
    private String workoutName;
    @NotBlank(message = "Workout Id is required")
    @Size(min=5, max=200, message = "Please use 5 to 254 characters")
    private String description;
    private String reps;

    private String sets;
    private String rest;



    private String minOrSec;
    private String weight;
    @NotBlank(message = "workout day is required")

    private String day ;

    @JsonFormat(pattern = "yyyy-mm-dd")
    @Column(updatable = false)
    private Date created_At;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date updated_At;
@ManyToOne(fetch = FetchType.LAZY)
@JsonIgnore
private User user;

private String projectLeader;

    public Workout() {
    }

    public String getMinOrSec() {
        return minOrSec;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getProjectLeader() {
        return projectLeader;
    }

    public void setProjectLeader(String projectLeader) {

        this.projectLeader = projectLeader;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String workoutDescription) {
        this.description = workoutDescription;
    }

    public String getReps() {
          return returnZero(reps);
    }

    public void setReps(String reps) {

        this.reps = reps;
    }

    public String getSets() {

       return returnZero(sets);
    }

    public void setSets(String sets) {
        this.sets = sets;
    }

    public String getRest() {
        return  returnZero(rest);
    }

    public void setRest(String rest) {
        this.rest = rest;
    }

    public String getWeight() {
        return  returnZero(weight);
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDay() {

        return day;
    }

    public void setDay(String day) {
        String dayOfWeek;

        switch (day){
            case "0":
                dayOfWeek = "Sunday";
                break;
            case "1":
                dayOfWeek = "Monday";
                break;
            case "2":
                dayOfWeek = "Tuesday";
                break;
            case "3":
                dayOfWeek = "Wednesday";
                break;
            case "4":
                dayOfWeek = "Thursday";
                break;
            case "5":
                dayOfWeek = "Friday";
                break;
            case "6":
                dayOfWeek = "Saturday";
                break;

            default:

                dayOfWeek = this.day;

        }
        this.day = dayOfWeek;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }

    public Date getUpdated_At() {
        return updated_At;
    }

    public void setUpdated_At(Date updated_At) {
        this.updated_At = updated_At;
    }
    public String isMinOrSec() {
        return minOrSec;
    }

    public void setMinOrSec(String minOrSec) {
        this.minOrSec = minOrSec;

    }
    //if the value passed to this function is null or "" then return the 0 string.
    public String returnZero( String val) {

        if ( val == null || val == "")
            return "0";

        return val;
    }
    @PrePersist
    protected void onCreate(){
        this.created_At = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updated_At = new Date();
    }
}
