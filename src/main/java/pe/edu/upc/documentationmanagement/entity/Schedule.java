package pe.edu.upc.documentationmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import pe.edu.upc.documentationmanagement.model.MedicalEquipment;
import pe.edu.upc.documentationmanagement.model.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "agreed_date", nullable = false)
    private Date agreedDate;

    @Column(name = "arrival_date", nullable = false)
    private Date arrivalDate;

    @Column(name = "user_Id")
    private Long userId;

    @Column(name = "managerrequest_Id")
    private Long managerrequestId;

    @Column(name = "description_order")
    private String descriptionOrder;

    @Column(name = "namemedical_equipment")
    private String namemedicalEquipment;

    @Column(name = "hospital")
    private String hospital;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @NotNull(message = "El pedido no puede estar vacio")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_request")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private ManagerRequest managerRequest;

    @Transient
    private User user;

    @PrePersist
    public void prePersist() {
        this.createAt = new Date();
    }


}
