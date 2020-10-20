/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializable;

import com.mycompany.javaio.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "libro")

public class Libro implements java.io.Serializable {

    private String Name;
    private String Author;
    private String isbn;
    private String Publisher;

    public Libro() {
    }

    public Libro(String Name, String Author, String isbn, String Publisher) {
        this.Name = Name;
        this.Author = Author;
        this.isbn = isbn;
        this.Publisher = Publisher;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String Publisher) {
        this.Publisher = Publisher;
    }

    @Override
    public String toString() {
        return "Libro{" + "Name=" + Name + ", Author=" + Author + ", isbn=" + isbn + ", Publisher=" + Publisher + '}';
    }

}
