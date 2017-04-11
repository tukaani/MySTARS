import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

   public static void main(String[] args) {

      final String username = "ce2002javamagic@gmail.com";
      final String password = "mattsigrid";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", "smtp.gmail.com");
      props.put("mail.smtp.port", "587");

      Session session = Session.getInstance(props,
        new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
         }
        });

      try {

         Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress("from-email@gmail.com"));
         message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse("to-email@gmail.com"));
         message.setSubject("Testing Subject");
         message.setText("Dear Mail Crawler,"
            + "\n\n No spam to my email, please!");

         Transport.send(message);

         System.out.println("Done");

      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
   }
}


// import javax.mail.Message;
// import javax.mail.MessagingException;
// import javax.mail.PasswordAuthentication;
// import javax.mail.Session;
// import javax.mail.Transport;
// import javax.mail.internet.InternetAddress;
// import javax.mail.internet.MimeMessage;
// import java.util.Properties;

// public class SendEmail {

//     public static void createMessage() {
//     //String semail, int ind
//     //CourseList courses = new CourseList();
//       //String course = courses.findCourseByIndex(1234).getCourseCode(); 
//       //String to = semail;
//       String to = "mattdodd12@gmail.com";
//       String from = "ce2002javamagic@gmail.com";
//       final String username = "ce2002javamagic";
//       final String password = "mattsigrid";

      
//       String host = "smtp.gmail.com";

//       Properties props = new Properties();
//       props.put("mail.smtp.auth", "true");
//       props.put("mail.smtp.starttls.enable", "true");
//       props.put("mail.smtp.host", host);
//       props.put("mail.smtp.port", "587");

   
//       Session session = Session.getInstance(props,
//       new javax.mail.Authenticator() {
//          protected PasswordAuthentication getPasswordAuthentication() {
//             return new PasswordAuthentication(username, password);
//          }
//       });

//       try {
//          // Create a default MimeMessage object.
//          MimeMessage message = new MimeMessage(session);

//          // Set From: header field of the header.
//          message.setFrom(new InternetAddress(from));

//          // Set To: header field of the header.
//          message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

//          // Set Subject: header field
//          message.setSubject("Waitlist notification");

//          // Now set the actual message
//          message.setText("You have been registered to "  + "course" ); //need to get courseCode from somewhere

//          // Send message
//          Transport.send(message);
//          System.out.println("Sent message successfully....");
//       }catch (MessagingException mex) {
//          mex.printStackTrace();
//       }
//    }

//    public static void main(String[] args){
//       createMessage();
//    }

// }