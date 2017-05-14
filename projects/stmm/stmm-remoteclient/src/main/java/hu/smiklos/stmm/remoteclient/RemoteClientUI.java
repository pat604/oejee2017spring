package hu.smiklos.stmm.remoteclient;

import hu.smiklos.stmm.remotelibrary.LoanOffersRemoteBean;
import hu.smiklos.stmm.remotelibrary.entity.LoanOfferRemote;
import hu.smiklos.stmm.remotelibrary.exception.ServiceException;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by SebestyenMiklos on 2017. 05. 04..
 */
public class RemoteClientUI implements Runnable, ActionListener {

    private static final Logger LOGGER = Logger.getLogger(RemoteClientUI.class);

    private JPanel northPanel;
    private JPanel centerPanel;
    private JFrame frame;
    private JPanel mainPanel;
    private LoanOffersRemoteBean remoteEjb;

    JLabel durationFromLabel;
    JLabel durationToLabel;
    JTextField fromField ;
    JTextField toField;
    String[] repaymentTypes= {"M", "W"};
    JLabel label;
    JList list;

    public RemoteClientUI(LoanOffersRemoteBean remoteBean) {
        this.remoteEjb = remoteBean;
        frame = new JFrame("Remote loan query");
        mainPanel = new JPanel();
        northPanel = new JPanel();
        centerPanel = new JPanel();
    }

    public void init()  {


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
    public void run() {

    }

    private void addFrameElements()  {
        addInputFieldsToFrame();
        addButtonToFrame();
        addListToFrame();
    }

    private void addInputFieldsToFrame()  {
         durationFromLabel = new JLabel("from: ");
         durationToLabel= new JLabel("to: ");
         fromField = new JTextField(5);
         toField = new JTextField(5);

        JComboBox paymentType = new JComboBox(repaymentTypes);
        label = new JLabel("RepaymentType: ");

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
        button.addActionListener(this);


    }
    public void actionPerformed(ActionEvent e)
    {
        try {
            if(remoteEjb != null) {
                LOGGER.info(remoteEjb);
                LoanOfferRemote[] offers = remoteEjb.getOffers("M", "1", "12");
            }
        } catch (ServiceException e1) {
            e1.printStackTrace();
        }
    }



    private void addListToFrame()  {
        String[] data = {"egy", "kettő", "Három"};
         list = new JList(data);
        //list.setSize(new Dimension(500,500));
        centerPanel.add(list);

    }

}
