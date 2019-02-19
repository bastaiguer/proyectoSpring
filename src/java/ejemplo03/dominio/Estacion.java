/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo03.dominio;

import java.util.ArrayList;

/**
 *
 * @author joshu
 */
public class Estacion {
    private String codigo, nombre, zona, direccion, cod_provincia, nom_provincia, cod_municipio, desc_municipio, latitud, longitud, altitud;
    private ArrayList<Contaminante> contaminantes;
    
    public Estacion(){
        
    }
    
    public Estacion(String codigo, String nombre, String zona, String direccion, String cod_p, String nom_p, String cod_m, String desc_m, String latitud, String longitud, String altitud, ArrayList<Contaminante> cont){
        this.codigo = codigo;
        this.nombre = nombre;
        this.zona = zona;
        this.direccion = direccion;
        this.cod_provincia = cod_p;
        this.nom_provincia = nom_p;
        this.cod_municipio = cod_m;
        this.desc_municipio = desc_m;
        this.latitud = latitud;
        this.longitud = longitud;
        this.altitud = altitud;
        this.contaminantes = cont;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getZona() {
        return zona;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCod_provincia() {
        return cod_provincia;
    }

    public String getNom_provincia() {
        return nom_provincia;
    }

    public String getCod_municipio() {
        return cod_municipio;
    }

    public String getDesc_municipio() {
        return desc_municipio;
    }

    public String getLatitud() {
        return latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public String getAltitud() {
        return altitud;
    }

    public ArrayList<Contaminante> getContaminantes() {
        return contaminantes;
    }
    
    
    
}
