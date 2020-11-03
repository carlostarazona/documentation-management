package pe.edu.upc.documentationmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.edu.upc.documentationmanagement.entity.ManagerRequest;
import pe.edu.upc.documentationmanagement.service.ManagerRequestService;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/managerrequests")
public class ManagerRequestController {

    @Autowired
    private ManagerRequestService managerRequestService;


    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ManagerRequest> fetchById(@PathVariable("id") Long id){
        try{
            Optional<ManagerRequest> optionalManagerRequest = managerRequestService.getManagerRequest(id);
            if(optionalManagerRequest.isPresent()){
                return new ResponseEntity<ManagerRequest>(optionalManagerRequest.get(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping
    public ResponseEntity<List<ManagerRequest>> findAll() {
        try {
            List<ManagerRequest> managerrequests = managerRequestService.findManagerRequestAll();
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
    public ResponseEntity<ManagerRequest> save(@RequestBody ManagerRequest managerRequest, BindingResult result) {
        log.info("Creating Invoice : {}", managerRequest);
        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        try {
            ManagerRequest managerrequestDB = managerRequestService.createManagerRequest(managerRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(managerrequestDB);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<?> actualizar(@PathVariable("id") Long id, @RequestBody ManagerRequest managerRequest) {
        log.info("Updating manager request with id {}", id);

        managerRequest.setId(id);
        try {
            ManagerRequest currentManagerRequest = managerRequestService.updateManagerRequest(managerRequest);

            if (currentManagerRequest == null) {
                log.error("Unable to update. manager with id {} not found.", id);
                return  ResponseEntity.notFound().build();
            }
            else {
                return  ResponseEntity.ok(currentManagerRequest);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id") Long id) {

        try {
            managerRequestService.deleteManagerRequest(id);
            return null;

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
