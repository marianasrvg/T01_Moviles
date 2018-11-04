package com.example.mari_.sesion5.beans;

import android.util.Log;

public class Alumno {
    public String nombre;
    public String telefono;
    public String escolaridad;
    public Boolean genero; // 0 masculino 1 femenino
    public String libroFavorito;
    public Boolean practicaDeporte;

    public Alumno(String nombre, String telefono, String escolaridad, Boolean genero, String libroFavorito, Boolean practicaDeporte) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.escolaridad = escolaridad;
        Log.e("genero", genero.toString());
        this.genero = genero;
        this.libroFavorito = libroFavorito;
        this.practicaDeporte = practicaDeporte;
    }

    @Override
    public String toString() {
        String sGenero = genero==true?"femenino":"masculino";
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", escolaridad='" + escolaridad + '\'' +
                ", genero=" + sGenero +
                ", libroFavorito='" + libroFavorito + '\'' +
                ", practicaDeporte=" + practicaDeporte +
                '}';
    }
}
