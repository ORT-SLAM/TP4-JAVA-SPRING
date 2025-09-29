package sio.tp4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sio.tp4.entities.Secteur;

import java.util.List;

@Repository
public interface SectorRepository extends JpaRepository<Secteur, Integer> {
    @Override
    List<Secteur> findAll();
}
