package tn.esprit.piDev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.piDev.entities.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User , Long> {

}
