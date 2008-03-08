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
public class StatusCodesConverter implements Converter {

    public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
        if (string == null) {
            return null;
        }
        String id = string;
        StatusCodesController controller = (StatusCodesController) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "statusCodes");

        return controller.findStatusCodes(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof StatusCodes) {
            StatusCodes o = (StatusCodes) object;
            return "" + o.getCode();
        } else {
            throw new IllegalArgumentException("object:" + object + " of type:" + object.getClass().getName() + "; expected type: reno.StatusCodes");
        }
    }

}
