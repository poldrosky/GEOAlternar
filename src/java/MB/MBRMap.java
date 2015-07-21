/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;

import DAO.MapsFacade;
import Entidad.Capamap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.activation.MimetypesFileTypeMap;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

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
    private  String url,urlcsv;

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
    //Solar
        this.capasSolarMes = new ArrayList<Capamap>();
        Capamap capa1s = new Capamap("Enero", "MapSun:January");
        Capamap capa2s = new Capamap("Febrero", "MapSun:February");
        Capamap capa3s = new Capamap("Marzo", "MapSun:March");
        Capamap capa4s = new Capamap("Abril", "MapSun:April");
        Capamap capa5s = new Capamap("Mayo", "MapSun:May");
        Capamap capa6s = new Capamap("Junio", "MapSun:June");
        Capamap capa7s = new Capamap("Julio", "MapSun:July");
        Capamap capa8s = new Capamap("Agosto", "MapSun:August");
        Capamap capa9s = new Capamap("sebtiembre", "MapSun:September");
        Capamap capa10s = new Capamap("Octubre", "MapSun:October");
        Capamap capa11s = new Capamap("Noviembre", "MapSun:November");
        Capamap capa12s = new Capamap("Diciembre", "MapSun:December");
        this.capasSolarMes.add(capa1s);
        this.capasSolarMes.add(capa2s);
        this.capasSolarMes.add(capa3s);
        this.capasSolarMes.add(capa4s);
        this.capasSolarMes.add(capa5s);
        this.capasSolarMes.add(capa6s);
        this.capasSolarMes.add(capa7s);
        this.capasSolarMes.add(capa8s);
        this.capasSolarMes.add(capa9s);
        this.capasSolarMes.add(capa10s);
        this.capasSolarMes.add(capa11s);
        this.capasSolarMes.add(capa12s);
        //Solar Anio
        this.capasSolarAnio = new ArrayList<Capamap>();
        Capamap capa2000s = new Capamap("2000", "MapSun:2000");
        Capamap capa2001s = new Capamap("2001", "MapSun:2001");
        Capamap capa2002s = new Capamap("2002", "MapSun:2002");
        Capamap capa2003s = new Capamap("2003", "MapSun:2003");
        Capamap capa2004s = new Capamap("2004", "MapSun:2004");
        Capamap capa2005s = new Capamap("2005", "MapSun:2005");
        Capamap capa2006s = new Capamap("2006", "MapSun:2006");
        Capamap capa2007s = new Capamap("2007", "MapSun:2007");
        Capamap capa2008s = new Capamap("2008", "MapSun:2008");
        Capamap capa2009s = new Capamap("2009", "MapSun:2009");
        Capamap capa2010s = new Capamap("2010", "MapSun:2010");
        Capamap capa2011s = new Capamap("2011", "MapSun:2011");
        Capamap capa2012s = new Capamap("2012", "MapSun:2012");
        Capamap capa2013s = new Capamap("2013", "MapSun:2013");
        Capamap capa2014s = new Capamap("2014", "MapSun:2014");
        this.capasSolarAnio.add(capa2000s);
        this.capasSolarAnio.add(capa2001s);
        this.capasSolarAnio.add(capa2002s);
        this.capasSolarAnio.add(capa2003s);
        this.capasSolarAnio.add(capa2004s);
        this.capasSolarAnio.add(capa2005s);
        this.capasSolarAnio.add(capa2006s);
        this.capasSolarAnio.add(capa2007s);
        this.capasSolarAnio.add(capa2008s);
        this.capasSolarAnio.add(capa2009s);
        this.capasSolarAnio.add(capa2010s);
        this.capasSolarAnio.add(capa2011s);
        this.capasSolarAnio.add(capa2012s);
        this.capasSolarAnio.add(capa2013s);
        this.capasSolarAnio.add(capa2014s);

    }
    private double valuelat, valuelon;
    private int lat, lon;
    private double m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12,m13,m14,m15, mlat, mlon;
    private double y0,y1,y2,y3,y4,y5,y6,y7,y8,y9,y10,y11,y12,y13,y14;
    private  String valorbd;

    public void consultarSolarCoordenada() {
        
    }
    
    public void consultarVientoCoordenada() {
        
    }

    public void consultarBiomasaCoordenada() {
        Object[] valor, valormeses,valoranios;
        valuelat = Double.parseDouble(this.latitude);//CONVERTIR CORDENADAS A ENTEROS PARA CONSULTAR BD
        lat = (int) (valuelat - (valuelat % 900));
        valuelon = Double.parseDouble(this.longitude);
        lon = (int) (valuelon - (valuelon % 900));
        String[] mesfuente = capa.split(":");//DEFINIR EL MAPA ACTUAL Y LA FUENTE DE ENERGIA
        if (mesfuente[0].equals("MapBiomass")) {
            valor= daoMap.getByCoordenate(lon, lat, mesfuente[1], 2);
            valorbd="Biomasa en mapa seleccionado: "+valor[3].toString()+" Mg/Ha";
            //////////consultar valor por MES O AÑO
            valormeses = daoMap.getHistoryMonths(lon, lat, mesfuente[1], 2);
            //datos resultantes de la consulta lat,lon,enero,febrero,.....,diciembre
            mlat = Double.parseDouble(valormeses[0].toString());
            mlon = Double.parseDouble(valormeses[1].toString());
            m1 = Double.parseDouble(valormeses[2].toString());
            m2 = Double.parseDouble(valormeses[3].toString());
            m3 = Double.parseDouble(valormeses[4].toString());
            m4 = Double.parseDouble(valormeses[5].toString());
            m5 = Double.parseDouble(valormeses[6].toString());
            m6 = Double.parseDouble(valormeses[7].toString());
            m7 = Double.parseDouble(valormeses[8].toString());
            m8 = Double.parseDouble(valormeses[9].toString());
            m9 = Double.parseDouble(valormeses[10].toString());
            m10 = Double.parseDouble(valormeses[11].toString());
            m11 = Double.parseDouble(valormeses[12].toString());
            m12 = Double.parseDouble(valormeses[13].toString());
            
            valoranios=daoMap.getHistoryYears(lon, lat, mesfuente[1], 2);
            y0 = Double.parseDouble(valoranios[2].toString());
            y1 = Double.parseDouble(valoranios[3].toString());
            y2 = Double.parseDouble(valoranios[4].toString());
            y3 = Double.parseDouble(valoranios[5].toString());
            y4 = Double.parseDouble(valoranios[6].toString());
            y5 = Double.parseDouble(valoranios[7].toString());
            y6 = Double.parseDouble(valoranios[8].toString());
            y7 = Double.parseDouble(valoranios[9].toString());
            y8 = Double.parseDouble(valoranios[10].toString());
            y9 = Double.parseDouble(valoranios[11].toString());
            y10 = Double.parseDouble(valoranios[12].toString());
            y11 = Double.parseDouble(valoranios[13].toString());
            y12 = Double.parseDouble(valoranios[14].toString());
            y13 = Double.parseDouble(valoranios[15].toString());
            y14 = Double.parseDouble(valoranios[16].toString());
        }
    }
   private StreamedContent filecsv;

    public StreamedContent getFilecsv() {
        return filecsv;
    }

    public void setFilecsv(StreamedContent filecsv) {
        this.filecsv = filecsv;
    }
    
    public StreamedContent descaragaDatosBiomasa() {
        InputStream stream = this.getClass().getResourceAsStream("/opt/maps/MapsCSV/BiomassEnero-Diciembre.csv");
        filecsv = new DefaultStreamedContent(stream, "application/csv", "sessionlog.csv");
        return filecsv;
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

    public List<Capamap> getCapasSolarMes() {
        return capasSolarMes;
    }

    public void setCapasSolarMes(List<Capamap> capasSolarMes) {
        this.capasSolarMes = capasSolarMes;
    }

    public List<Capamap> getCapasSolarAnio() {
        return capasSolarAnio;
    }

    public void setCapasSolarAnio(List<Capamap> capasSolarAnio) {
        this.capasSolarAnio = capasSolarAnio;
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

    public double getM13() {
        return m13;
    }

    public void setM13(double m13) {
        this.m13 = m13;
    }

    public double getM14() {
        return m14;
    }

    public void setM14(double m14) {
        this.m14 = m14;
    }

    public double getM15() {
        return m15;
    }

    public void setM15(double m15) {
        this.m15 = m15;
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

    public double getY0() {
        return y0;
    }

    public void setY0(double y0) {
        this.y0 = y0;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public double getY3() {
        return y3;
    }

    public void setY3(double y3) {
        this.y3 = y3;
    }

    public double getY4() {
        return y4;
    }

    public void setY4(double y4) {
        this.y4 = y4;
    }

    public double getY5() {
        return y5;
    }

    public void setY5(double y5) {
        this.y5 = y5;
    }

    public double getY6() {
        return y6;
    }

    public void setY6(double y6) {
        this.y6 = y6;
    }

    public double getY7() {
        return y7;
    }

    public void setY7(double y7) {
        this.y7 = y7;
    }

    public double getY8() {
        return y8;
    }

    public void setY8(double y8) {
        this.y8 = y8;
    }

    public double getY9() {
        return y9;
    }

    public void setY9(double y9) {
        this.y9 = y9;
    }

    public double getY10() {
        return y10;
    }

    public void setY10(double y10) {
        this.y10 = y10;
    }

    public double getY11() {
        return y11;
    }

    public void setY11(double y11) {
        this.y11 = y11;
    }

    public double getY12() {
        return y12;
    }

    public void setY12(double y12) {
        this.y12 = y12;
    }

    public double getY13() {
        return y13;
    }

    public void setY13(double y13) {
        this.y13 = y13;
    }

    public double getY14() {
        return y14;
    }

    public void setY14(double y14) {
        this.y14 = y14;
    }
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlcsv() {
        return urlcsv;
    }

    public void setUrlcsv(String urlcsv) {
        this.urlcsv = urlcsv;
    }
    
    
    
}
