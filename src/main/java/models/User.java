package models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "userName")
    private String userName;

    @Column(name = "contrasena")
    private String contrasena;

    @Column(name = "mail")
    private String mail;

    private Calendar tiempolog;

    public User(String nombre, String userName, String contrasena, String mail, List<Book> librosEscritos) {
        this.nombre = nombre;
        this.userName = userName;
        this.contrasena = contrasena;
        this.mail = mail;
        this.librosEscritos = librosEscritos;
    }

    public User(String nombre, String userName, String contrasena, String mail, List<Book> librosEscritos, List<Book> librosLeidos) {
        this.nombre = nombre;
        this.userName = userName;
        this.contrasena = contrasena;
        this.mail = mail;
        this.librosEscritos = librosEscritos;
        this.librosLeidos = librosLeidos;
    }

    @OneToMany(mappedBy = "userEscritor", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Book> librosEscritos = new ArrayList<>();


    @OneToMany(mappedBy = "userLector", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Book> librosLeidos = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Comentario> listaDeComentarios= new ArrayList<>();



    public User() {
    }

    public List<Comentario> getListaDeComentarios() {
        return listaDeComentarios;
    }

    public void setListaDeComentarios(List<Comentario> listaDeComentarios) {
        this.listaDeComentarios = listaDeComentarios;
    }

    public User(String nombre, String userName, String contrasena, String mail) {
        this.nombre = nombre;
        this.userName = userName;
        this.contrasena = contrasena;
        this.mail = mail;
    }

   
   

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nombre=" + nombre + ", userName=" + userName + ", contrasena=" + contrasena + ", mail=" + mail + ", librosEscritos=" + librosEscritos + ", librosLeidos=" + librosLeidos + '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Book> getLibrosEscritos() {
        return librosEscritos;
    }

    public void setLibrosEscritos(List<Book> librosEscritos) {
        this.librosEscritos = librosEscritos;
    }

    public List<Book> getLibrosLeidos() {
        return librosLeidos;
    }

    public void setLibrosLeidos(List<Book> librosLeidos) {
        this.librosLeidos = librosLeidos;
    }

    public Calendar getTiempolog() {
        return tiempolog;
    }

    public void setTiempolog(Calendar tiempolog) {
        this.tiempolog = tiempolog;
    }
}
