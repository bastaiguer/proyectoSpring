/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo03.dominio;

/**
 *
 * @author joshu
 */
public class Contaminante {
    private String cod_contaminante, desc_contaminante;
    
    public Contaminante(){
        
    }
    
    public Contaminante(String cod, String desc){
        this.cod_contaminante = cod;
        this.desc_contaminante = desc;
    }

    public String getCod_contaminante() {
        return cod_contaminante;
    }

    public String getDesc_contaminante() {
        return desc_contaminante;
    }

    public void setCod_contaminante(String cod_contaminante) {
        this.cod_contaminante = cod_contaminante;
    }

    public void setDesc_contaminante(String desc_contaminante) {
        this.desc_contaminante = desc_contaminante;
    }
    
    
    
}
