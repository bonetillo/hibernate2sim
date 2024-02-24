
package models;

import jakarta.persistence.*;

@Entity
@Table(name = "comentarios")
public class Comentario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "valoracion")
    private int valoracion;
    
    @Column(name = "comentario")
    private String comentario;
    @ManyToOne(cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    @JoinColumn(name = "book_id")
    private Book libroComentado;

    @ManyToOne(cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private User user;

    public Comentario() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Comentario{" + "id=" + id + ", valoracion=" + valoracion + ", comentario=" + comentario + ", libroComentado=" + libroComentado + '}';
    }

    public Book getLibroComentado() {
        return libroComentado;
    }

    public void setLibroComentado(Book libroComentado) {
        this.libroComentado = libroComentado;
    }
}
