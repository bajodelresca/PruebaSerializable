/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javaio;

import static com.mycompany.javaio.Controller.delBook;
import static com.mycompany.javaio.Controller.insertBook;
import static com.mycompany.javaio.Controller.listBooks;
import static com.mycompany.javaio.Controller.loadBBDDXML;
import static com.mycompany.javaio.Controller.saveBBDD;
import java.io.File;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.xml.bind.JAXBException;

/**
 *
 * /**
 *
 * @author espin
 */
public class Ejecutable2 {

    /**
     * @param args the command line arguments
     */
    static final String BBDDFILE = "bbdd.xml";
    static Books myBooks = new Books();
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO code application logic here
        int option = 0;
        loadBBDDXML();
        do {
            printMenu();
            try {
                option = teclado.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Introduzca un número como opción");
                option = 0;
            } catch (NoSuchElementException e) {
                System.out.println("Error al leer teclado");
                option = 0;
            } catch (IllegalStateException e) {
                System.out.println("Error en flujo de datos. Iniciando.");
                teclado = new Scanner(System.in);
                option = 0;
            }
            doTasks(option);
        } while (option != 5);

    }

    

    static void printMenu() {
        System.out.println("--------Menu-------");
        System.out.println("1. Para listar");
        System.out.println("2. Para insertar libro");
        System.out.println("3. Para borrar un libro");
        System.out.println("4. Para guardar la BBDD");
        System.out.println("5. Para salir");
        System.out.print("Elija una opción: ");
    }

    static void doTasks(int option) {
        switch (option) {
            case 0:
                break;
            case 1:
                listBooks();
                break;
            case 2:
                insertBook();
                break;
            case 3:
                delBook();
                break;
            case 4:
                saveBBDD();
                break;
            case 5:
                System.out.println("Saliendo de la aplicación");
                System.out.println("Guardar la base de datos antes de "
                        + "salir: 1) SI , cualquier otra tecla) No");
                try {
                    option = teclado.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Introduzca valor correcto");
                    option = 5;
                }
                if (option == 1) {
                    saveBBDD();
                    option = 5;
                }
                break;
            default:
                System.out.println("Elija una opción válida");
        }
    }

}
