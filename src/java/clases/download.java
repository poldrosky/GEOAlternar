package clases;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean(name = "download")
 public class download {
     
     private StreamedContent file,filemonth;  
     
     public download() throws FileNotFoundException {  
         InputStream stream  = new FileInputStream("/opt/maps/MapsCSV/Biomass2000-2014.csv");   
         file = new DefaultStreamedContent(stream, "application/csv", "Biomass2000-2014.csv");  
         InputStream stream2  = new FileInputStream("/opt/maps/MapsCSV/BiomassEnero-Diciembre.csv");   
         filemonth = new DefaultStreamedContent(stream, "application/csv", "BiomassEnero-Diciembre.csv");  
    }  
      
    public StreamedContent getFile() {  
        return file;  
    }  
  
    public void setFile(StreamedContent file) {  
        this.file = file;  
    }

    public StreamedContent getFilemonth() {
        return filemonth;
    }

    public void setFilemonth(StreamedContent filemonth) {
        this.filemonth = filemonth;
    }
    
    
}   
