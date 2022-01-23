package group88.ui;

import group88.delegates.OperationsDelegate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class Projection {
    static JTextField jtf1;
    private OperationsDelegate delegate = null;
    public void showframe(OperationsDelegate delegate) {
        this.delegate = delegate;
        JFrame frame = new JFrame("Projection");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        FlowLayout fl = new FlowLayout(FlowLayout.LEFT, 20, 40);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setBackground(Color.green);
        JLabel lbl = new JLabel("sort the released games after the given date by rate(show game id & name)");
        lbl.setVisible(true);
        panel.add(lbl);
        panel.setLayout(fl);
        JLabel year = new JLabel("Year");
        jtf1 = new JTextField(10);
        jtf1.setText("1999");

        JButton btn = new JButton("OK");

        panel.add(year);
        panel.add(jtf1);
        JButton btn1 = new JButton("quit");
        panel.add(btn1);
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                frame.dispose();
            }
        });

        panel.add(btn);
        btn.setVisible(true);
        frame.setVisible(true);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String year = jtf1.getText();
                ArrayList<String[]> result = (ArrayList<String[]>) delegate.sortGameofInputYear(year);
                if (result == null) {
                    Warning warnning = new Warning();
                    warnning.showframe();
                } else {
                    JFrame frame = new JFrame("Projection");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(500, 300);
                    frame.setLocationRelativeTo(null);
                    FlowLayout fl = new FlowLayout(FlowLayout.LEFT, 20, 40);
                    JPanel panel = new JPanel();
                    frame.add(panel);
                    panel.setBackground(Color.lightGray);
                    String gID = jtf1.getText();
                    JTextArea textArea = new JTextArea();
                    textArea.setBackground(Color.lightGray);
                    for(String[] a : result){
                        textArea.append(Arrays.toString(a) + "\n");
                    }
                    textArea.setBounds(10, 79, 172, 339);
                    panel.add(textArea);
                    panel.setLayout(fl);
                    frame.setVisible(true);
                    JButton btn = new JButton("OK");
                    panel.add(btn);
                    btn.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e){
                            frame.dispose();
                        }
                    });
                }
            }
        });
    }
}
