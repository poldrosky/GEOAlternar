/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;

import DAO.MapsFacade;
import Entidad.Capamap;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/* @author giiee */
@ManagedBean
@ViewScoped
public class MBRMap implements Serializable {

    private String capaSelecionada;
    private String capa;

    private List<Capamap> capasVientoMes;
    private List<Capamap> capasVientoAnio;
    private List<Capamap> capasBiomasaMes;
    private List<Capamap> capasBiomasaAnio;
    private List<Capamap> capasSolarMes;
    private List<Capamap> capasSolarAnio;

    private String latitude, longitude;
    private int typeenergy;//1 w,2 b,3 s
    private String typetime;//month-year

    @EJB
    MapsFacade daoMap;

    private SelectOneMenu selectCapa;
    private SelectOneMenu selectMesCapa;
    private  String url;

    public MBRMap() {
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
        Capamap capa9v = new Capamap("sebtiembre", "MapWind:September");
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
        //Viento Anio
        this.capasVientoAnio = new ArrayList<Capamap>();
        Capamap capa2000v = new Capamap("2000", "MapWind:2000");
        Capamap capa2001v = new Capamap("2001", "MapWind:2001");
        Capamap capa2002v = new Capamap("2002", "MapWind:2002");
        Capamap capa2003v = new Capamap("2003", "MapWind:2003");
        Capamap capa2004v = new Capamap("2004", "MapWind:2004");
        Capamap capa2005v = new Capamap("2005", "MapWind:2005");
        Capamap capa2006v = new Capamap("2006", "MapWind:2006");
        Capamap capa2007v = new Capamap("2007", "MapWind:2007");
        Capamap capa2008v = new Capamap("2008", "MapWind:2008");
        Capamap capa2009v = new Capamap("2009", "MapWind:2009");
        Capamap capa2010v = new Capamap("2010", "MapWind:2010");
        Capamap capa2011v = new Capamap("2011", "MapWind:2011");
        Capamap capa2012v = new Capamap("2012", "MapWind:2012");
        Capamap capa2013v = new Capamap("2013", "MapWind:2013");
        Capamap capa2014v = new Capamap("2014", "MapWind:2014");
        this.capasVientoAnio.add(capa2000v);
        this.capasVientoAnio.add(capa2001v);
        this.capasVientoAnio.add(capa2002v);
        this.capasVientoAnio.add(capa2003v);
        this.capasVientoAnio.add(capa2004v);
        this.capasVientoAnio.add(capa2005v);
        this.capasVientoAnio.add(capa2006v);
        this.capasVientoAnio.add(capa2007v);
        this.capasVientoAnio.add(capa2008v);
        this.capasVientoAnio.add(capa2009v);
        this.capasVientoAnio.add(capa2010v);
        this.capasVientoAnio.add(capa2011v);
        this.capasVientoAnio.add(capa2012v);
        this.capasVientoAnio.add(capa2013v);
        this.capasVientoAnio.add(capa2014v);
//Biomasa
        this.capasBiomasaMes = new ArrayList<Capamap>();
        Capamap capa1 = new Capamap("Enero", "MapBiomass:January");
        Capamap capa2 = new Capamap("Febrero", "MapBiomass:February");
        Capamap capa3 = new Capamap("Marzo", "MapBiomass:March");
        Capamap capa4 = new Capamap("Abril", "MapBiomass:April");
        Capamap capa5 = new Capamap("Mayo", "MapBiomass:May");
        Capamap capa6 = new Capamap("Junio", "MapBiomass:June");
        Capamap capa7 = new Capamap("Julio", "MapBiomass:July");
        Capamap capa8 = new Capamap("Agosto", "MapBiomass:August");
        Capamap capa9 = new Capamap("sebtiembre", "MapBiomass:September");
        Capamap capa10 = new Capamap("Octubre", "MapBiomass:October");
        Capamap capa11 = new Capamap("Noviembre", "MapBiomass:November");
        Capamap capa12 = new Capamap("Diciembre", "MapBiomass:December");
        this.capasBiomasaMes.add(capa1);
        this.capasBiomasaMes.add(capa2);
        this.capasBiomasaMes.add(capa3);
        this.capasBiomasaMes.add(capa4);
        this.capasBiomasaMes.add(capa5);
        this.capasBiomasaMes.add(capa6);
        this.capasBiomasaMes.add(capa7);
        this.capasBiomasaMes.add(capa8);
        this.capasBiomasaMes.add(capa9);
        this.capasBiomasaMes.add(capa10);
        this.capasBiomasaMes.add(capa11);
        this.capasBiomasaMes.add(capa12);
        //Biomasa Anio
        this.capasBiomasaAnio = new ArrayList<Capamap>();
        Capamap capa2000 = new Capamap("2000", "MapBiomass:2000");
        Capamap capa2001 = new Capamap("2001", "MapBiomass:2001");
        Capamap capa2002 = new Capamap("2002", "MapBiomass:2002");
        Capamap capa2003 = new Capamap("2003", "MapBiomass:2003");
        Capamap capa2004 = new Capamap("2004", "MapBiomass:2004");
        Capamap capa2005 = new Capamap("2005", "MapBiomass:2005");
        Capamap capa2006 = new Capamap("2006", "MapBiomass:2006");
        Capamap capa2007 = new Capamap("2007", "MapBiomass:2007");
        Capamap capa2008 = new Capamap("2008", "MapBiomass:2008");
        Capamap capa2009 = new Capamap("2009", "MapBiomass:2009");
        Capamap capa2010 = new Capamap("2010", "MapBiomass:2010");
        Capamap capa2011 = new Capamap("2011", "MapBiomass:2011");
        Capamap capa2012 = new Capamap("2012", "MapBiomass:2012");
        Capamap capa2013 = new Capamap("2013", "MapBiomass:2013");
        Capamap capa2014 = new Capamap("2014", "MapBiomass:2014");
        this.capasBiomasaAnio.add(capa2000);
        this.capasBiomasaAnio.add(capa2001);
        this.capasBiomasaAnio.add(capa2002);
        this.capasBiomasaAnio.add(capa2003);
        this.capasBiomasaAnio.add(capa2004);
        this.capasBiomasaAnio.add(capa2005);
        this.capasBiomasaAnio.add(capa2006);
        this.capasBiomasaAnio.add(capa2007);
        this.capasBiomasaAnio.add(capa2008);
        this.capasBiomasaAnio.add(capa2009);
        this.capasBiomasaAnio.add(capa2010);
        this.capasBiomasaAnio.add(capa2011);
        this.capasBiomasaAnio.add(capa2012);
        this.capasBiomasaAnio.add(capa2013);
        this.capasBiomasaAnio.add(capa2014);
        //////////////////////////////////////////

    }
    private double valuelat, valuelon;
    private int lat, lon;
    private double m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12, mlat, mlon;
    private  String valorbd;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    

    public void consultarDatosCoordenada() {
        Object[] valor, valor2;
        valuelat = Double.parseDouble(this.latitude);//CONVERTIR CORDENADAS A ENTEROS PARA CONSULTAR BD
        lat = (int) (valuelat - (valuelat % 900));
        valuelon = Double.parseDouble(this.longitude);
        lon = (int) (valuelon - (valuelon % 900));
        String[] mesfuente = capa.split(":");//DEFINIR EL MAPA ACTUAL Y LA FUENTE DE ENERGIA
        
        if (mesfuente[0].equals("MapBiomass")) {
            valor= daoMap.getByCoordenate(lon, lat, mesfuente[1], 2);
            valorbd="Biomasa : \n"+valor[3].toString()+" Mg/Ha";
            //////////consultar valor por mes
            valor2 = daoMap.getHistory(lon, lat, mesfuente[1], 2);
            //datos resultantes de la consulta lat,lon,enero,febrero,.....,diciembre
            mlat = Double.parseDouble(valor2[0].toString());
            mlon = Double.parseDouble(valor2[1].toString());
            m1 = Double.parseDouble(valor2[2].toString());
            m2 = Double.parseDouble(valor2[3].toString());
            m3 = Double.parseDouble(valor2[4].toString());
            m4 = Double.parseDouble(valor2[5].toString());
            m5 = Double.parseDouble(valor2[6].toString());
            m6 = Double.parseDouble(valor2[7].toString());
            m7 = Double.parseDouble(valor2[8].toString());
            m8 = Double.parseDouble(valor2[9].toString());
            m9 = Double.parseDouble(valor2[10].toString());
            m10 = Double.parseDouble(valor2[11].toString());
            m11 = Double.parseDouble(valor2[12].toString());
            m12 = Double.parseDouble(valor2[13].toString());
            
            
            
            
        }



    }

    public List<Capamap> getCapasBiomasaMes() {
        return capasBiomasaMes;
    }

    public void setCapasBiomasaMes(List<Capamap> capasBiomasaMes) {
        this.capasBiomasaMes = capasBiomasaMes;
    }

    public List<Capamap> getCapasBiomasaAnio() {
        return capasBiomasaAnio;
    }

    public void setCapasBiomasaAnio(List<Capamap> capasBiomasaAnio) {
        this.capasBiomasaAnio = capasBiomasaAnio;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public int getTypeenergy() {
        return typeenergy;
    }

    public void setTypeenergy(int typeenergy) {
        this.typeenergy = typeenergy;
    }

    public String getTypetime() {
        return typetime;
    }

    public void setTypetime(String typetime) {
        this.typetime = typetime;
    }

    
    public String getValorbd() {
        return valorbd;
    }

    public void setValorbd(String valorbd) {
        this.valorbd = valorbd;
    }
    
    public void actualizarCapa() {
        capa = selectCapa.getValue().toString();
        String[] mesfuente = capa.split(":");//DEFINIR EL MAPA ACTUAL Y LA FUENTE DE ENERGIA
        url="http://190.254.4.128:8080/geoserver/"+mesfuente[0]+"/wms?service=WMS&version=1.1.0&request=GetMap&layers="+capa+"&styles=&bbox=-8797736.0588021,36507.00740467082,-8548436.0588021,301557.007404671&width=481&height=512&srs=EPSG:3857&format=image%2Fgeotiff";
    }

    public void actualizarCapaMes() {
        capa = selectMesCapa.getValue().toString();
        String[] mesfuente = capa.split(":");//DEFINIR EL MAPA ACTUAL Y LA FUENTE DE ENERGIA
        url="http://190.254.4.128:8080/geoserver/"+mesfuente[0]+"/wms?service=WMS&version=1.1.0&request=GetMap&layers="+capa+"&styles=&bbox=-8797736.0588021,36507.00740467082,-8548436.0588021,301557.007404671&width=481&height=512&srs=EPSG:3857&format=image%2Fgeotiff";
        
    }

    public String getCapaSelecionada() {
        return capaSelecionada;
    }

    public void setCapaSelecionada(String capaSelecionada) {
        this.capaSelecionada = capaSelecionada;
    }

    public SelectOneMenu getSelectCapa() {
        return selectCapa;
    }

    public void setSelectCapa(SelectOneMenu selectCapa) {
        this.selectCapa = selectCapa;
    }

    public SelectOneMenu getSelectMesCapa() {
        return selectMesCapa;
    }

    public void setSelectMesCapa(SelectOneMenu selectMesCapa) {
        this.selectMesCapa = selectMesCapa;
    }

    public double getM1() {
        return m1;
    }

    public void setM1(double m1) {
        this.m1 = m1;
    }

    public double getM2() {
        return m2;
    }

    public void setM2(double m2) {
        this.m2 = m2;
    }

    public double getM3() {
        return m3;
    }

    public void setM3(double m3) {
        this.m3 = m3;
    }

    public double getM4() {
        return m4;
    }

    public void setM4(double m4) {
        this.m4 = m4;
    }

    public double getM5() {
        return m5;
    }

    public void setM5(double m5) {
        this.m5 = m5;
    }

    public double getM6() {
        return m6;
    }

    public void setM6(double m6) {
        this.m6 = m6;
    }

    public double getM7() {
        return m7;
    }

    public void setM7(double m7) {
        this.m7 = m7;
    }

    public double getM8() {
        return m8;
    }

    public void setM8(double m8) {
        this.m8 = m8;
    }

    public double getM9() {
        return m9;
    }

    public void setM9(double m9) {
        this.m9 = m9;
    }

    public double getM10() {
        return m10;
    }

    public void setM10(double m10) {
        this.m10 = m10;
    }

    public double getM11() {
        return m11;
    }

    public void setM11(double m11) {
        this.m11 = m11;
    }

    public double getM12() {
        return m12;
    }

    public void setM12(double m12) {
        this.m12 = m12;
    }

    public double getMlat() {
        return mlat;
    }

    public void setMlat(double mlat) {
        this.mlat = mlat;
    }

    public double getMlon() {
        return mlon;
    }

    public void setMlon(double mlon) {
        this.mlon = mlon;
    }


    
}
