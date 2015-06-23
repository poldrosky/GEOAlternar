/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;


import DAO.UsersFacade;
import Entidad.Users;
import clases.Encrypt;
import clases.SendEmail;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
/**
 *
 * @author edixred
 */
@ManagedBean
@RequestScoped
public class MbRUsuario {
    @EJB
    private UsersFacade usersFacade;

    /**
     * Creates a new instance of MbRUsuario
     */
    
    private Users usuario;
    private List<Users> listaUsuario;
    
    private String txtContraseniaRepita;
    

    public MbRUsuario() {
        this.usuario=new Users();
        
    }
    
////METODO PARA REGISTRAR USUARIO
    public void resgister()
    {
        try 
        {
            if(!this.usuario.getPassword().equals(this.txtContraseniaRepita))
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR","! Las contraseñas no coinciden ¡"));
                return;
            }
            
            String auxPass=this.txtContraseniaRepita;
            
            if(usersFacade.getByEmail(this.usuario.getEmail())!=null)
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El usuario yá se encuentra registrado en el sistema"));

                return;
            }
            
            this.usuario.setPassword(Encrypt.sha512(this.usuario.getPassword()));
            
            usersFacade.register(this.usuario);
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"INFORMACION","! Registro Correcto ¡"));
            SendEmail.sendEmailRegister(this.usuario.getEmail(), auxPass);
            this.usuario=new Users();
            
        } catch (Exception e) {
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL", "Por favor contactarse con el administrador del sistema, error: "+e.getMessage()));
        }
        
    }
    
    public Users getUsuario() {
        return usuario;
    }

    public void setUsuario(Users usuario) {
        this.usuario = usuario;
    }

    public List<Users> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Users> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public String getTxtContraseniaRepita() {
        return txtContraseniaRepita;
    }

    public void setTxtContraseniaRepita(String txtContraseniaRepita) {
        this.txtContraseniaRepita = txtContraseniaRepita;
    }
    
    
    
}
