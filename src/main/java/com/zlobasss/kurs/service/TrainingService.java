package com.zlobasss.kurs.service;

import com.zlobasss.kurs.dto.*;
import com.zlobasss.kurs.entity.*;
import com.zlobasss.kurs.exception.ErrorBody;
import com.zlobasss.kurs.exception.ErrorException;
import com.zlobasss.kurs.pk.FoodListPK;
import com.zlobasss.kurs.pk.TrainingPK;
import com.zlobasss.kurs.repository.*;
import com.zlobasss.kurs.security.JwtHelper;
import com.zlobasss.kurs.serviceInterface.ITrainingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TrainingService implements ITrainingService {

    @Autowired
    private final TrainingRepo trainingRepo;

    @Autowired
    private final UserRepo userRepo;

    @Autowired
    private final ExerciseRepo exerciseRepo;

    @Autowired
    private final JwtHelper jwtHelper;

    @Override
    public ResponseEntity<?> add(TrainingRequest dto, Date date, String token) {

        token = token.replaceFirst("Bearer ", "");

        User user = userRepo.findByLogin(jwtHelper.getUsernameFromToken(token)).get();

        Optional<Exercise> exercise = exerciseRepo.findById(dto.getExerciseId());
        String messageError = "Not found:";

        if (exercise.isEmpty()) {
            messageError += "\nExercise";
            ErrorException exception = new ErrorException(
                    new ErrorBody(HttpStatus.NOT_FOUND.value(), messageError));
            return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
        }

        TrainingPK pk = new TrainingPK();
        pk.setExerciseId(exercise.get());
        pk.setUserId(user);
        pk.setDate(date);

        Training training = trainingRepo.save(Training.builder()
                .pk(pk)
                .isCompleted(false)
                .build());

        TrainingCreatedResponse response = new TrainingCreatedResponse(
                pk.getDate(),
                pk.getExerciseId().getName(),
                training.isCompleted()
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> readAll(String token) {
        token = token.replaceFirst("Bearer ", "");

        User user = userRepo.findByLogin(jwtHelper.getUsernameFromToken(token)).get();

        List<DateTrainingEntryResponse> response = trainingRepo.findDates(user.getId());

        for (DateTrainingEntryResponse date: response) {
            List<TrainingEntryResponse> exercises = trainingRepo.findEntryResponse(
                    user.getId(),
                    date.getDate());
            date.setExercises(exercises);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> read(Date date, String token) {
        token = token.replaceFirst("Bearer ", "");

        User user = userRepo.findByLogin(jwtHelper.getUsernameFromToken(token)).get();

        List<TrainingEntryResponse> response = trainingRepo.findEntryResponse(user.getId(), date);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> delete(Date date, TrainingRequest dto, String token) {

        token = token.replaceFirst("Bearer ", "");

        User user = userRepo.findByLogin(jwtHelper.getUsernameFromToken(token)).get();

        Optional<Exercise> exercise = exerciseRepo.findById(dto.getExerciseId());
        String messageError = "Not found:";

        if (exercise.isEmpty()) {
            messageError += "\nExercise";
            ErrorException exception = new ErrorException(
                    new ErrorBody(HttpStatus.NOT_FOUND.value(), messageError));
            return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
        }

        TrainingPK pk = new TrainingPK();
        pk.setExerciseId(exercise.get());
        pk.setUserId(user);
        pk.setDate(date);

        Optional<Training> training = trainingRepo.findById(pk);

        if (training.isEmpty()) {
            return new DeleteResponse().returnNotFound();
        }
        trainingRepo.delete(Training.builder()
                .pk(pk)
                .isCompleted(training.get().isCompleted())
                .build());
        DeleteResponse deleteResponse = new DeleteResponse(HttpStatus.OK.value(), "Deleted");
        return new ResponseEntity<>(deleteResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> switchStatus(Date date, TrainingRequest dto, String token) {

        token = token.replaceFirst("Bearer ", "");

        User user = userRepo.findByLogin(jwtHelper.getUsernameFromToken(token)).get();

        Optional<Exercise> exercise = exerciseRepo.findById(dto.getExerciseId());
        String messageError = "Not found:";

        if (exercise.isEmpty()) {
            messageError += "\nExercise";
            ErrorException exception = new ErrorException(
                    new ErrorBody(HttpStatus.NOT_FOUND.value(), messageError));
            return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
        }

        TrainingPK pk = new TrainingPK();
        pk.setExerciseId(exercise.get());
        pk.setUserId(user);
        pk.setDate(date);

        Optional<Training> training = trainingRepo.findById(pk);

        if (training.isEmpty()) {
            return new DeleteResponse().returnNotFound();
        }

        training.get().setCompleted(!training.get().isCompleted());
        trainingRepo.save(training.get());

        TrainingCreatedResponse response = new TrainingCreatedResponse(
                pk.getDate(),
                pk.getExerciseId().getName(),
                training.get().isCompleted()
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
