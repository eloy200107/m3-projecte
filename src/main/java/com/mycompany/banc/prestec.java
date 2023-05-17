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




public class prestec {
   @FXML
   public Button Depositar;
    @FXML
   public Button ingres;
    
    @FXML
   public ComboBox quantitat20;
     @FXML
   public ComboBox quantitat50;
      @FXML
   public ComboBox quantitat100;
      @FXML
      public TextField total;

      @FXML
      public TextField total1;
      @FXML
    private TextField saldo;



double saldoActual;

     
    




 
/*
* Mètode per a dipositar l'import del préstec en el saldo del compte.
*
* @param event El ActionEvent que s'ha produït.
*/
     
    
public void depositar(ActionEvent event) {
    boolean registroExitoso = false;
    System.out.println(quantitat20.getValue());
    int iquantitat20 = Integer.parseInt(quantitat20.getValue().toString());
    int iquantitat50 = Integer.parseInt(quantitat50.getValue().toString());
    int iquantitat100 = Integer.parseInt(quantitat100.getValue().toString());
   

    double cantidadTotal = iquantitat20 * 20.0+ iquantitat50 * 50 + iquantitat100 * 100;
    saldoActual = cantidadTotal;

     double Saldo=saldoActual-cantidadTotal;

     total.setText("Enhoraba has demanat un prestec de: €" + saldoActual);
     double Saldo_client=App.banc.getUsuariActual().getSaldo();

     
     // Crear una instancia del movimiento de ingreso
        String nom_client = App.banc.getUsuariActual().getNom_client();
        String tipusMov = "Prestec";
        double Saldo2 = saldoActual;
        String data = obtenerFechaActual();

        Movimiento movimientotransferencia = new Movimiento(nom_client, tipusMov, saldoActual, data);

        // Agregar el movimiento de ingreso a la lista MOV
        Movimiento.MOV.add(movimientotransferencia);

        // Llamar al método guardarMovs() y verificar el resultado
        if (Movimiento.guardarMovs()) {
            registroExitoso = true;
        }
     else {
        // Manejar el caso en el que no se haya seleccionado ningún valor en el ComboBox
       
    }
     // Mostrar un mensaje de error o realizar alguna acción adecuada

    if (registroExitoso) {
        // El registro se realizó correctamente
        System.out.println("El registro se realizó correctamente");
    } else {
        // Hubo un error en el registro
        System.out.println("Error al realizar el registro");
    }

    
        
        // Crear una instancia del movimiento de ingreso
     nom_client = App.banc.getUsuariActual().getNom_client();
     tipusMov = "Prestec";
     saldoActual = saldoActual;
    data = obtenerFechaActual();

    Movimiento movimientoprestec = new Movimiento(nom_client, tipusMov, saldoActual, data);

    // Agregar el movimiento de ingreso a la lista MOV
    Movimiento.MOV.add(movimientoprestec);

    // Llamar al método guardarMovs() y verificar si el guardado fue exitoso
    boolean guardadoExitoso = Movimiento.guardarMovs();

    if (guardadoExitoso) {
        // Realizar acciones adicionales si el guardado fue exitoso, por ejemplo, mostrar un mensaje de éxito
        System.out.println("Los movimientos se han guardado correctamente en el archivo MOVIMENTS.csv");
    } else {
        // Realizar acciones adicionales si hubo un error en el guardado, por ejemplo, mostrar un mensaje de error
        System.out.println("Ha ocurrido un error al guardar los movimientos");
    }
    
    }
   




/*
* Inicialitza el formulari de dipòsit de préstecs.
*/

     @FXML
    void initialize() {
        
       quantitat20.getItems().addAll("0","1","2","3","4","5","6","7","8","9","10");
        quantitat50.getItems().addAll("0","1","2","3","4","5","6","7","8","9","10");
         quantitat100.getItems().addAll("0","1","2","3","4","5","6","7","8","9","10");
         

        
        
    }
    
    
/*
* Canvia a la forma secundària.
*
* @throws IOException Si es produeix un error de E/S.
*/
         @FXML
    private void switchToingres() throws IOException {
        App.setRoot("secondry1");
    }
    
/*
* Confirma el dipòsit del préstec i passa a la pàgina final.
*
* @throws IOException Si es produeix un error de E/S.
*/
     @FXML
    private void confirmar() throws IOException {
        App.setRoot("finalitzar");
    }
        
    }

   
    
   




   

       
    
    
    

