package ejemplo03.dominio;
// Generated 21-feb-2019 11:28:47 by Hibernate Tools 4.3.1



/**
 * Estaminantes generated by hbm2java
 */
public class Estaminantes  implements java.io.Serializable {


     private int idEstaminante;
     private Contaminantes contaminantes;
     private Estaciones estaciones;

    public Estaminantes() {
    }

    public Estaminantes(int idEstaminante, Contaminantes contaminantes, Estaciones estaciones) {
       this.idEstaminante = idEstaminante;
       this.contaminantes = contaminantes;
       this.estaciones = estaciones;
    }
   
    public int getIdEstaminante() {
        return this.idEstaminante;
    }
    
    public void setIdEstaminante(int idEstaminante) {
        this.idEstaminante = idEstaminante;
    }
    public Contaminantes getContaminantes() {
        return this.contaminantes;
    }
    
    public void setContaminantes(Contaminantes contaminantes) {
        this.contaminantes = contaminantes;
    }
    public Estaciones getEstaciones() {
        return this.estaciones;
    }
    
    public void setEstaciones(Estaciones estaciones) {
        this.estaciones = estaciones;
    }




}


