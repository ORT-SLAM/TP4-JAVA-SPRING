package sio.tp4.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.stereotype.Component;
import sio.tp4.entities.Employe;
import sio.tp4.entities.Rayon;
import sio.tp4.entities.Secteur;
import sio.tp4.entities.Travailler;
import sio.tp4.services.EmployeService;
import sio.tp4.services.RayonService;
import sio.tp4.services.SectorService;
import sio.tp4.services.TravaillerService;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class TP4Controller implements Initializable
{
    @FXML
    private TableColumn tcNomSecteur;
    @FXML
    private TableView<Rayon> tvRayons;
    @FXML
    private TableView tvEmployesRayon;
    @FXML
    private TableColumn tcNumeroEmployeAll;
    @FXML
    private TableView<Employe> tvEmployesAll;
    @FXML
    private TableColumn tcDateEmployeRayon;
    @FXML
    private TableColumn tcNumeroRayon;
    @FXML
    private TableColumn tcNumeroEmployeRayon;
    @FXML
    private TableColumn tcNomRayon;
    @FXML
    private TableView<Secteur> tvSecteurs;
    @FXML
    private TableColumn tcNomEmployeAll;
    @FXML
    private TableColumn tcNomEmployeRayon;
    @FXML
    private TableColumn tcHeureEmployeRayon;
    @FXML
    private TableColumn tcNumeroSecteur;
    @FXML
    private Button btnAjouter;
    @FXML
    private DatePicker dpDate;
    @FXML
    private TextField txtNbHeures;
    @FXML
    private TextField txtTotalRayon;
    @FXML
    private TextField txtTotalSecteur;

    // Utils
    EmployeService employeService;
    SectorService sectorService;
    RayonService rayonService;
    TravaillerService travaillerService;
    Alert alert;

    public TP4Controller(
            EmployeService employeService,
            SectorService sectorService,
            RayonService rayonService,
            TravaillerService travaillerService
    ) {
        this.employeService = employeService;
        this.sectorService = sectorService;
        this.rayonService = rayonService;
        this.travaillerService = travaillerService;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Choix incorrect");
        alert.setHeaderText(null);

        setColumnsValues();
        fillDefaultTableView();
    }

    private void setColumnsValues() {
        // TV EMPLOYER
        tcNumeroEmployeAll.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcNomEmployeAll.setCellValueFactory(new PropertyValueFactory<>("nomEmploye"));

        // TV SECTEUR
        tcNumeroSecteur.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcNomSecteur.setCellValueFactory(new PropertyValueFactory<>("nomSecteur"));

        // TV RAYON
        tcNumeroRayon.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcNomRayon.setCellValueFactory(new PropertyValueFactory<>("nomRayon"));

        // TV
        tcNumeroEmployeRayon.setCellValueFactory(new PropertyValueFactory<>("employeId"));
        tcNomEmployeRayon.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tcDateEmployeRayon.setCellValueFactory(new PropertyValueFactory<>("date"));
        tcHeureEmployeRayon.setCellValueFactory(new PropertyValueFactory<>("temps"));
    }

    private void fillDefaultTableView() {
        tvEmployesAll.setItems(FXCollections.observableArrayList(employeService.getAllEmployees()));
        tvSecteurs.setItems(FXCollections.observableArrayList(sectorService.getAllSector()));
    }

    @FXML
    public void tvSecteursClicked(Event event)
    {
        Secteur selectedSector = tvSecteurs.getSelectionModel().getSelectedItem();
        int sectorId = selectedSector.getId();
        tvRayons.setItems(FXCollections.observableArrayList(rayonService.getAllRayonsByNumSector(selectedSector)));
        txtTotalSecteur.setText(String.valueOf(travaillerService.getTotalSectorHours(sectorId)));
    }


    @FXML
    public void tvRayonsClicked(Event event)
    {
        Rayon selectedRayon = tvRayons.getSelectionModel().getSelectedItem();
        tvEmployesRayon.setItems(FXCollections.observableArrayList());

    }

    @FXML
    public void btnAjouterAction(ActionEvent actionEvent)
    {

    }
}