
package Project;
import javax.swing.*; //needed for Swing classes
import java.awt.event.* ;//needed for ActionListener interface
import java.awt.* ;

   
public class Bill extends JFrame {

   private JPanel panel,p1 ;
   


   private JButton issueButton  ;

   private JButton issueButton1  ;
   
   private final int WINDOW_WIDTH = 450 ; 
   private final int WINDOW_HEIGHT = 250 ;
   public Bill() {
	   
	      setTitle("Parking Ticket Simulator") ;

	      setSize(WINDOW_WIDTH, WINDOW_HEIGHT) ;
	     
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
	     
	      buildPanel() ;
	     
	      add(panel) ;
	     
	      setVisible(true) ;
	   }
  

   private void buildPanel() {
   

      issueButton = new JButton("Ticket For Car") ;
     
      issueButton1 = new JButton("Tickect For Bike") ;
      
      issueButton.addActionListener(new IssueButtonListener() ) ;

      issueButton1.addActionListener(new IssueButtonListener1());
      panel = new JPanel() ;

      p1=new JPanel();
     
      panel.setBackground(Color.DARK_GRAY);
     
      
      panel=new JPanel();
      panel.add(new JLabel("WELCOME"));
      add(panel,BorderLayout.CENTER);
           

      p1.add(issueButton) ;
      p1.add(issueButton1);
     add(p1,BorderLayout.SOUTH);
     
     
   }
   
   
   
   private class IssueButtonListener implements ActionListener {
   
      public void actionPerformed(ActionEvent e) {
     
                 new Car().setVisible(true);     
      }
   }           
   private class IssueButtonListener1 implements ActionListener {
	   
	      public void actionPerformed(ActionEvent e) {
	     
	                 new Bike().setVisible(true);     
	      }
	   }           
   public static void main (String[] args) {
   
      new Bill() ;
     
   }
}