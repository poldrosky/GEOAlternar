/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.model.DefaultStreamedContent;

/**
 *
 * @author giiee
 */
@ManagedBean(name = "exec")
public class exec {
    
    public void exec() {  
         
    }  
    private String latitude, longitude;
    public void runRscript() throws IOException
    {
        Process p;
        ProcessBuilder pb = new ProcessBuilder();
        ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String directory = ctx.getRealPath("/") + "resources/scripts/";
        String fileInput = ctx.getRealPath("/") + "resources/csv/" ;
         pb = new ProcessBuilder("Rscript",directory + "wind2plot.R","-8684100","128250");
         p = pb.start();

        System.out.println(directory);
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
    
    
}
