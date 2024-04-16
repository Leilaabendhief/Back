package tn.esprit.piDev.entities;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import tn.esprit.piDev.entities.enumerations.EmployementType;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExcelData {
    private Date closing_date ;
    @Enumerated(EnumType.STRING)
    private EmployementType employment_type ;
    private String location ;
    private String offer_description ;
    private String offer_status ;
    private String offer_title ;
    private Date posting_date ;
}
