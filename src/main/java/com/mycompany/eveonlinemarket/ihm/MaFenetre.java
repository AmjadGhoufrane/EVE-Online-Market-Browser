package com.mycompany.eveonlinemarket.ihm;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;


public class MaFenetre extends JFrame{



    public MaFenetre() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initialisationVue();

    }

    private void initialisationVue() {
        JPanel pan = new JPanel();

        pan.setLayout(new GridBagLayout());
        GridBagConstraints cont = new GridBagConstraints();

        cont.fill = GridBagConstraints.BOTH;


        this.setContentPane(pan);
        this.pack();

    }

}

