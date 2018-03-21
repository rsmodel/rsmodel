/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.Controller.Data;

import finance.manager.View.ComponentStorage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import javafx.util.Pair;

/**
 *
 * @author User
 */
public class LinkStorageToData {
    private Vector<Link> _link = new Vector<>();
    
    public LinkStorageToData () {
        
    }
    
    public void addLink(String Data, String Storage, LinkAction la)  {
        _link.add(new Link(Data, Storage, la));
    }
    
    public void apply(ComponentStorage cs, HashMap<String,String> _map) {
        Iterator<Link> iter =  _link.iterator();
        while(iter.hasNext()) {
            Link l = iter.next();
            l.fromFistToSecond(cs, _map);
        }
    }
    
    public void apply(HashMap<String,String> _map, ComponentStorage cs) {
        Iterator<Link> iter =  _link.iterator();
        while(iter.hasNext()) {
            Link l = iter.next();
            l.fromFistToSecond(cs, _map);
        }
    }
}
