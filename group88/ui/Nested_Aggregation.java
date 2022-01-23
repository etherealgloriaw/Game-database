package group88.ui;
import group88.delegates.OperationsDelegate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class Nested_Aggregation {
    private OperationsDelegate delegate;
    public void showframe(OperationsDelegate delegate) {
        this.delegate = delegate;
        JFrame frame = new JFrame("Nested_Aggregation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        FlowLayout fl = new FlowLayout(FlowLayout.LEFT, 20, 40);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setBackground(Color.gray);

        frame.setVisible(true);
        panel.setLayout(fl);

        JButton opt1 = new JButton("finding the earlist developed game of each gameCompany, given that the price of game is not 0, which means it's not a demo.");


        panel.add(opt1);
        JButton btn1 = new JButton("quit");
        panel.add(btn1);
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                frame.dispose();
            }
        });

        opt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                List<String[]> logc = delegate.getearlistdevelopedGame();
                JFrame frame = new JFrame("Aggregation");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500, 300);
                frame.setLocationRelativeTo(null);
                FlowLayout fl = new FlowLayout(FlowLayout.LEFT, 20, 40);
                JPanel panel = new JPanel();
                frame.add(panel);
                panel.setBackground(Color.lightGray);
                JTextArea textArea = new JTextArea();
                textArea.setBackground(Color.lightGray);
                for(String[] a : logc){
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
        });
    }
}
