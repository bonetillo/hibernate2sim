package models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "numeroPaginas")
    private int numeroPaginas;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_escritor_id")
    private User userEscritor;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_lector_id")
    private User userLector;
    
    @OneToMany(mappedBy = "libroComentado", cascade = CascadeType.ALL)
    private List<Comentario> comentarios = new ArrayList<>();

    public Book() {
    }
    
    public Book(String titulo, int numeroPaginas, User escritor, User lector) {
    this.titulo = titulo;
    this.numeroPaginas = numeroPaginas;
    this.userEscritor = escritor;
    this.userLector = lector;
}
    

    public Book(String titulo, int numeroPaginas) {
        this.titulo = titulo;
        this.numeroPaginas = numeroPaginas;
    }
    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", titulo=" + titulo + ", numeroPaginas=" + numeroPaginas + ", userEscritor=" + userEscritor + ", userLector=" + userLector + ", comentarios=" + comentarios + '}';
    }

    public User getUserEscritor() {
        return userEscritor;
    }

    public void setUserEscritor(User userEscritor) {
        this.userEscritor = userEscritor;
    }

    public User getUserLector() {
        return userLector;
    }

    public void setUserLector(User userLector) {
        this.userLector = userLector;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

}
