package group88.ui;

import group88.delegates.OperationsDelegate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Delete{
    static JTextField jtf1,jtf2,jtf3;
    private OperationsDelegate delegate;
    public void showframe(OperationsDelegate delegate) {
        this.delegate = delegate;
        JFrame frame = new JFrame("Delete");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        FlowLayout fl = new FlowLayout(FlowLayout.LEFT, 20, 40);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setBackground(Color.red);
        JLabel lbl = new JLabel("Please insert the following info and click OK");
        lbl.setVisible(true);
        panel.add(lbl);
        panel.setLayout(fl);
        JLabel userid = new JLabel("User ID");
        jtf1 = new JTextField(10);
        jtf1.setText("U+userID");
        JLabel communityId = new JLabel("Community ID");
        jtf2 = new JTextField(10);
        jtf2.setText("c+communityID");
        JLabel commentID = new JLabel("CommentID");
        jtf3 = new JTextField(10);
        jtf3.setText("cO+commentID");

        JButton btn = new JButton("OK");

        panel.add(userid);
        panel.add(jtf1);
        panel.add(communityId);
        panel.add(jtf2);
        panel.add(commentID);
        panel.add(jtf3);

        panel.add(btn);
        btn.setVisible(true);
        frame.setVisible(true);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    if (delegate.deleteComment(jtf1.getText(), jtf2.getText(), jtf3.getText())) {
                        String name = JOptionPane.showInputDialog(frame,
                                "Delete Successfully!", null);
                        frame.dispose();
                    } else{
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
