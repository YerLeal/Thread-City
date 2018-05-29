package Domain;

import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class StopDetector{

//    public static void detect(MouseEvent e)
//    {
//        Global.mouseX = e.getX();
//        Global.mouseY = e.getY();
//        
//        JOptionPane.showMessageDialog(null,"x=" + Global.mouseX + " y=" + Global.mouseY);
//        //first column, left side
//        if(Global.mouseX >= 55 && Global.mouseX <= 80 && Global.mouseY >= 85 && Global.mouseY <= 120)
//        {
//            Global.stops.add(new Point(0,50));
//            JOptionPane.showMessageDialog(null,"Catched1");
//        }
//        
//        else if(Global.mouseX >= 55 && Global.mouseX <= 80 && Global.mouseY >= 205 && Global.mouseY <= 245)
//        {
//            Global.stops.add(new Point(0,165));
//            JOptionPane.showMessageDialog(null,"Catched2");
//        }
//        
//        else if(Global.mouseX >= 55 && Global.mouseX <= 80 && Global.mouseY >= 340 && Global.mouseY <= 380)
//        { 
//            Global.stops.add(new Point(0,305));
//            JOptionPane.showMessageDialog(null,"Catched3");
//        }
//        
//        else if(Global.mouseX >= 55 && Global.mouseX <= 80 && Global.mouseY >= 465 && Global.mouseY <= 500)
//        {   
//            Global.stops.add(new Point(0,420));
//            JOptionPane.showMessageDialog(null,"Catched4");
//        }
//        //first column, right side // second column, left side
//        else if(((Global.mouseX >= 120 && Global.mouseX <= 145) || 
//                (Global.mouseX >= 170 && Global.mouseX <= 195)) &&
//                Global.mouseY >= 85 && Global.mouseY <= 120)
//        {
//            JOptionPane.showMessageDialog(null,"Catched5-9");
//            Global.stops.add(new Point(120,50));
//        }
//        
//        else if(((Global.mouseX >= 120 && Global.mouseX <= 145)||
//                (Global.mouseX >= 170 && Global.mouseX <= 195))&& 
//                Global.mouseY >= 205 && Global.mouseY <= 245)
//        {
//            JOptionPane.showMessageDialog(null,"Catched6-10");
//            Global.stops.add(new Point(120,165));
//        }
//        
//        else if(((Global.mouseX >= 120 && Global.mouseX <= 145) || 
//                (Global.mouseX >= 170 && Global.mouseX <= 195)) &&
//                Global.mouseY >= 340 && Global.mouseY <= 380)
//        { 
//            JOptionPane.showMessageDialog(null,"Catched7-11");
//            Global.stops.add(new Point(120,305));
//        }
//        
//        else if(((Global.mouseX >= 120 && Global.mouseX <= 145) || 
//                (Global.mouseX >= 170 && Global.mouseX <= 195)) &&
//                 Global.mouseY >= 465 && Global.mouseY <= 500)
//        {   
//            JOptionPane.showMessageDialog(null,"Catched8-12");
//            Global.stops.add(new Point(120,420)); 
//        }
//        //second column right side
//        else if(Global.mouseX >= 235 && Global.mouseX <= 265 && Global.mouseY >= 85 && Global.mouseY <= 120)
//        {
//            JOptionPane.showMessageDialog(null,"Catched13");
//            Global.stops.add(new Point(240,50));
//        }
//        
//        else if(Global.mouseX >= 235 && Global.mouseX <= 265 && Global.mouseY >= 205 && Global.mouseY <= 245)
//        {
//            Global.stops.add(new Point(240,165));
//            JOptionPane.showMessageDialog(null,"Catched14");
//        }
//        
//        else if(Global.mouseX >= 235 && Global.mouseX <= 265 && Global.mouseY >= 340 && Global.mouseY <= 380)
//        { 
//            Global.stops.add(new Point(240,305));
//            JOptionPane.showMessageDialog(null,"Catched15");
//        }
//        
//        else if(Global.mouseX >= 235 && Global.mouseX <= 265 && Global.mouseY >= 465 && Global.mouseY <= 500)
//        {   
//            Global.stops.add(new Point(240,420));
//            JOptionPane.showMessageDialog(null,"Catched16");
//        }
//        //Third column, left side
//        else if(Global.mouseX >= 315 && Global.mouseX <= 345 && Global.mouseY >= 85 && Global.mouseY <= 120)
//        {
//            JOptionPane.showMessageDialog(null,"Catched17");
//            Global.stops.add(new Point(260,50));
//        }
//        
//        else if(Global.mouseX >= 315 && Global.mouseX <= 345 && Global.mouseY >= 205 && Global.mouseY <= 245)
//        {
//            Global.stops.add(new Point(260,165));
//            JOptionPane.showMessageDialog(null,"Catched18");
//        }
//        
//        else if(Global.mouseX >= 315 && Global.mouseX <= 345 && Global.mouseY >= 340 && Global.mouseY <= 380)
//        { 
//            Global.stops.add(new Point(260,305));
//            JOptionPane.showMessageDialog(null,"Catched19");
//        }
//        
//        else if(Global.mouseX >= 315 && Global.mouseX <= 345 && Global.mouseY >= 465 && Global.mouseY <= 500)
//        {   
//            Global.stops.add(new Point(260,420));
//            JOptionPane.showMessageDialog(null,"Catched20");
//        }
//        //Third column, right side
//        else if(Global.mouseX >= 375 && Global.mouseX <= 405 && Global.mouseY >= 85 && Global.mouseY <= 120)
//        {
//            JOptionPane.showMessageDialog(null,"Catched21");
//            Global.stops.add(new Point(380,50));
//        }
//        
//        else if(Global.mouseX >= 375 && Global.mouseX <= 405 && Global.mouseY >= 205 && Global.mouseY <= 245)
//        {
//            Global.stops.add(new Point(380,165));
//            JOptionPane.showMessageDialog(null,"Catched22");
//        }
//        
//        else if(Global.mouseX >= 375 && Global.mouseX <= 405 && Global.mouseY >= 340 && Global.mouseY <= 380)
//        { 
//            Global.stops.add(new Point(380,305));
//            JOptionPane.showMessageDialog(null,"Catched23");
//        }
//        
//        else if(Global.mouseX >= 375 && Global.mouseX <= 405 && Global.mouseY >= 465 && Global.mouseY <= 500)
//        {   
//            Global.stops.add(new Point(380,420));
//            JOptionPane.showMessageDialog(null,"Catched24");
//        }
//        //Fourth column, left side
//        else if(Global.mouseX >= 455 && Global.mouseX <= 480 && Global.mouseY >= 85 && Global.mouseY <= 120)
//        {
//            JOptionPane.showMessageDialog(null,"Catched25");
//            Global.stops.add(new Point(400,50));
//        }
//        
//        else if(Global.mouseX >= 455 && Global.mouseX <= 480 && Global.mouseY >= 205 && Global.mouseY <= 245)
//        {
//            Global.stops.add(new Point(400,165));
//            JOptionPane.showMessageDialog(null,"Catched26");
//        }
//        
//        else if(Global.mouseX >= 455 && Global.mouseX <= 480 && Global.mouseY >= 340 && Global.mouseY <= 380)
//        { 
//            Global.stops.add(new Point(400,305));
//            JOptionPane.showMessageDialog(null,"Catched27");
//        }
//        
//        else if(Global.mouseX >= 455 && Global.mouseX <= 480 && Global.mouseY >= 465 && Global.mouseY <= 500)
//        {   
//            Global.stops.add(new Point(400,420));
//            JOptionPane.showMessageDialog(null,"Catched28");
//        }
//        //Fourth column, right side// fifth column, left side
//        else if(((Global.mouseX >= 520 && Global.mouseX <= 550) || 
//                (Global.mouseX >= 575 && Global.mouseX <= 605)) 
//                && Global.mouseY >= 85 && Global.mouseY <= 120)
//        {
//            JOptionPane.showMessageDialog(null,"Catched29-33");
//            Global.stops.add(new Point(520,50));
//        }
//        
//        else if(((Global.mouseX >= 520 && Global.mouseX <= 550) || 
//                (Global.mouseX >= 575 && Global.mouseX <= 605)) 
//                && Global.mouseY >= 205 && Global.mouseY <= 245)
//        {
//            Global.stops.add(new Point(520,165));
//            JOptionPane.showMessageDialog(null,"Catched30-34");
//        }
//        
//        else if(((Global.mouseX >= 520 && Global.mouseX <= 550) || 
//                (Global.mouseX >= 575 && Global.mouseX <= 605)) 
//                && Global.mouseY >= 340 && Global.mouseY <= 380)
//        { 
//            Global.stops.add(new Point(520,305));
//            JOptionPane.showMessageDialog(null,"Catched31-35");
//        }
//        
//        else if(((Global.mouseX >= 520 && Global.mouseX <= 550) || 
//                (Global.mouseX >= 575 && Global.mouseX <= 605)) 
//                && Global.mouseY >= 465 && Global.mouseY <= 500)
//        {   
//            Global.stops.add(new Point(520,420));
//            JOptionPane.showMessageDialog(null,"Catched32-36");
//        }
//        //635//665
//        //640
//        else if(Global.mouseX >= 635 && Global.mouseX <= 665 && Global.mouseY >= 85 && Global.mouseY <= 120)
//        {
//            JOptionPane.showMessageDialog(null,"Catched37");
//            Global.stops.add(new Point(640,50));
//        }
//        
//        else if(Global.mouseX >= 635 && Global.mouseX <= 665 && Global.mouseY >= 205 && Global.mouseY <= 245)
//        {
//            Global.stops.add(new Point(640,165));
//            JOptionPane.showMessageDialog(null,"Catched38");
//        }
//        
//        else if(Global.mouseX >= 635 && Global.mouseX <= 665 && Global.mouseY >= 340 && Global.mouseY <= 380)
//        { 
//            Global.stops.add(new Point(640,305));
//            JOptionPane.showMessageDialog(null,"Catched39");
//        }
//        
//        else if(Global.mouseX >= 635 && Global.mouseX <= 665 && Global.mouseY >= 465 && Global.mouseY <= 500)
//        {   
//            Global.stops.add(new Point(640,420));
//            JOptionPane.showMessageDialog(null,"Catched40");
//        }
//        //first row, top side
//        else if(Global.mouseX >= 85 && Global.mouseX <= 120 && Global.mouseY >= 55 && Global.mouseY <= 80)
//        {   
//            Global.stops.add(new Point(60,0));
//            JOptionPane.showMessageDialog(null,"Catched41");
//        }
//        
//        else if(Global.mouseX >= 205 && Global.mouseX <= 230 && Global.mouseY >= 55 && Global.mouseY <= 80)
//        {   
//            Global.stops.add(new Point(180,0));
//            JOptionPane.showMessageDialog(null,"Catched42");
//        }
//        
//        else if(Global.mouseX >= 345 && Global.mouseX <= 375 && Global.mouseY >= 55 && Global.mouseY <= 80)
//        {   
//            Global.stops.add(new Point(320,0));
//            JOptionPane.showMessageDialog(null,"Catched43");
//        }
//        
//        else if(Global.mouseX >= 485 && Global.mouseX <= 515 && Global.mouseY >= 55 && Global.mouseY <= 80)
//        {   
//            Global.stops.add(new Point(460,0));
//            JOptionPane.showMessageDialog(null,"Catched44");
//        }
//        
//        else if(Global.mouseX >= 600 && Global.mouseX <= 640 && Global.mouseY >= 55 && Global.mouseY <= 80)
//        {   
//            Global.stops.add(new Point(580,0));
//            JOptionPane.showMessageDialog(null,"Catched45");
//        }
//        //first row, bottom side //second row top side
//        else if(Global.mouseX >= 85 && Global.mouseX <= 120 && 
//                ((Global.mouseY >= 125 && Global.mouseY <= 150)||
//                (Global.mouseY >= 175 && Global.mouseY <= 200)))
//        {   
//            Global.stops.add(new Point(60,120));
//            JOptionPane.showMessageDialog(null,"Catched46-51");
//        }
//        
//        else if(Global.mouseX >= 205 && Global.mouseX <= 230 && 
//                ((Global.mouseY >= 125 && Global.mouseY <= 150)||
//                (Global.mouseY >= 175 && Global.mouseY <= 200)))
//        {   
//            Global.stops.add(new Point(180,120));
//            JOptionPane.showMessageDialog(null,"Catched47-52");
//        }
//        
//        else if(Global.mouseX >= 345 && Global.mouseX <= 375 && 
//                ((Global.mouseY >= 125 && Global.mouseY <= 150)||
//                (Global.mouseY >= 175 && Global.mouseY <= 200)))
//        {   
//            Global.stops.add(new Point(320,120));
//            JOptionPane.showMessageDialog(null,"Catched48-53");
//        }
//        
//        else if(Global.mouseX >= 485 && Global.mouseX <= 515 && 
//                ((Global.mouseY >= 125 && Global.mouseY <= 150)||
//                (Global.mouseY >= 175 && Global.mouseY <= 200)))
//        {   
//            Global.stops.add(new Point(460,120));
//            JOptionPane.showMessageDialog(null,"Catched49-54");
//        }
//        
//        else if(Global.mouseX >= 600 && Global.mouseX <= 640 && 
//                ((Global.mouseY >= 125 && Global.mouseY <= 150)||
//                (Global.mouseY >= 175 && Global.mouseY <= 200)))
//        {   
//            Global.stops.add(new Point(580,120));
//            JOptionPane.showMessageDialog(null,"Catched50-55");
//        }
//        //third row, bottom, fourt row top
//        else if(Global.mouseX >= 85 && Global.mouseX <= 120 && 
//                ((Global.mouseY >= 380 && Global.mouseY <= 410)||
//                (Global.mouseY >= 435 && Global.mouseY <= 460)))
//        {   
//            Global.stops.add(new Point(60,380));
//            JOptionPane.showMessageDialog(null,"Catched56-61");
//        }
//        
//        else if(Global.mouseX >= 205 && Global.mouseX <= 230 && 
//                ((Global.mouseY >= 380 && Global.mouseY <= 410)||
//                (Global.mouseY >= 435 && Global.mouseY <= 460)))
//        {   
//            Global.stops.add(new Point(180,380));
//            JOptionPane.showMessageDialog(null,"Catched57-62");
//        }
//        
//        else if(Global.mouseX >= 345 && Global.mouseX <= 375 && 
//                ((Global.mouseY >= 380 && Global.mouseY <= 410)||
//                (Global.mouseY >= 435 && Global.mouseY <= 460)))
//        {   
//            Global.stops.add(new Point(320,380));
//            JOptionPane.showMessageDialog(null,"Catched58-63");
//        }
//        
//        else if(Global.mouseX >= 485 && Global.mouseX <= 515 && 
//                ((Global.mouseY >= 380 && Global.mouseY <= 410)||
//                (Global.mouseY >= 435 && Global.mouseY <= 460)))
//        {   
//            Global.stops.add(new Point(460,380));
//            JOptionPane.showMessageDialog(null,"Catched59-64");
//        }
//        
//        else if(Global.mouseX >= 600 && Global.mouseX <= 640 && 
//                ((Global.mouseY >= 380 && Global.mouseY <= 410)||
//                (Global.mouseY >= 435 && Global.mouseY <= 460)))
//        {   
//            Global.stops.add(new Point(580,380));
//            JOptionPane.showMessageDialog(null,"Catched60-65");
//        }
//        //fourth row bottom side
//        else if(Global.mouseX >= 85 && Global.mouseX <= 120 && Global.mouseY >= 500 && Global.mouseY <= 525)
//        {   
//            Global.stops.add(new Point(60,500));
//            JOptionPane.showMessageDialog(null,"Catched66");
//        }
//        
//        else if(Global.mouseX >= 205 && Global.mouseX <= 230 && Global.mouseY >= 500 && Global.mouseY <= 525)
//        {   
//            Global.stops.add(new Point(180,500));
//            JOptionPane.showMessageDialog(null,"Catched67");
//        }
//        
//        else if(Global.mouseX >= 345 && Global.mouseX <= 375 && Global.mouseY >= 500 && Global.mouseY <= 525)
//        {   
//            Global.stops.add(new Point(320,500));
//            JOptionPane.showMessageDialog(null,"Catched68");
//        }
//        
//        else if(Global.mouseX >= 485 && Global.mouseX <= 515 && Global.mouseY >= 500 && Global.mouseY <= 525)
//        {   
//            Global.stops.add(new Point(460,500));
//            JOptionPane.showMessageDialog(null,"Catched69");
//        }
//        
//        else if(Global.mouseX >= 600 && Global.mouseX <= 640 && Global.mouseY >= 500 && Global.mouseY <= 525)
//        {   
//            Global.stops.add(new Point(580,500));
//            JOptionPane.showMessageDialog(null,"Catched70");
//        }
//    }
}