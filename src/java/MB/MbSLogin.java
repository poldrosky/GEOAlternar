/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;


import DAO.UsersFacade;
import Entidad.Users;
import clases.Encrypt;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;


/**
 *
 * @author edixred
 */
@Named(value="mbSLogin")
@ManagedBean
@SessionScoped
public class MbSLogin implements Serializable{

    
    private String email;
    private String password;
    @EJB
    UsersFacade daoUsers;
    
 
    
    public MbSLogin() {
        
        HttpSession misession=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        misession.setMaxInactiveInterval(5000);
    }
    
    public String login()
    {     
        try
        {
          
            Users usuario=daoUsers.getByEmail(this.email);
      
            if(usuario!=null)
            {
                if(usuario.getPassword().equals(Encrypt.sha512(this.password)))
                {
                    HttpSession httpSession=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                    httpSession.setAttribute("email", this.email);
                    
                    return "Energia";
                }
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de Acceso", "Usuario o Contraseña Incorrecto"));
            this.email=null;
            this.password=null;
            
            return "IniciarSesion";
           
        } 
        catch (Exception e) 
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL", "Por favor contacte con su administrador"+e.getMessage()));
            return null;
        }
    }
    
    public String cerrarSesion()
    {
        this.email=null;
        this.password=null;
        HttpSession httpSession=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        httpSession.invalidate();
        
        return "IniciarSesion";
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
