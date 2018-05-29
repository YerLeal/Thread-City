package iiproyectoyerlinlealisemestre2017;

import java.awt.Dimension;
import javax.swing.JFrame;

public class IIProyectoYerlinLealISemestre2017 {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Thread City");
        jFrame.add(new GUI.VentanaPrincipal());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setPreferredSize(new Dimension(665, 600));
        jFrame.pack();
        jFrame.setVisible(true);
    } // main

} // class
