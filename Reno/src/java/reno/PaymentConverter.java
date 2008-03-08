/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reno;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author intesar
 */
public class PaymentConverter implements Converter {

    public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
        if (string == null) {
            return null;
        }
        Integer id = new Integer(string);
        PaymentController controller = (PaymentController) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "payment");

        return controller.findPayment(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof Payment) {
            Payment o = (Payment) object;
            return "" + o.getId();
        } else {
            throw new IllegalArgumentException("object:" + object + " of type:" + object.getClass().getName() + "; expected type: reno.Payment");
        }
    }

}
