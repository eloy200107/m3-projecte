/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * Classe que gestiona la visualització de les peticions de préstec.
 */
public class dades_peticions {
  /**
     * Àrea de text on es mostra el contingut de l'arxiu de peticions de préstec.
     */   
 @FXML
private TextArea arxiu;   
    /**
     * Ruta de l'arxiu de peticions de préstec.
     */
private String path = "prestecs.txt";
    /**
     * Comprova si l'arxiu existeix.
     *
     * @param path Ruta de l'arxiu a comprovar.
     * @return Retorna `true` si l'arxiu existeix, `false` en cas contrari.
     */
    public static boolean fileExists(String path) {
        File file = new File(path);
        return file.exists();
    }
/**
     * Llegeix l'arxiu especificat per la ruta `path` i mostra el contingut per consola.
     *
     * @param path Ruta de l'arxiu a llegir.
     * @throws FileNotFoundException Es llençarà si l'arxiu no es pot trobar.
     */
    public static void readFile(String path) throws FileNotFoundException {
        File file = new File(path);
        if (file.exists()) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } else {
            System.out.println("No existeix l'arxiu");
        }
    }

   /**
     * Mètode que s'executa al inicialitzar la classe.
     * Si l'arxiu de peticions de préstec existeix, es mostra el seu contingut a l'àrea de text `arxiu`.
     */
@FXML
void initialize() {
    if (fileExists(path)) {
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                arxiu.appendText(line + "\n");
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    } else {
        System.out.println("No existeix l'arxiu");
    }
}

/**
     * Mètode que es crida al clicar el botó "Menu".
     * Canvia la vista a la pantalla principal del programa.
     *
     * @throws IOException Es llençarà si no es pot carregar la vista.
     */
    @FXML
    private void menu() throws IOException {
        App.setRoot("secondry1");
    }
}
