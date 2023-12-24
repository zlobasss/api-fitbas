package com.zlobasss.kurs.serviceInterface;

import com.zlobasss.kurs.dto.FoodListRequest;
import com.zlobasss.kurs.dto.TrainingRequest;
import com.zlobasss.kurs.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface ITrainingService {
    ResponseEntity<?> add(TrainingRequest dto, Date date, String token);
    ResponseEntity<?> readAll(String token);
    ResponseEntity<?> read(Date date, String token);
    ResponseEntity<?> delete(Date date, TrainingRequest dto, String token);
    ResponseEntity<?> switchStatus(Date date, TrainingRequest dto, String token);
}
