package tn.esprit.piDev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.piDev.entities.Offer;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository <Offer,Long> {
    List<Offer> findByOfferTitleContainingIgnoreCase(String domainOfStudies);
    @Query("SELECT o.location, COUNT(o) FROM Offer o GROUP BY o.location")
    List<Object[]> countOffersByLocation();

    List<Offer> findOffersByLocation(String location);
}
