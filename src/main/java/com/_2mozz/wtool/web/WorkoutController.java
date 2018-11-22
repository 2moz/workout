
package com._2mozz.wtool.web;

import com._2mozz.wtool.domain.Workout;
import com._2mozz.wtool.services.MapValidationErrorService;
import com._2mozz.wtool.services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/api/workout")
@CrossOrigin
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;
    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewWorkout(@Valid @RequestBody Workout workout, BindingResult result, Principal principal) {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null) return errorMap;
        Workout workout1 = workoutService.saveOrUpdateWorkout(workout, principal.getName());
        return new ResponseEntity<Workout>(workout, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getWorkoutById(@PathVariable Long id, Principal principal) {
        Workout workout = workoutService.findWorkout(id, principal.getName());

        return new ResponseEntity<Workout>(workout, HttpStatus.OK);

    }

    @GetMapping("/workouts")
    public Iterable<Workout> getAllWorkouts(Principal principal){return workoutService.findAllWorkouts(principal.getName());}

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteWorkout(@PathVariable Long id, Principal principal){
        workoutService.deleteWorkout(id, principal.getName());
        return new ResponseEntity<String>("Workout with Id : " + id + " was deleted ", HttpStatus.OK);

    }
}