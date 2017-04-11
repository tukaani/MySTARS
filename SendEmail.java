import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
/**
 Handles sending notification mail to students
 @version 1.0
 @since 2017-04-10
*/
public class SendEmail {

   /**
   *  Method for sending message to particular student
   * @param String semail Students email name in format "first.last"
   *        Methods appends gmail domaint to that. In example first.last@gmail.com
   * @param int ind Index number on what email is considering
   */
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
         message.setText("You have been registered to "  + course + " with index " + ind);

         Transport.send(message);

         System.out.println("Done");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }



}