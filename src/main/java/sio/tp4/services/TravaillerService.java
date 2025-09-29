package sio.tp4.services;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import sio.tp4.entities.Secteur;
import sio.tp4.repositories.SectorRepository;
import sio.tp4.repositories.TravaillerRepository;

import java.util.List;

@Service
public class TravaillerService {

    private TravaillerRepository travaillerRepository;

    public TravaillerService(TravaillerRepository travaillerRepository) {
        this.travaillerRepository = travaillerRepository;
    }

    public int getTotalSectorHours (int sectorId) {
        return travaillerRepository.totalSectorHours(sectorId);
    }
}