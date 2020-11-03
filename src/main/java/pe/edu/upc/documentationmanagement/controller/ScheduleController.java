package pe.edu.upc.documentationmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.edu.upc.documentationmanagement.entity.Schedule;
import pe.edu.upc.documentationmanagement.service.ScheduleService;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;


    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Schedule> fetchById(@PathVariable("id") Long id){
        try{
            Optional<Schedule> optionalSchedule = scheduleService.getSchedule(id);
            if(optionalSchedule.isPresent()){
                return new ResponseEntity<Schedule>(optionalSchedule.get(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping
    public ResponseEntity<List<Schedule>> findAll() {
        try {
            List<Schedule> managerrequests = scheduleService.findScheduleAll();
            if (managerrequests.isEmpty()) {
                return  ResponseEntity.noContent().build();
            } else{
                return  ResponseEntity.ok(managerrequests);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping
    public ResponseEntity<Schedule> save(@RequestBody Schedule schedule, BindingResult result) {
        log.info("Creating Invoice : {}", schedule);
        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        try {
            Schedule managerrequestDB = scheduleService.createSchedule(schedule);
            return ResponseEntity.status(HttpStatus.CREATED).body(managerrequestDB);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<?> actualizar(@PathVariable("id") Long id, @RequestBody Schedule schedule) {
        log.info("Updating manager request with id {}", id);

        schedule.setId(id);
        try {
            Schedule currentSchedule = scheduleService.updateSchedule(schedule);

            if (currentSchedule == null) {
                log.error("Unable to update. manager with id {} not found.", id);
                return  ResponseEntity.notFound().build();
            }
            else {
                return  ResponseEntity.ok(currentSchedule);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id") Long id) {

        try {
            scheduleService.deleteSchedule(id);
            return null;

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
