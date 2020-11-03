package pe.edu.upc.documentationmanagement.entity;

import lombok.Data;
import pe.edu.upc.documentationmanagement.model.MedicalEquipment;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "manage_request")
public class ManagerRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer priority;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "medicalequipment_Id")
    private Long medicalequipmentId;

    private String description;

    @Column(name = "namemedical_equipment")
    private String namemedicalEquipment;

    @Transient
    private MedicalEquipment medicalEquipment;
}
