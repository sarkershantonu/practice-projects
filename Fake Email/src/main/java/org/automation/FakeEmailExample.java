package org.automation;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * Created by shantonu on 8/14/16.
 * See server source => https://sourceforge.net/projects/fakemail/
 */
public class FakeEmailExample {

/*public static void main(String[] args) {
        sendEmail("sarker.shantonu@gmail.com", "Test from local host");
    }*/

    public static void sendEmail(String fromEmail, String subject) {

        Session session = Session.getInstance(getDefaultEmailProperties());
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("to@shantonu.com, tk@saumen.com"));
            message.setSentDate(new Date());
            message.setSubject(subject);
            message.setText("Dummy email");
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static Properties getDefaultEmailProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "false");
        properties.put("mail.smtp.starttls.enable", "false");
        properties.put("mail.smtp.host", "0.0.0.0");
        properties.put("mail.smtp.port", "9500");
        return properties;
    }

}
