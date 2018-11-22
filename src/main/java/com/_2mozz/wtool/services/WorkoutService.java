package com._2mozz.wtool.services;


import com._2mozz.wtool.domain.User;
import com._2mozz.wtool.domain.Workout;
import com._2mozz.wtool.exeptions.WorkoutException;
import com._2mozz.wtool.repositories.UserRepository;
import com._2mozz.wtool.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorkoutService {


    @Autowired
    private WorkoutRepository workoutRepository;
    @Autowired
    private UserRepository userRepository;


    public Workout saveOrUpdateWorkout(Workout workout, String username) {
        if(workout.getId() != null)
        {
            Workout existingWorkout = workoutRepository.getById(workout.getId());

            if(existingWorkout != null &&(!existingWorkout.getProjectLeader().equals(username))){
                throw new WorkoutException("workout not found in your account");
            }else if(existingWorkout == null){
                throw new WorkoutException("Workout with Id: '" +workout.getId()+"' can not be updated because id does not exist");
            }

        }


        User user = userRepository.findByUsername(username);
        workout.setUser(user);
        workout.setProjectLeader(user.getUsername());
        if(!workout.getProjectLeader().equals(username)){
            throw new WorkoutException("Workout not found in your account");
        }
        return workoutRepository.save(workout);
    }

    public Workout findWorkout(Long id, String username) {
            Workout workout = workoutRepository.getById(id);
            if (workout == null) {
                throw new WorkoutException(" Workout number '" + id + "' does not exist");
            }
            if(!workout.getProjectLeader().equals(username)){
                throw new WorkoutException("Workout not found in your account");
            }
            return workout;

    }


    public Iterable<Workout> findAllWorkouts(String username) {
        return workoutRepository.findAllByProjectLeader(username);
    }
    public void deleteWorkout(Long id, String username) {
            workoutRepository.delete(findWorkout(id, username));
    }
}


