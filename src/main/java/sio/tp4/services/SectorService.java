package sio.tp4.services;

import org.springframework.stereotype.Service;
import sio.tp4.entities.Employe;
import sio.tp4.entities.Secteur;
import sio.tp4.repositories.EmployeRepository;
import sio.tp4.repositories.SectorRepository;

import java.util.List;

@Service
public class SectorService {

    private SectorRepository sectorRepository;

    public SectorService(SectorRepository sectorRepository) {
        this.sectorRepository = sectorRepository;
    }

    public List<Secteur> getAllSector() {
        return sectorRepository.findAll();
    }
}