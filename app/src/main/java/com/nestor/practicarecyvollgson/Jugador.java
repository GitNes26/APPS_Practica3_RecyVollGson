package com.nestor.practicarecyvollgson;

public class Jugador {
    private int foto;
    private String  id;
    private String nombre;
    private String numero;
    private String creado;
//    private String modificado;


    public Jugador(int foto, String id, String nombre, String numero, String creado) {
        this.foto = foto;
        this.id = id;
        this.nombre = nombre;
        this.numero = numero;
        this.creado = creado;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCreado() {
        return creado;
    }

    public void setCreado(String creado) {
        this.creado = creado;
    }

//    public String getModificado() {
//        return modificado;
//    }
//
//    public void setModificado(String modificado) {
//        this.modificado = modificado;
//    }
}
