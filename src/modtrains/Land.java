/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modtrains;

import java.util.List;

/**
 *
 * @author Washington
 */
public class Land {
    
    private String strName;
    private List<Town>  lstTown;
    private List<Route> lstRoute;

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public List<Town> getLstTown() {
        return lstTown;
    }

    public void setLstTown(List<Town> lstTown) {
        this.lstTown = lstTown;
    }

    public List<Route> getLstRoute() {
        return lstRoute;
    }

    public void setLstRoute(List<Route> lstRoute) {
        this.lstRoute = lstRoute;
    }
    
    
}
