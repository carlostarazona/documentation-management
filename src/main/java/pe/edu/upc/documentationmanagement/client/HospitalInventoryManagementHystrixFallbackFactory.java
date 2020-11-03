package pe.edu.upc.documentationmanagement.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import pe.edu.upc.documentationmanagement.model.MedicalEquipment;


@Component
public class HospitalInventoryManagementHystrixFallbackFactory implements MedicalEquipmentClient{
    @Override
    public ResponseEntity<MedicalEquipment> getMedicalEquipment(long id) {
        MedicalEquipment medicalEquipment = MedicalEquipment.builder()
                .nameUser("none")
                .nameHospital("none")
                .stateDescription("none")
                .brand("none").build();
        return ResponseEntity.ok(medicalEquipment);
    }

}