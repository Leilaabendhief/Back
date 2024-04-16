package tn.esprit.piDev.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.piDev.entities.enumerations.EmployementType;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Offer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long idOffer ;

    String offerTitle ;

    @Temporal(TemporalType.DATE)
    Date postingDate ;

    @Temporal(TemporalType.DATE)
    Date closingDate ;

    String location ;

    @Enumerated(EnumType.STRING)
    EmployementType employementType ;

    String offerStatus ;
    String offerDescription ;


}
