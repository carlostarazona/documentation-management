package pe.edu.upc.documentationmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.edu.upc.documentationmanagement.entity.FinalReport;
import pe.edu.upc.documentationmanagement.service.FinalReportService;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/finalreport")
public class FinalReportController {

    @Autowired
    private FinalReportService finalReportService;


    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FinalReport> fetchById(@PathVariable("id") Long id){
        try{
            Optional<FinalReport> optionalFinalReport = finalReportService.getFinalReport(id);
            if(optionalFinalReport.isPresent()){
                return new ResponseEntity<FinalReport>(optionalFinalReport.get(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping
    public ResponseEntity<List<FinalReport>> findAll() {
        try {
            List<FinalReport> managerrequests = finalReportService.findFinalReportAll();
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
    public ResponseEntity<FinalReport> save(@RequestBody FinalReport finalReport, BindingResult result) {
        log.info("Creating Invoice : {}", finalReport);
        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        try {
            FinalReport managerrequestDB = finalReportService.createFinalReport(finalReport);
            return ResponseEntity.status(HttpStatus.CREATED).body(managerrequestDB);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<?> actualizar(@PathVariable("id") Long id, @RequestBody FinalReport finalReport) {
        log.info("Updating manager request with id {}", id);

        finalReport.setId(id);
        try {
            FinalReport currentFinalReport = finalReportService.updateFinalReport(finalReport);

            if (currentFinalReport == null) {
                log.error("Unable to update. manager with id {} not found.", id);
                return  ResponseEntity.notFound().build();
            }
            else {
                return  ResponseEntity.ok(currentFinalReport);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id") Long id) {

        try {
            finalReportService.deleteFinalReport(id);
            return null;

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
