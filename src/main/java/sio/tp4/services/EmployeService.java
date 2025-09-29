package sio.tp4.services;

import org.springframework.stereotype.Service;
import sio.tp4.entities.Employe;
import sio.tp4.repositories.EmployeRepository;

import java.util.List;

@Service
public class EmployeService {

    private EmployeRepository employeRepository;

    public EmployeService(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    public List<Employe> getALlEmployees() {
        return employeRepository.findAll();
    }
}
