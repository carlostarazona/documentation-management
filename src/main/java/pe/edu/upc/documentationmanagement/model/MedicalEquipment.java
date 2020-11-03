package pe.edu.upc.documentationmanagement.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MedicalEquipment {

    private Long Id;
    private String nameUser;
    private String nameHospital;
    private String nameArea;
    private String stateDescription;
    private String brand;
    private String name;
    private User user;

}
