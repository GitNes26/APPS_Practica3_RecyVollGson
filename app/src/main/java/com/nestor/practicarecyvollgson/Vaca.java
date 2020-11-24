package com.nestor.practicarecyvollgson;

public class Vaca {
    private int foto;
    private String titulo;
    private String texto;

    public Vaca(int foto, String titulo, String texto) {
        this.foto = foto;
        this.titulo = titulo;
        this.texto = texto;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
