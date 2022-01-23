package group88.ui;

import group88.delegates.OperationsDelegate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Division {
    private OperationsDelegate delegate;
    public void showframe(OperationsDelegate delegate) {
        this.delegate = delegate;
        JFrame frame = new JFrame("Division");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        FlowLayout fl = new FlowLayout(FlowLayout.LEFT, 20, 40);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setBackground(Color.gray);

        frame.setVisible(true);
        panel.setLayout(fl);


        JButton opt1 = new JButton("find players had got every achievement");


        panel.add(opt1);
        JButton btn = new JButton("quit");
        panel.add(btn);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                frame.dispose();
            }
        });

        opt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                JFrame frame = new JFrame("Division");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500, 300);
                frame.setLocationRelativeTo(null);
                FlowLayout fl = new FlowLayout(FlowLayout.LEFT, 20, 40);
                JPanel panel = new JPanel();
                frame.add(panel);
                panel.setBackground(Color.lightGray);
                List<String> logc = delegate.viewUsersWithFullAcheivement();
                JTextArea textArea = new JTextArea();
                textArea.setBackground(Color.lightGray);
                for(String a : logc){
                    textArea.append(a + "\n");
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
