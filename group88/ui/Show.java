package group88.ui;
import group88.delegates.OperationsDelegate;
import group88.tables.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Show {
    private OperationsDelegate delegate = null;
    public void showframe(OperationsDelegate delegate) {
        this.delegate = delegate;
        JFrame frame = new JFrame("Show");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        FlowLayout fl = new FlowLayout(FlowLayout.LEFT, 20, 40);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setBackground(Color.gray);
        JLabel lbl = new JLabel("Please select one from these conditions");
        lbl.setVisible(true);
        frame.setVisible(true);
        panel.add(lbl);
        panel.setLayout(fl);


        JButton opt1 = new JButton("Users");
        JButton opt2 = new JButton("GameRecord");
        JButton opt3 = new JButton("MakeComment");
        JButton opt4 = new JButton("SellGame");


        panel.add(opt1);
        panel.add(opt2);
        panel.add(opt3);
        panel.add(opt4);
        opt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                List<User> lou = delegate.viewUsers();
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
                for (User model : lou) {
                    textArea.append(model.getUserID()+ " ");
                    textArea.append(model.getAccountBalance()+ " ");
                    textArea.append(model.getAge() + "\n");
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
        opt2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                List<GameRecord> logc = delegate.viewGameRecord();
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
                for (GameRecord model : logc) {
                    textArea.append(model.getGameID() + " ");
                    textArea.append(model.getUserID()+ " ");
                    textArea.append(model.getRecordID()+ " ");
                    textArea.append(model.getDate() + "\n");
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
        opt3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                List<MakeComment> lomc = delegate.viewComments();
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
                for (MakeComment model : lomc) {
                    textArea.append(model.getUserID() + " ");
                    textArea.append(model.getCommunityID()+ " ");
                    textArea.append(model.getCommentID()+ " ");
                    textArea.append(model.getComment() + "\n");
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
        opt4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                List<SellGame> losg = delegate.viewSellGame();
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
                for (SellGame model : losg) {
                    textArea.append(model.getGameID() + " ");
                    textArea.append(model.getHubID()+ " ");
                    textArea.append(model.getPrice()+ "\n");
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
