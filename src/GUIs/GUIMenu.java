/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import tools.CentroDoMonitorMaior;

/**
 *
 * @author Sandro
 */
public class GUIMenu extends JFrame {

    public GUIMenu() {
        setTitle("Menu Example");
        setSize(300, 300);

        JMenuBar menuBar = new JMenuBar();

        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("Tratamento");
        menuBar.add(fileMenu);
        JMenu fileMenu2 = new JMenu("Cliente");
        menuBar.add(fileMenu2);
        JMenu fileMenu3 = new JMenu("Tipo_Tratamento");
        menuBar.add(fileMenu3);
        

        JMenuItem tratamento = new JMenuItem("GUITratamento");
        JMenuItem cliente = new JMenuItem("GUICliente");
        JMenuItem tipo = new JMenuItem("GUITipoTratamento");
       

        fileMenu.add(tratamento);
   
        fileMenu.addSeparator();
        fileMenu2.add(cliente);
        fileMenu.addSeparator();
        fileMenu3.add(tipo);
        fileMenu3.addSeparator();
        setVisible(true);
        
        tratamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUITratamento guiTratamento = new GUITratamento();
            }
        });
        cliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUICliente guiCliente = new GUICliente();
            }
        });
         tipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUITipoTratamento guiTipoTratamento = new GUITipoTratamento();
            }
        });
        CentroDoMonitorMaior centroDoMonitorMaior = new CentroDoMonitorMaior();
        setLocation(centroDoMonitorMaior.getCentroMonitorMaior(this));
    }
}
