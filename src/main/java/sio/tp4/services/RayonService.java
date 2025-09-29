package sio.tp4.services;

import org.springframework.stereotype.Service;
import sio.tp4.entities.Rayon;
import sio.tp4.entities.Secteur;
import sio.tp4.repositories.RayonRepository;
import sio.tp4.repositories.SectorRepository;

import java.util.List;

@Service
public class RayonService {

    private RayonRepository rayonRepository;

    public RayonService(RayonRepository rayonRepository) {
        this.rayonRepository = rayonRepository;
    }

    public List<Rayon> getAllRayonsByNumSector(Secteur sector) {
        return rayonRepository.findRayonsByNumSecteur(sector);
    }
}