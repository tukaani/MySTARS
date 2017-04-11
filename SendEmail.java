
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {

    public static void createMessage(String semail, int ind) {
    
    CourseList courses = new CourseList();
      String course = courses.findCourseByIndex(1234).getCourseCode(); 
      String to = semail;
      String from = "ce2002javamagic@gmail.com";
      final String username = "ce2002javamagic";
      final String password = "mattsigrid";

      
      String host = "smtp.gmail.com";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "587");

   
      Session session = Session.getInstance(props,
      new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
         }
      });

      try {
         Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress(from));
         message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(to));
         message.setSubject("Waitlist notification");
         message.setText("You have been registered to "  + course );

         Transport.send(message);

         System.out.println("Done");
         // // Create a default MimeMessage object.
         // MimeMessage message = new MimeMessage(session);

         // // Set From: header field of the header.
         // message.setFrom(new InternetAddress(from));

         // // Set To: header field of the header.
         // message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // // Set Subject: header field
         // message.setSubject("Waitlist notification");

         // // Now set the actual message
         // message.setText("You have been registered to "  + "course" ); //need to get courseCode from somewhere

         // // Send message
         // Transport.send(message);
         // System.out.println("Sent message successfully....");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }



}