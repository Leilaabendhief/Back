package tn.esprit.piDev.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.piDev.entities.enumerations.Role;
import tn.esprit.piDev.entities.enumerations.SectorOfActivity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long idUser ;

    String firstName ;
    String lastName ;
    String Email ;
    String password ;

    @Temporal(TemporalType.DATE)
    Date BirthDate ;

    @Temporal(TemporalType.DATE)
    Date inscriptionDate ;

    String address ;

    @Enumerated(EnumType.STRING)
    Role role ;

    String immatriculationNumber ;

    @Enumerated(EnumType.STRING)
    SectorOfActivity sectorOfActivity ;

    String levelOfStudies ;
    String domainOfStudies ;

  /*  @OneToMany(cascade = CascadeType.ALL, mappedBy="userStand")
    private Set<Stand> stands;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="userFeedBack")
    private Set<FeedBack> feedBacks;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="userRequest")
    private Set<Request> requests;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="userBlog")
    private Set<Blog> blogs;

    @ManyToMany(mappedBy="usersOffer", cascade = CascadeType.ALL)
    private Set<Offer> offers;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Application> applications;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="userMessaging")
    private Set<Message> messages;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="userAuction")
    private Set<Auctions> auctions; */
}
