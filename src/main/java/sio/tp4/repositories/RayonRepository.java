package sio.tp4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sio.tp4.entities.Rayon;
import sio.tp4.entities.Secteur;

import java.util.List;

@Repository
public interface RayonRepository extends JpaRepository<Rayon, Integer> {

    List<Rayon> findRayonsByNumSecteur(Secteur numSecteur);
}
