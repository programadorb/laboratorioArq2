package com.udea.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import com.udea.utils.Utilidades;
import javax.faces.context.ExternalContext;
import java.io.File;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import java.io.FileInputStream;
import com.udea.model.Pago;
import javax.ejb.EJB;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.BarcodeFactory;
import com.udea.ejb.PagoBean;
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
import java.util.UUID;

@Named(value="pagoController")
@SessionScoped
public class PagoController implements Serializable
{
    private static final long serialVersionUID = 120101L;

    @EJB
    private PagoBean pagoBean;

    String idTransaccion;
    String nombre;
    String email;
    String fechaVencimiento;
    Long numeroTarjeta;
    Long valorTransaccion;
    String codigoSeguridad;
    String tipoTarjeta;
    List<Pago> listaPagos=new ArrayList<Pago>();

    private String msg = "msg";

    public void consultarPagos(){
        try {
            if (!FacesContext.getCurrentInstance().isPostback()) {
                listaPagos = pagoBean.getListaPagos();
                System.out.println("se consultaron  : "+listaPagos.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PagoController(){
        try {
            File barcodeFile = new File("dynamicbarcode");
            BarcodeImageHandler.saveJPEG(BarcodeFactory.createCode128("PRIMEFACES"), barcodeFile);
            barcode = new DefaultStreamedContent(new FileInputStream(barcodeFile), "image/jpeg");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    public boolean validarPago(){
        try{
            if(valorTransaccion==null || valorTransaccion<500  || valorTransaccion>10000){
                advertencia("El valor debe estar entre 500 y 10000");
                return false;
            }

//            if(fechaVencimiento==null || fechaVencimiento.)
            RequestContext.getCurrentInstance().execute("PF('dialogoCapcha').show();");
        }catch(Exception e){e.printStackTrace();}
        return true;
    }



    public String enviar() {
        if(validarPago()){
            Pago pago = new Pago();
            pago.setNombre(nombre);
            pago.setEmail(email);
            pago.setNumeroTarjeta(numeroTarjeta);
            pago.setCodigoSeguridad(codigoSeguridad);
            pago.setFechaVencimiento(fechaVencimiento);
            pago.setValorTransaccion(valorTransaccion);
            pago.setTipoTarjeta(tipoTarjeta);

            UUID idOne = UUID.randomUUID();
            pago.setTransaccion(idOne.toString());
            idTransaccion=idOne.toString();

            System.out.println("el tipo de tarjeta es : ");
            System.out.println(tipoTarjeta);
            System.out.println("termino de mosrtar el tipo de tarjeta");
            pagoBean.guardarPago(pago);
            System.out.println("pago exitoso con el id : "+pago.getId());
            terminar();
        }
        return null;
    }

    private StreamedContent barcode;

    public String terminar(){       
        try{
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect("exito.xhtml");
        }catch(Exception e){e.printStackTrace();}
        return null;
    }

    public void limpiar(){
        try{    
            if (!FacesContext.getCurrentInstance().isPostback()) {
                nombre=null;
                email=null;
                codigoSeguridad=null;
                tipoTarjeta=null;
                fechaVencimiento=null;
                numeroTarjeta=null;
                valorTransaccion=null;
            }
//            ejecutarScript("rellenarMetodoPago()");
        }catch(Exception e){e.printStackTrace();}
    }

    public String getSubCodigo(String cadena){
        if(cadena!=null && !cadena.isEmpty()){
            return "********"+cadena.substring(cadena.length()/2);
        }
        return "";
    }

    public String getCodigoTarjeta(){
        if(numeroTarjeta!=null && !numeroTarjeta.isEmpty()){
            return "********"+numeroTarjeta.substring(numeroTarjeta.length()/2);
        }
        return "";
    }


    public StreamedContent getBarcode() {
        return this.barcode;
    }

    public void ejecutarScript(String str){
        RequestContext.getCurrentInstance().execute(str);
    }

    private void info(String msg){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, ""));
    }

    private void advertencia(String msg){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, msg, ""));
    }

    private void error(String msg){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, ""));
    }

    public String getFecha(){
        return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());
    }

    public void setMsg(String msg){this.msg=msg;}
    public String getMsg(){return this.msg;}

    public void setNombre(String nombre){this.nombre=nombre;}
    public String getNombre(){return this.nombre;}

    public void setEmail(String email){this.email=email;}
    public String getEmail(){return this.email;}

    public void setNumeroTarjeta(Long numeroTarjeta){this.numeroTarjeta=numeroTarjeta;}
    public Long getNumeroTarjeta(){return this.numeroTarjeta;}

    public void setCodigoSeguridad(String codigoSeguridad){this.codigoSeguridad=codigoSeguridad;}
    public String getCodigoSeguridad(){return this.codigoSeguridad;}

    public void setTipoTarjeta(String tipoTarjeta){this.tipoTarjeta=tipoTarjeta;}
    public String getTipoTarjeta(){return this.tipoTarjeta;}

    public void setFechaVencimiento(String fechaVencimiento){this.fechaVencimiento=fechaVencimiento;}
    public String getFechaVencimiento(){return this.fechaVencimiento;}

    public void setValorTransaccion(Long valorTransaccion){this.valorTransaccion=valorTransaccion;}
    public Long getValorTransaccion(){return this.valorTransaccion;}

    public void setIdTransaccion(String idTransaccion){this.idTransaccion=idTransaccion;}
    public String getIdTransaccion(){return this.idTransaccion;}

    public void setListaPagos(List<Pago> listaPagos){this.listaPagos=listaPagos;}
    public List<Pago> getListaPagos(){return this.listaPagos;}
}
