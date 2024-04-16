package tn.esprit.piDev.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.piDev.entities.enumerations.FeedBackType;
import tn.esprit.piDev.entities.enumerations.Priority;

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
public class FeedBack implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long idFeedBack ;

    @Temporal(TemporalType.DATE)
    Date submitedDate ;

    String feedBackContent ;
    Long rating;

    @Enumerated(EnumType.STRING)
    FeedBackType feedBackType ;

    @Enumerated(EnumType.STRING)
    Priority priority ;


}
