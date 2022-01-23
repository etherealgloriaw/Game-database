package group88.ui;

import group88.delegates.OperationsDelegate;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class Aggregation {
    static JTextField jtf1;
    private OperationsDelegate delegate;
    public void showframe(OperationsDelegate delegate) {
        this.delegate = delegate;
        JFrame frame = new JFrame("Aggregation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        FlowLayout fl = new FlowLayout(FlowLayout.LEFT, 20, 40);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setBackground(Color.gray);
        JLabel lbl = new JLabel("Please select one from these choices");
        lbl.setVisible(true);
        frame.setVisible(true);
        panel.add(lbl);
        panel.setLayout(fl);


        JButton opt1 = new JButton("find the active user(comments>10) in a given community, ordered by DESC");
        JButton opt2 = new JButton("find the highest age in each game, where the collectionRate must be greater than 50%");


        panel.add(opt1);
        panel.add(opt2);
        opt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                ActiveUsers();
                frame.dispose();
            }
        });
        opt2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                JFrame frame = new JFrame("Aggregation");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500, 300);
                frame.setLocationRelativeTo(null);
                FlowLayout fl = new FlowLayout(FlowLayout.LEFT, 20, 40);
                JPanel panel = new JPanel();
                frame.add(panel);
                panel.setBackground(Color.lightGray);
                List<String[]> logc = delegate.gethighestageineachGame();
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

    public void ActiveUsers() {
        JFrame frame = new JFrame("Aggregation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        FlowLayout fl = new FlowLayout(FlowLayout.LEFT, 20, 40);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setBackground(Color.pink);
        JLabel lbl = new JLabel("find the active user(comments>10) in a given community, ordered by DESC");
        lbl.setVisible(true);
        panel.add(lbl);
        panel.setLayout(fl);
        JLabel communityID = new JLabel("CommunityID");
        jtf1 = new JTextField(10);
        jtf1.setText("c + communityID");

        JButton btn = new JButton("OK");

        panel.add(communityID);
        panel.add(jtf1);
        panel.add(btn);
        btn.setVisible(true);
        frame.setVisible(true);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                JFrame frame = new JFrame("Aggregation");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500, 300);
                frame.setLocationRelativeTo(null);
                FlowLayout fl = new FlowLayout(FlowLayout.LEFT, 20, 40);
                JPanel panel = new JPanel();
                frame.add(panel);
                panel.setBackground(Color.lightGray);
                String cID = jtf1.getText();
                List<String> result = delegate.viewActiveUsers(cID);
                JTextArea textArea = new JTextArea();
                textArea.setBackground(Color.lightGray);
                for(String a : result){
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
                if (result.size() == 0) {
                    String name = JOptionPane.showInputDialog(frame,
                            "No such User", null);
                    frame.dispose();
                }

            }
        });
        JButton btn1 = new JButton("quit");
        panel.add(btn1);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                frame.dispose();
            }
        });
    }
}
