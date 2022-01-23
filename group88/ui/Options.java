package group88.ui;

import group88.delegates.OperationsDelegate;

import javax.swing.*;
import java.awt.event.*;
import java.util.Objects;

public class Options{
    private OperationsDelegate delegate;
    private static final String[] choices = {"Insert", "Delete", "Select", "Update","Show","Projection","Join","Aggregation",
            "Nested_Aggregation","Division","Quit"};
    public Options(){
    }
    public void main(OperationsDelegate delegate) {
        this.delegate = delegate;
        JFrame frame = new JFrame("Options");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 150);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        frame.add(panel);

        JLabel lbl = new JLabel("Select one of the options and click OK");
        JLabel lbl1 = new JLabel("Please click OK if you finished, never click exit");
        lbl.setVisible(true);

        panel.add(lbl);
        panel.add(lbl1);
        final JComboBox<String> cb = new JComboBox<String>(choices);

        panel.add(cb);
        JButton btn = new JButton("OK");
        panel.add(btn);
        btn.setVisible(true);
        frame.setVisible(true);
        cb.setVisible(true);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String option = Objects.requireNonNull(cb.getSelectedItem()).toString();
                if (option.equals("Quit")){
                    frame.dispose();
                }else if (option.equals("Insert")){
                    Insert insert = new Insert();
                    insert.showframe(delegate);
                }
                else if (option.equals("Delete")){
                    Delete delete = new Delete();
                    delete.showframe(delegate);
                }
                else if (option.equals("Select")){
                    Select select = new Select();
                    select.showframe(delegate);
                }
                else if (option.equals("Update")){
                    Update update = new Update();
                    update.showframe(delegate);
                }else if (option.equals("Show")){
                    Show show = new Show();
                    show.showframe(delegate);
                }else if (option.equals("Projection")){
                    Projection projection = new Projection();
                    projection.showframe(delegate);
                }else if (option.equals("Join")){
                    Join join = new Join();
                    join.showframe(delegate);
                }else if (option.equals("Aggregation")){
                    Aggregation aggregation = new Aggregation();
                    aggregation.showframe(delegate);
                }else if (option.equals("Nested_Aggregation")){
                    Nested_Aggregation nested_aggregation = new Nested_Aggregation();
                    nested_aggregation.showframe(delegate);
                }else if (option.equals("Division")){
                    Division division = new Division();
                    division.showframe(delegate);
                }else{
                    frame.dispose();
                }
            }
        });
    }
}
