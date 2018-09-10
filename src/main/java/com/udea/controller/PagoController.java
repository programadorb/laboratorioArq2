package com.udea.controller;
import com.udea.ejb.PagoBean;
import javax.ejb.EJB;
import org.primefaces.context.RequestContext;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.servlet.http.HttpServletRequest;
import javax.faces.bean.ManagedProperty;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.faces.context.FacesContext;
import javax.annotation.PostConstruct;

@Named(value="pagoController")
@SessionScoped
public class PagoController implements Serializable
{
    @EJB
    private PagoBean pagoBean;

    @PostConstruct
    public void init(){
        System.out.println("inicio el bean");
    }
}
