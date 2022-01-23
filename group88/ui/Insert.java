package group88.ui;


import group88.delegates.OperationsDelegate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Insert{
    static JTextField jtf1,jtf2;
    private OperationsDelegate delegate;

    public void showframe(OperationsDelegate delegate) {
        this.delegate = delegate;
        JFrame frame = new JFrame("Insert");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        FlowLayout fl = new FlowLayout(FlowLayout.LEFT, 20, 40);
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setBackground(Color.green);
        JLabel lbl = new JLabel("GameRecord: Please insert the following info and click OK");
        lbl.setVisible(true);
        panel.add(lbl);
        panel.setLayout(fl);
        JLabel gameid = new JLabel("GameID");
        jtf1 = new JTextField(10);
        jtf1.setText("G+gameID");
        JLabel gamename = new JLabel("UserID");
        jtf2 = new JTextField(10);
        jtf2.setText("U+userID");

        JButton btn = new JButton("OK");

        panel.add(gameid);
        panel.add(jtf1);
        panel.add(gamename);
        panel.add(jtf2);
        panel.add(btn);
        btn.setVisible(true);
        frame.setVisible(true);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String gid = jtf1.getText();
                String uid = jtf2.getText();
                try {
                    if (delegate.addGameRecords(gid,uid)) {
                        String name = JOptionPane.showInputDialog(frame,
                                "Insert Successfully!", null);
                        frame.dispose();
                    }else{
                Warning warnning = new Warning();
                warnning.showframe();
            }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                frame.dispose();
            }
        });
    }
}
