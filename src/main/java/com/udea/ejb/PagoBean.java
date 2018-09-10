package com.udea.ejb;
import java.util.ArrayList;
import com.udea.model.Pago;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;

@Stateless
@LocalBean
public class PagoBean implements Serializable {
    private static final long serialVersionUID = 321321321L;

    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    public void init(){
        System.out.println("inicio el ejb");
    }

    public void guardarPago(Pago pago){
        em.persist(pago);
        System.out.println("pago guardado");
    }

    public List<Pago> getListaPagos(){
        try{
            return em.createQuery("select p from Pago p").getResultList();
        }catch(Exception e){e.printStackTrace();}
        return new ArrayList<Pago>();
    }
}
