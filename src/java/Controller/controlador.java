/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.Dao;
import Model.model;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import org.json.JSONException;

/**
 *
 * @author jordy
 */
@Named(value = "Controller")
@SessionScoped
public class controlador implements Serializable {

    /**
     * Creates a new instance of NewJSFManagedBean
     */
    
    model dl = new model();
    public void limpiar(){
         dl = new model();
    }
    
    public void traducirText() throws IOException, JSONException {
        Dao dao;
        try {
            dao = new Dao();
            dao.Traducir(dl);
        } catch (IOException | JSONException e) {
            throw e;
        }
    }

    public model getDl() {
        return dl;
    }

    public void setDl(model dl) {
        this.dl = dl;
    }
    
    
}
