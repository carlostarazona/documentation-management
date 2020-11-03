package pe.edu.upc.documentationmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.edu.upc.documentationmanagement.entity.EngineerReport;
import pe.edu.upc.documentationmanagement.service.EngineerReportService;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/engineerreport")
public class EngineerReportController {

    @Autowired
    private EngineerReportService engineerReportService;


    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EngineerReport> fetchById(@PathVariable("id") Long id){
        try{
            Optional<EngineerReport> optionalEngineerReport = engineerReportService.getEngineerReport(id);
            if(optionalEngineerReport.isPresent()){
                return new ResponseEntity<EngineerReport>(optionalEngineerReport.get(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping
    public ResponseEntity<List<EngineerReport>> findAll() {
        try {
            List<EngineerReport> managerrequests = engineerReportService.findEngineerReportAll();
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
    public ResponseEntity<EngineerReport> save(@RequestBody EngineerReport engineerReport, BindingResult result) {
        log.info("Creating Invoice : {}", engineerReport);
        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        try {
            EngineerReport managerrequestDB = engineerReportService.createEngineerReport(engineerReport);
            return ResponseEntity.status(HttpStatus.CREATED).body(managerrequestDB);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<?> actualizar(@PathVariable("id") Long id, @RequestBody EngineerReport engineerReport) {
        log.info("Updating manager request with id {}", id);

        engineerReport.setId(id);
        try {
            EngineerReport currentEngineerReport = engineerReportService.updateEngineerReport(engineerReport);

            if (currentEngineerReport == null) {
                log.error("Unable to update. manager with id {} not found.", id);
                return  ResponseEntity.notFound().build();
            }
            else {
                return  ResponseEntity.ok(currentEngineerReport);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id") Long id) {

        try {
            engineerReportService.deleteEngineerReport(id);
            return null;

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
