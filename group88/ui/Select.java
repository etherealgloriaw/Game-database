package group88.ui;

import group88.delegates.OperationsDelegate;
import group88.tables.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Select {
    static JTextField givenage, givendate,givencuid;
    private OperationsDelegate delegate = null;
    public void showframe(OperationsDelegate delegate) {
        this.delegate = delegate;
        JFrame frame = new JFrame("Select");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        FlowLayout fl = new FlowLayout(FlowLayout.LEFT, 20, 40);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setBackground(Color.pink);
        JLabel lbl = new JLabel("Please select one from these conditions");
        lbl.setVisible(true);
        frame.setVisible(true);
        panel.add(lbl);
        panel.setLayout(fl);

        JButton opt1 = new JButton("Select games which rate is greater than 4");
        panel.add(opt1);
        opt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                List<Game> log = delegate.viewGames();
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
                for (Game model : log) {
                    textArea.append(model.getGameID()+ " ");
                    textArea.append(model.getGameName()+ " ");
                    textArea.append(model.getRate()+ " ");
                    textArea.append(model.getVersion() + "\n");
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
        JButton btn1 = new JButton("quit");
        panel.add(btn1);
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                frame.dispose();
            }
        });
    }
}
