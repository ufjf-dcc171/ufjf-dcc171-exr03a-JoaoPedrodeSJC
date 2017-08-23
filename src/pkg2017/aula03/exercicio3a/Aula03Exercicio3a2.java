/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2017.aula03.exercicio3a;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Aula03Exercicio3a2 extends JFrame{
    
    private final JLabel saida1,saida2,saida3,saida4;
    private final JTextField entrada1,entrada2,entrada3;
    private final JButton botao = new JButton("calcular Raizes");
    public Aula03Exercicio3a2() throws HeadlessException
    {
        super("Raizes da equação de segundo grau");
        setLayout(new FlowLayout(FlowLayout.LEFT));
        saida1 = new JLabel("A=");
        saida2 = new JLabel("B=");
        saida3 = new JLabel("C=");
        saida4 = new JLabel("");
        entrada1 = new JTextField(5);
        entrada2 = new JTextField(5);
        entrada3 = new JTextField(5);
        add(saida1);
        add(entrada1);
        add(saida2);
        add(entrada2);
        add(saida3);
        add(entrada3);
        add(botao);  
        add(saida4);     
        botao.addActionListener(new Raizes());
    }

    private class Raizes implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e){
            try
            {
                double a,b,c,delta,raiz1,raiz2;
                a = Double.parseDouble(entrada1.getText());
                b = Double.parseDouble(entrada2.getText());
                c = Double.parseDouble(entrada3.getText());
                delta = (Math.pow(b, 2)) - 4*a*c;
                if(delta > 0)
                {
                    raiz1 = (Math.sqrt(delta)-b)/(2*a);
                    raiz2 = -(Math.sqrt(delta)+b)/(2*a);
                    saida4.setText("Delta = " + delta + " raiz1 = " + raiz1 + "raiz2 = " + raiz2);
                }
                else if (0 == delta)
                {
                    raiz1 = (-b)/(2*a);
                    saida4.setText("Delta = " + delta + " raiz = " + raiz1);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Delta menor que 0","ERRO", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch(NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(null,"Valor digitado não é um número","ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
