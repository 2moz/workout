package com._2mozz.wtool.exeptions;

public class WorkoutExceptionResponse {

    private String workoutid;

    public WorkoutExceptionResponse(String workoutid) {
        this.workoutid = workoutid;
    }

    public String getWorkoutid() {
        return workoutid;
    }

    public void setWorkoutid(String workoutid) {
        this.workoutid = workoutid;
    }
}
