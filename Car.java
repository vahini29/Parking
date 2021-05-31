package Sampleprogram;
import javax.swing.*; //needed for Swing classes
import java.awt.event.* ;//needed for ActionListener interface
import java.awt.* ;

   
public class Car extends JFrame {

   private JPanel panel ;
   private JLabel messageLabel1 ;
   private JLabel messageLabel2 ;
   private JLabel messageLabel4 ;
   private JLabel messageLabel5 ;
   private JLabel messageLabel6 ;
   private JLabel messageLabel7 ;

    JTextField textField1 ;
    JTextField textField2 ;
    JTextField textField3 ;
    JTextField textField4 ;
    JTextField textField5 ;
    JTextField textField6 ;
    JTextField textField7 ;
    JTextField textField8 ;
    JTextField textField9;
    JTextField textField10;

   private JButton issueButton  ;
   
   private final int WINDOW_WIDTH = 380 ; 
   private final int WINDOW_HEIGHT = 400 ;

   public Car() {
   
      setTitle("Parking Ticket Simulator") ;

      setSize(WINDOW_WIDTH, WINDOW_HEIGHT) ;
     
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
     
      buildPanel() ;
     
      add(panel) ;
     
      setVisible(true) ;
   }
 
  public static double billAmount(double minu) {
      double INITIAL_BILL = 25 ;
      double AMOUNT_EXTRA_HOUR = 10 ;
     double amount = 0 ;
     
      amount = INITIAL_BILL ;
      amount = amount+(minu * AMOUNT_EXTRA_HOUR) ;
       
      return amount ;
   }

  

   private void buildPanel() {
   
      messageLabel1 = new JLabel("Enter the make " +
                                " of the car: ") ;
     
      messageLabel2 = new JLabel("Enter the model " +
                                " of the car: ") ;
      messageLabel4 = new JLabel("Enter the license " +
                                " number of the car: ") ;
      messageLabel5 = new JLabel("Enter the entry time of car (24hrs)") ;
      messageLabel6 = new JLabel("Enter time that return time of car (24)") ;
      messageLabel7= new JLabel("Intial parking fee");
      
      textField1 = new JTextField(10) ;
      textField2 = new JTextField(10) ;
      textField3 = new JTextField(10) ;
      textField4 = new JTextField(10) ;
      textField5 = new JTextField(10) ;
      textField6 = new JTextField(10) ;
      textField7 = new JTextField(10) ;
      textField8 =new JTextField("default text");
      
      textField7.setText("25");
      issueButton = new JButton("Issue the ticket") ;
     
      issueButton.addActionListener(new IssueButtonListener() ) ;

      panel = new JPanel() ;

      panel.setBackground(Color.cyan) ;

      panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS) ) ;

      panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Parking Ticket") ) ;

      panel.add(messageLabel1) ;
      panel.add(textField1) ;
     
      panel.add(messageLabel2) ;
      panel.add(textField2) ;

      panel.add(messageLabel4) ;
      panel.add(textField4) ;
     
      panel.add(messageLabel5) ;
      panel.add(textField5) ;

      panel.add(messageLabel6) ;
      panel.add(textField6) ;

      panel.add(messageLabel7);
      panel.add(textField7);
      
      panel.add(issueButton) ;
   
   }
   
   
   private class IssueButtonListener implements ActionListener {
   
      public void actionPerformed(ActionEvent e) {
     
      panel.setVisible(false) ;
     
      JPanel panelPrint ;
      JLabel make ;
      JLabel model ;
      JLabel license ;
      JLabel entryTime ;
      JLabel parkedMinutes;
      JLabel minutes ;
      JLabel minutes2 ;
      JLabel intialFee;
      double    unPaidMin ;
         
      textField7.setText("25");
      final int WINDOW_WIDTH  = 350 ; 
      final int WINDOW_HEIGHT = 220 ;
      make             = new JLabel("The model of the car is: " + textField1.getText() ) ;
      model            = new JLabel("The make of the car is: "  + textField2.getText() ) ;
      license          = new JLabel("The license number is: "   + textField4.getText() ) ;
      parkedMinutes    = new JLabel("The car is enterd at time " + textField5.getText() + " hours " ) ;
      entryTime = new JLabel("There car is retuned at time " + textField6.getText() + " hours " ) ;
      intialFee =new JLabel("minimum parking fee:"+textField7.getText());
      unPaidMin = Double.parseDouble(textField6.getText()) - Double.parseDouble(textField5.getText()) ;
     
            
      panelPrint = new JPanel() ;

      panelPrint.setBackground(Color.YELLOW) ;

      panelPrint.setLayout(new BoxLayout(panelPrint, BoxLayout.Y_AXIS) ) ;

      panelPrint.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Parking Ticket") ) ;

      panelPrint.add(make) ;
      panelPrint.add(model) ;
      
      panelPrint.add(license) ;
     
      panelPrint.add(entryTime) ;
      panelPrint.add(parkedMinutes) ;

      panelPrint.add(intialFee);
     
     
      if (unPaidMin >0)  {  
         minutes = new JLabel(" The car has been parked for " + unPaidMin + " hours " ) ;
         minutes2 = new JLabel(" The amount of fine is " + billAmount(unPaidMin) + " rupees " ) ;
     
         panelPrint.add(minutes) ;
         panelPrint.add(minutes2) ;
      }
      else
      {
         JLabel ok = new JLabel("The time should be enterd in 24hrs or u have enterd wrong time") ;
         panelPrint.add(ok) ;
      }

      setTitle("Parking Ticket") ;

      setSize(WINDOW_WIDTH, WINDOW_HEIGHT) ;

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;

      add(panelPrint) ;

      setVisible(true) ;
      }
   }              
   public static void main (String[] args) {
   
      new Car() ;
     
   }
}