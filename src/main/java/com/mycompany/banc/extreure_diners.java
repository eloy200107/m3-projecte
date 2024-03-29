/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banc;

import static com.mycompany.banc.Banc.obtenerFechaActual;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author jjavi
 */
public class extreure_diners {

    /**
     *Boto Depositar per mostrar la quantitat a extreure
     */
    @FXML
   public Button Depositar;

    /**
     * Botó ingres per tornar al menu
     */
    @FXML
   public Button ingres;
    
    /**
     *Combobox quantitat 20 per aixi seleccionar el nº de bitllets de 20 que volguem
     */
    @FXML
   public ComboBox quantitat20;

    /**
     *comboBox quantitat 50 per seleccionar els bitllets de 50 que volguem
     */
    @FXML
   public ComboBox quantitat50;

    /**
     *comboBox seleccionem quantitat de bitllets de 100 que volguem
     */
    @FXML
   public ComboBox quantitat100;

    /**
     *TextField per aixi mostrar la quantitat que hem indicat per extreure
     */
    @FXML
      public TextField total;

    /**
     *TextField per mostrar el saldo que hi ha actualment
     */
    @FXML
      public TextField total1;

    /**
     *
     */
    @FXML
   public Button depositar;


double saldoActual;
  
    /**
     *Realitzarem els calculs pertinets per poder calcular la quantitat de diners a extreure
     * @param event
     */
    public void depositar(ActionEvent event) {
    boolean registroExitoso = false;
    boolean guardadoExitoso = Movimientos.guardarMovs();

    if (quantitat20.getValue() != null && quantitat50.getValue() != null && quantitat100.getValue() != null) {
        int iquantitat20 = Integer.parseInt(quantitat20.getValue().toString());
        int iquantitat50 = Integer.parseInt(quantitat50.getValue().toString());
        int iquantitat100 = Integer.parseInt(quantitat100.getValue().toString());

        double cantidadTotal = iquantitat20 * 20.0 + iquantitat50 * 50 + iquantitat100 * 100;
        saldoActual = cantidadTotal;

        total.setText("Enhorabuena, has ingresado: €" + saldoActual);

        // Restar los valores de los billetes al objeto Usuario
        App.banc.getUsuariActual().setBitllets_20(App.banc.getUsuariActual().getBitllets_20() - iquantitat20);
        App.banc.getUsuariActual().setBitllets_50(App.banc.getUsuariActual().getBitllets_50() - iquantitat50);
        App.banc.getUsuariActual().setBitllets_100(App.banc.getUsuariActual().getBitllets_100() - iquantitat100);

        double saldoCliente = App.banc.getUsuariActual().getSaldo();
        double saldoFinal = saldoCliente - saldoActual;
        App.banc.getUsuariActual().setSaldo(saldoFinal);
         String nomClient = App.banc.getUsuariActual().getNom_client();
        double saldoIngreso = saldoActual;
        String fecha = obtenerFechaActual();

        // Crear una instancia del movimiento de ingreso
        String tipoMovimiento = "extraccion";
        String nomBitllets = iquantitat20 + "x20€, " + iquantitat50 + "x50€, " + iquantitat100 + "x100€";
        double numBitllets20 = App.banc.getUsuariActual().getBitllets_20();
        double numBitllets50 = App.banc.getUsuariActual().getBitllets_50();
        double numBitllets100 = App.banc.getUsuariActual().getBitllets_100();
        Movimientos movimientoIngreso = new Movimientos(nomClient, tipoMovimiento, saldoIngreso, fecha, nomBitllets, numBitllets20, numBitllets50, numBitllets100);
        Movimientos.MOV.add(movimientoIngreso);

        // Llamar al método guardarMovs() y verificar el resultado
        registroExitoso = Movimientos.guardarMovs();
        if (registroExitoso) {
            System.out.println("El registro del movimiento de extraccion fue exitoso.");
        } else {
            System.out.println("Error al guardar el movimiento de ingreso.");
        }
    }

        // Resto del código...
    }


       

       

        

     


    /**
     *
     * @param event
     */
    public void saldo(ActionEvent event) {
         boolean registroExitoso = false;
    System.out.println(quantitat20.getValue());
    int iquantitat20 = Integer.parseInt(quantitat20.getValue().toString());
    int iquantitat50 = Integer.parseInt(quantitat50.getValue().toString());
    int iquantitat100 = Integer.parseInt(quantitat100.getValue().toString());
   

    double cantidadTotal = iquantitat20 * 20.0+ iquantitat50 * 50 + iquantitat100 * 100;
      saldoActual = cantidadTotal;
     double saldo=3500;
     double saldoT=saldo-saldoActual;

     total.setText("Enhoraba has extret: €" + saldoT);
     
     String nom_client = App.banc.getUsuariActual().getNom_client();

double saldocheque = saldoActual; // Saldo para la extracción
String data = obtenerFechaActual();

    }
   

       
    /**
     *indicarem les opcions per escollir els bitllets i configurarem per a que ens mostri les dades que volguem del nostre client
     * @param event
     */
    @FXML
    void initialize() {
        
       quantitat20.getItems().addAll("0","1","2","3","4","5","6","7","8","9","10");
        quantitat50.getItems().addAll("0","1","2","3","4","5","6","7","8","9","10");
         quantitat100.getItems().addAll("0","1","2","3","4","5","6","7","8","9","10");
         
         Usuario u = App.banc.getUsuariActual();
        u.getPassword();
        u.getUsername();
        total1.setText(String.valueOf(u.getSaldo()));
    }

   
    
    @FXML
    private void switchToingres() throws IOException {
        App.setRoot("secondry1");
    }
    

}

