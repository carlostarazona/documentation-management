package pe.edu.upc.documentationmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Data
@Table(name = "final_report")
public class FinalReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "report_date", nullable = false)
    private Date reportDate;

    private String description;

    @Column(name = "engineerreport_Id")
    private Long engineerreportId;

    @NotNull(message = "El pedido no puede estar vacio")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "engineer_report")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private EngineerReport engineerReport;
}
