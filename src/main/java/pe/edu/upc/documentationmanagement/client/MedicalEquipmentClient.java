package pe.edu.upc.documentationmanagement.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.edu.upc.documentationmanagement.model.MedicalEquipment;


@FeignClient(name = "Hospital-Inventory-Management", fallback = HospitalInventoryManagementHystrixFallbackFactory.class)

public interface MedicalEquipmentClient {

    @GetMapping(value = "/medicalequipments/{id}")
    public ResponseEntity<MedicalEquipment> getMedicalEquipment(@PathVariable("id") long id);
}