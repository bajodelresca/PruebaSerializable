/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializable;
import com.mycompany.javaio.*;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author carlosserrano
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "books")
public class Books implements java.io.Serializable {
    
    @XmlElement(name = "book", type=Libro.class)
    public List<Libro> books = new ArrayList<>();
    
    Books(){}

    /**
     * @return the books
     */
    public List<Libro> getBooks() {
        return books;
    }

    /**
     * @param books the books to set
     */
    public void setBooks(List<Libro> books) {
        this.books = books;
    }
    
     public void addBooks(Libro book) {
        this.books.add(book);
    }
}


