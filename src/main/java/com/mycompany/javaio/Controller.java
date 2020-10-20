/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javaio;

import static com.mycompany.javaio.Ejecutable2.BBDDFILE;
import static com.mycompany.javaio.Ejecutable2.myBooks;
import static com.mycompany.javaio.Ejecutable2.teclado;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.xml.bind.JAXBException;

/**
 *
 * @author espin
 */
public class Controller {
    static void loadBBDDXML() {
        System.out.println("Cargando base de datos XML");
        try {
            myBooks = JAXBManager.unmarshal(new File(BBDDFILE));
            System.out.println("Base de datos cargada");
        } catch (JAXBException e) {
            System.out.println("Error al marshal el archivo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Un error ocurrió: " + e.getMessage());
        }
    }
    
    static void listBooks() {
        System.out.println("-------- BOOKS --------");
        for (Libro b : myBooks.getBooks()) {
            System.out.println(b);
        }
        System.out.println("------------------------");
    }

    static void insertBook() {
        try {
            teclado.nextLine();
            System.out.print("Inserte el título: ");
            String title = teclado.nextLine();
            System.out.print("Inserte autor: ");
            String author = teclado.nextLine();
            System.out.print("Inserte editorial: ");
            String publisher = teclado.nextLine();
            System.out.print("Inserte isbn: ");
            String isbn = teclado.nextLine();
            Libro b = new Libro();
            b.setAuthor(author);
            b.setName(title);
            b.setPublisher(publisher);
            b.setIsbn(isbn);
            ArrayList<Libro> books = (ArrayList< Libro>) myBooks.getBooks();
            books.add(b);
            myBooks.setBooks(books);
        } catch (InputMismatchException e) {
            System.out.println("Introduzca valor correcto");
        } catch (NoSuchElementException e) {
            System.out.println("Error al leer teclado");
        } catch (IllegalStateException e) {
            System.out.println("Error en flujo de datos. Iniciando.");
            teclado = new Scanner(System.in);
        }

    }

    static void delBook() {
        try {
            teclado.nextLine();
            System.out.print("Inserte el isbn del libro a borrar: ");
            String isbn = teclado.nextLine();
            ArrayList<Libro> books = (ArrayList< Libro>) myBooks.getBooks();
            int index = -1, i = -1;
            for (Libro b : books) {
                i++;
                if (b.getIsbn().equals(isbn)) {
                    index = i;
                }
            }
            if (index == -1) {
                System.out.println("ISBN no encontrado");
            } else {
                books.remove(index);
                myBooks.setBooks(books);
            }
        } catch (InputMismatchException e) {
            System.out.println("Introduzca valor correcto");
        } catch (NoSuchElementException e) {
            System.out.println("Error al leer teclado");
        } catch (IllegalStateException e) {
            System.out.println("Error en flujo de datos. Iniciando.");
            teclado = new Scanner(System.in);
        }

    }
    

    static void saveBBDD() {
        try {
            JAXBManager.marshal(myBooks, new File(BBDDFILE));
        } catch (IOException e) {
            System.out.println("Error al guardar en archivo: " + e.getMessage());
        } catch (JAXBException e) {
            System.out.println("Error JAXB: " + e.getMessage());
        }
    }
}
