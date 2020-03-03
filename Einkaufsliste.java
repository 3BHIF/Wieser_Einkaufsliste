


import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import javax.xml.bind.annotation.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wiese_ko8fa
 */
@XmlRootElement(name = "Root")
public class Einkaufsliste {
    
    private LinkedList<Eintrag> list = new LinkedList<>();

    public Einkaufsliste() {
    }
    
    @XmlElementWrapper(name = "Einkaufsliste") 
    @XmlElements( { @XmlElement( name="Eintrag", type = Eintrag.class ) } )
    public LinkedList<Eintrag> getList() {
        return list;
    }

    public void setList(LinkedList<Eintrag> list) {
        this.list = list;
    }

    
    public void add(Eintrag e)
    {
        list.add(e);
    }
    
    public void delete(Eintrag e){
        list.remove(e);
    }
    
    public void clear(){
        list.clear();
    }
    
    public Iterator iterator()
    {
        return list.iterator();
    }
    
    public void zusammenfassen()
    {
        for(int i = 0; i < list.size(); i++)
        {
            Eintrag ei = list.get(i);
            for(int j = list.indexOf(list.get(i)) + 1; j < list.size(); j++)
            {
                Eintrag ej = list.get(j);
                if(ei.getGruppe().equals(ej.getGruppe()) && ei.getProdukt().equals(ej.getProdukt()))
                {
                    int anzi = ei.getAnzahl();
                    int anzj = ej.getAnzahl();
                    int anz = anzi + anzj;
                    ei.setAnzahl(anz);
                    Eintrag eintrag = new Eintrag("Delete", "Delete", 0);
                    list.set(j, eintrag);
                }      
            }
        }
        LinkedList<Eintrag> list2 = new LinkedList();
        Iterator i = list.iterator();
        while(i.hasNext())
        {
            Eintrag e = (Eintrag) i.next();
            if(!e.getGruppe().equals("Delete"))
            {
               list2.add(e);
            }
        }
        
        list = list2;
    }
    
    public void sortieren()
    {
        int l = list.size();
        for(int i = 0; i < l - 1; i++){
            for(int j = 0; j < l - i - 1; j++)
            {
                if(list.get(j).getAnzahl() < list.get(j + 1).getAnzahl())
                {
                    Collections.swap(list, j, j + 1);
                }
            }
        }
    }

    @Override
    public String toString() {
        String ret = "";
        Iterator i = list.iterator();
        while (i.hasNext())
        {
            ret += i.next().toString();
        }
        return ret;
    }
    
    public boolean isEmpty()
    {
        if(list.isEmpty())
        {
            return true;
        }
        return false;
    }
    
}
