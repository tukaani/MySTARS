import java.util.*;
import javax.mail.*; // think you need a extra thing on computer to run
import javax.mail.internet.*; // same as above
import javax.activation.*;

public class SendEmail {

   public static void main(String [] args) {    
      // Recipient's email ID needs to be mentioned.
      String to  ; //need to get student's email

      // Sender's email ID needs to be mentioned
      String from = "web@ntu.edu.sg";

      // Assuming you are sending email from localhost
      // What is this?
      String host = "localhost";

      // Get system properties
      Properties properties = System.getProperties();

      // Setup mail server
      properties.setProperty("mail.smtp.host", host);

      // Get the default Session object.
      Session session = Session.getDefaultInstance(properties);
      
      String courseCode ;//need to get coursecode

      try {
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("Waitlist notification");

         // Now set the actual message
         message.setText("You have been registered to "	+ courseCode ); //need to get courseCode from somewhere

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
}
