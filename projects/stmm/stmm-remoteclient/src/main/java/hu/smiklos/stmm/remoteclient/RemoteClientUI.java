package hu.smiklos.stmm.remoteclient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by SebestyenMiklos on 2017. 05. 04..
 */
public class RemoteClientUI implements Runnable, ActionListener {

    private JPanel northPanel;
    private JPanel centerPanel;
    private JFrame frame;
    private JPanel mainPanel;

    public RemoteClientUI() {
        frame = new JFrame("Remote loan query");
        mainPanel = new JPanel();
        northPanel = new JPanel();
        centerPanel = new JPanel();
    }

    public void init(Object remoteEjb)  {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(640,480));
        this.addFrameElements();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(northPanel,BorderLayout.NORTH);
        mainPanel.add(centerPanel,BorderLayout.CENTER);
        frame.add(mainPanel);
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    @Override
    public void run() {

    }

    private void addFrameElements()  {
        addInputFieldsToFrame();
        addButtonToFrame();
        addListToFrame();
    }

    private void addInputFieldsToFrame()  {
        JLabel durationFromLabel = new JLabel("from: ");
        JLabel durationToLabel= new JLabel("to: ");
        JTextField fromField = new JTextField(5);
        JTextField toField = new JTextField(5);
        String[] repaymentTypes= {"M", "W"};
        JComboBox paymentType = new JComboBox(repaymentTypes);
        JLabel label = new JLabel("RepaymentType: ");

        northPanel.add(label);
        northPanel.add(paymentType);
        northPanel.add(durationFromLabel);
        northPanel.add(fromField);
        northPanel.add(durationToLabel);
        northPanel.add(toField);

    }

    private void addButtonToFrame()  {
        JButton button = new JButton();
        button.setText("Search");
        northPanel.add(button);

    }

    private void addListToFrame()  {
        String[] data = {"egy", "kettő", "Három"};
        JList list = new JList(data);
        //list.setSize(new Dimension(500,500));
        centerPanel.add(list);

    }

}
