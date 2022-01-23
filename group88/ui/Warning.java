package group88.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Warning {
    public void showframe(){
        JFrame frame = new JFrame("Warning");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        FlowLayout fl = new FlowLayout(FlowLayout.LEFT, 20, 40);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setBackground(Color.gray);
        JLabel lbl = new JLabel("The id(s) are dulplicate/missing, please change one");
        lbl.setVisible(true);
        panel.add(lbl);
        panel.setLayout(fl);

        JButton btn = new JButton("OK");


        panel.add(btn);
        btn.setVisible(true);
        frame.setVisible(true);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // show the tables(windows)
                frame.dispose();
            }
        });
    }
}
