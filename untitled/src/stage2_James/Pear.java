/*JavaParadiseGUI.java will have list of PC, customers, and bookings
 *It will be organized as tabbed pane
 */
package stage2_James;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.time.*;
import java.io.*;
/**
 * main page
 */
public class Pear extends JFrame implements ActionListener{

    ArrayList<PC> PC ;
    ArrayList<Customer> customers ;
    ArrayList<Booking> bookings ;
    //for PCTab
    JButton btnRList, btnRClear;
    JTextArea jtaR;
    // for customersTab
    JButton btnCAdd, btnCList, btnCClear;
    JTextArea jtaC;
    JLabel lblName;
    JTextField txtName;

    Customer cfound, cfoundb = null;
    PC rfound = null;
    Booking bfound = null;
    //constructor
    public  Pear(){
        PC = new ArrayList<PC>();
        customers = new ArrayList<Customer>();


        //components for tabbed panel
        JTabbedPane tabs = new JTabbedPane();
        JPanel PCTab = new JPanel();
        JPanel customersTab = new JPanel();


        //components for PCTab
        //__________________________________________
        JPanel displayRPanel = new JPanel();
        JPanel buttonRPanel = new JPanel();
        //for PCTab display
        jtaR = new JTextArea(30, 50);
        JScrollPane scrollR = new JScrollPane(jtaR, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        //for PCTab button panel
        btnRList = new JButton("List PC");
        btnRClear = new JButton("Clear display");
        //_________________________________________
        //components for customerTab
        JPanel inputCPanel = new JPanel();
        JPanel displayCPanel = new JPanel();
        JPanel buttonCPanel = new JPanel();
        inputCPanel.setLayout(new GridLayout(2,1));
        inputCPanel.setBorder(new EmptyBorder(30,30,30,30));
        lblName = new JLabel("      Enter name");
        txtName = new JTextField(10);
        btnCAdd = new JButton("Add customer");
        btnCList = new JButton("List customers");
        btnCClear = new JButton("Clear");
        jtaC = new JTextArea(30, 50);
        jtaC.setBorder(new TitledBorder("List of customers"));
        //______________________________________________



        //build tabs
        //add tabbed pane to center
        add(tabs, BorderLayout.CENTER);
        //add tab panels to it
        tabs.addTab("PC", PCTab);
        tabs.addTab("Customers", customersTab);
        //tabs.addTab("Bookings", bookingsTab);
        //tabs.addTab("Checkout", checkoutTab);

        //_______________________________________
        //build PCTab
        PCTab.setLayout(new BorderLayout());
        PCTab.add(displayRPanel, BorderLayout.CENTER);
        PCTab.add(buttonRPanel, BorderLayout.SOUTH);
        jtaR.setBorder(new TitledBorder("List of PC"));
        btnRList.addActionListener(this);
        btnRClear.addActionListener(this);
        buttonRPanel.add(btnRList);
        buttonRPanel.add(btnRClear);
        displayRPanel.add(scrollR);
        //_________________________________________________
        //build customersTab
        customersTab.setLayout(new BorderLayout());
        customersTab.add(inputCPanel, BorderLayout.NORTH);
        customersTab.add(displayCPanel, BorderLayout.CENTER);
        customersTab.add(buttonCPanel, BorderLayout.SOUTH);
        inputCPanel.setLayout(new GridLayout(1, 2));
        inputCPanel.setBorder(new EmptyBorder(30,30,30,30));
        inputCPanel.add(lblName);
        inputCPanel.add(txtName);
        //build button panel
        btnCAdd.addActionListener(this);
        btnCList.addActionListener(this);
        btnCClear.addActionListener(this);
        buttonCPanel.add(btnCAdd);
        buttonCPanel.add(btnCList);
        buttonCPanel.add(btnCClear);
        displayCPanel.add(jtaC);
        //______________________________________________
        //build bookingsTab
        JPanel displayBPanel = new JPanel();
        JPanel buttonBPanel = new JPanel();
        //buttonBPanel.setLayout(new GridLayout(1,2, 20, 20));


        //pnlPaymentOpt

    }

    /**
     * to populate the initial list
     */
    public void populateLists(){
        PC[] arrOfPC = {new PC("Gaming"), new PC("Office"),new PC("Media Consumption")};
        Customer[] arrOfCustomers = {new Customer("James"),
                new Customer("Elijah"), new Customer("John")};

        for(int i = 0; i < arrOfPC.length; i++){
            arrOfPC[i].setTotalPrice(arrOfPC[i].getType());
            PC.add(arrOfPC[i]);
        }
        for(int i = 0; i < arrOfCustomers.length; i++)
            customers.add(arrOfCustomers[i]);
        //System.out.println(PC.toString());

        rfound = searchPCByPCNo(2);

    }
    public static void main(String[] args){
        Pear jp = new Pear();
        jp.populateLists();
        //set up frame
        jp.setSize(600, 550);
        jp.setLocationRelativeTo(null);
        jp.setVisible(true);

    }
    public void displayAllPCs() {
        for (PC r:PC) {
            System.out.println(r);
        }
    }


    public void addCustomer() {
        String name = txtName.getText();
        Customer c = new Customer(name);
        customers.add(c);
    }

    public void listCustomers() {
        for (Customer c:customers) {
            System.out.println(c);
        }
    }

    /**
     * to look for the customer by their id
     * @param id
     * @return
     */
    public Customer searchCustomerById(int id) {

        for (Customer c:customers) {
            if (c.getCustId() == id)
                return c;
        }
        return null;
    }

    /**
     *
     * @param PCNo
     * @return
     * to get the pcNo
     */
    public PC searchPCByPCNo(int PCNo){
        for(PC r: PC){
            if(r.getPCNo() == PCNo)
                return r;
        }
        return null;
    }






    public void actionPerformed(ActionEvent e){

        if(e.getSource()==btnRList){
            jtaR.setText("");
            for(PC r: PC){
                System.out.println(r);
                jtaR.append("\n" + r.toString() + "\n");
            }
        }
        if(e.getSource() == btnCList){
            jtaC.setText("");
            for(Customer c: customers){
                jtaC.append("\n"+ c.toString() + "\n");
            }
        }

        if(e.getSource()==btnRClear){
            jtaR.setText("");
        }
        if(e.getSource() == btnCClear){
            jtaC.setText("");

        }
        if(e.getSource()==btnCAdd){
            int options = JOptionPane.showOptionDialog(
                    null,
                    "Are you sure you want to add that name into the system?",
                    "Adding a customer",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    null,
                    0);
            if (options ==0){
                addCustomer();
                JOptionPane.showMessageDialog(null, "That name has been added to the system");
            }else{
                ;
            }

        }


    }
}


