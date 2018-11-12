package com.example.luisflores.eva1_practica_restaurantes;

public class Restaurante {
    String sNombreResta;
    String sDescripcion;
    int iImagen;
    String sDireccion;
    String sPlaza;
    String sTelefono;

    public Restaurante(String sNombreResta, String sDescripcion, int iImagen, String sDireccion, String sPlaza, String sTelefono) {
        this.sNombreResta = sNombreResta;
        this.sDescripcion = sDescripcion;
        this.iImagen = iImagen;
        this.sDireccion = sDireccion;
        this.sPlaza = sPlaza;
        this.sTelefono = sTelefono;
    }
}
