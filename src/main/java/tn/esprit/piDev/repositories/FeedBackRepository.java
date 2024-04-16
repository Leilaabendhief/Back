package tn.esprit.piDev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.piDev.entities.FeedBack;

@Repository
public interface FeedBackRepository  extends JpaRepository <FeedBack,Long> {
}
