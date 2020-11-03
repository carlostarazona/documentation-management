package pe.edu.upc.documentationmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@Table(name = "engineer_report")
public class EngineerReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "review_date", nullable = false)
    private Date reviewDate;

    @Column(name = "schedule_Id")
    private Long scheduleId;

    private String description;

    @Column(name = "namemedical_equipment")
    private String namemedicalEquipment;

    @NotNull(message = "El pedido no puede estar vacio")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Schedule schedule;
}
