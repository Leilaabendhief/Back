package tn.esprit.piDev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.piDev.entities.FavOffers;
import tn.esprit.piDev.entities.Offer;

public interface FavOffersRepository extends JpaRepository<FavOffers,Long> {
}
