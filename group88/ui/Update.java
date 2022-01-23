package group88.ui;

import group88.delegates.OperationsDelegate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Update {
    static JTextField jtf1,jtf2,jtf3;
    private OperationsDelegate delegate = null;
    public void showframe(OperationsDelegate delegate) {
        this.delegate = delegate;
        JFrame frame = new JFrame("Update");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        FlowLayout fl = new FlowLayout(FlowLayout.LEFT, 20, 40);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setBackground(Color.magenta);
        JLabel lbl = new JLabel("Please insert the following info and click OK");
        lbl.setVisible(true);
        panel.add(lbl);
        panel.setLayout(fl);
        JLabel gameid = new JLabel("GameID");
        jtf1 = new JTextField(10);
        jtf1.setText("G+gameID");
        JLabel gamename = new JLabel("Hub ID");
        jtf2 = new JTextField(10);
        jtf2.setText("H+hubID");
        JLabel gamerate = new JLabel("new Game price");
        jtf3 = new JTextField(10);
        jtf3.setText("123");


        JButton btn = new JButton("OK");

        panel.add(gameid);
        panel.add(jtf1);
        panel.add(gamename);
        panel.add(jtf2);
        panel.add(gamerate);
        panel.add(jtf3);
        panel.add(btn);
        btn.setVisible(true);
        frame.setVisible(true);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    if (delegate.updatePrice(jtf1.getText(),jtf2.getText(),(jtf3.getText())))
                    {String name = JOptionPane.showInputDialog(frame,
                            "Update Successfully!", null);
                        frame.dispose();
                    }
                    else{
                        Warning warnning = new Warning();
                        warnning.showframe();

                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }

}
