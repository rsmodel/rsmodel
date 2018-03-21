/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.Controller.Data;

import finance.manager.View.ComponentStorage;
import java.util.HashMap;

/**
 *
 * @author User
 */
public class Link {
    private String _first = null;
    private String _second = null;
    private LinkAction  _link_action = null;

    public Link(String first, String second, LinkAction la ) {
        _first = first;
        _second = second;
        _link_action = la;
    }
    
    public void fromFistToSecond(ComponentStorage cs, HashMap<String,String> data) {
        _link_action.doFirstToSecond(cs.getJComponent(_first), data.get(_second));
    }
    
    public void fromSecondToFirst(ComponentStorage cs, HashMap<String,String> data) {
        _link_action.doSecontoToFirst(cs.getJComponent(_first), data.get(_second));
    }
}
