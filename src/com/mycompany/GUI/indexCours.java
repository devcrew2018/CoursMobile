/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.codename1.components.Accordion;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.getCurrentForm;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.mycompany.CoursServices.CoursServices;
import com.mycompany.Entities.Cours;
import java.util.ArrayList;

/**
 *
 * @author Firas
 */
public class indexCours {
    private Form f;

    public indexCours() {
       
      f=new Form(new BorderLayout());
      Accordion acc=new Accordion();
      
        CoursServices ss=new CoursServices();
      ArrayList<Cours> listcours = ss.getListCours2();
       
     
      for(Cours s : listcours) {
        SpanLabel sl=new SpanLabel();
          sl.setText("Libelle : "+s.getLib()+"\n Type :"+s.getType()+"\n Salle :"+s.getSalle()+"\n Nom du coach :"+s.getCoachName()+"\n Date :"+s.getDate()+"\n Nombre de place :"+s.getNbPlace());
          Button b = new Button("Réserver");
          b.setUIID("InputAvatarImage");
         
          //acc.add(); 
          
          
          
            
            

            
          b.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
              
                          AddReservation c=new AddReservation(s.getLib(),String.valueOf(s.getId()));
                          c.show();
                      
 
   
          }
      });
           
         acc.addContent(s.getLib(), BoxLayout.encloseY(sl,b));
        
          
      }
f.add(BorderLayout.CENTER, acc);

            Form previous = getCurrentForm();
                            f.getToolbar().setBackCommand(" ", ee -> {
                                    previous.showBack();
                            });
  }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
   
    
    
}

    
    
    
    

