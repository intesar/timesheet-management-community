/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cm;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author intesar
 */
public class UserInvestmentConverter implements Converter {

    public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
        if (string == null) {
            return null;
        }
        Integer id = new Integer(string);
        UserInvestmentController controller = (UserInvestmentController) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "userInvestment");

        return controller.findUserInvestment(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof UserInvestment) {
            UserInvestment o = (UserInvestment) object;
            return "" + o.getId();
        } else {
            throw new IllegalArgumentException("object:" + object + " of type:" + object.getClass().getName() + "; expected type: cm.UserInvestment");
        }
    }

}
