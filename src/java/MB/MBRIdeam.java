/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;

import Entidad.Capamap;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/* @author giiee */
@ManagedBean
@ViewScoped
public class MBRIdeam implements Serializable {

    private String capaSelecionada;
    private String capa;

    private List<Capamap> capasVientoMes;
    private List<Capamap> capasVientoAnio;
    private List<Capamap> capasBiomasaMes;
    
    public MBRIdeam() {
    }

    @PostConstruct
    public void iniciar() {
//Viento
        this.capasVientoMes = new ArrayList<Capamap>();
        Capamap capa1v = new Capamap("Enero", "MapWind:January");
        Capamap capa2v = new Capamap("Febrero", "MapWind:February");
        Capamap capa3v = new Capamap("Marzo", "MapWind:March");
        Capamap capa4v = new Capamap("Abril", "MapWind:April");
        Capamap capa5v = new Capamap("Mayo", "MapWind:May");
        Capamap capa6v = new Capamap("Junio", "MapWind:June");
        Capamap capa7v = new Capamap("Julio", "MapWind:July");
        Capamap capa8v = new Capamap("Agosto", "MapWind:August");
        Capamap capa9v = new Capamap("septiembre", "MapWind:September");
        Capamap capa10v = new Capamap("Octubre", "MapWind:October");
        Capamap capa11v = new Capamap("Noviembre", "MapWind:November");
        Capamap capa12v = new Capamap("Diciembre", "MapWind:December");
        this.capasVientoMes.add(capa1v);
        this.capasVientoMes.add(capa2v);
        this.capasVientoMes.add(capa3v);
        this.capasVientoMes.add(capa4v);
        this.capasVientoMes.add(capa5v);
        this.capasVientoMes.add(capa6v);
        this.capasVientoMes.add(capa7v);
        this.capasVientoMes.add(capa8v);
        this.capasVientoMes.add(capa9v);
        this.capasVientoMes.add(capa10v);
        this.capasVientoMes.add(capa11v);
        this.capasVientoMes.add(capa12v);
        
    }
    
    public List<Capamap> getCapasBiomasaMes() {
        return capasBiomasaMes;
    }

    public void setCapasBiomasaMes(List<Capamap> capasBiomasaMes) {
        this.capasBiomasaMes = capasBiomasaMes;
    }

    public List<Capamap> getCapasVientoMes() {
        return capasVientoMes;
    }

    public void setCapasVientoMes(List<Capamap> capasVientoMes) {
        this.capasVientoMes = capasVientoMes;
    }

    public List<Capamap> getCapasVientoAnio() {
        return capasVientoAnio;
    }

    public void setCapasVientoAnio(List<Capamap> capasVientoAnio) {
        this.capasVientoAnio = capasVientoAnio;
    }

    

}
