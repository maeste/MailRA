package org.jboss.mailra;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.mail.Message;
import javax.mail.MessagingException;

import org.jboss.ejb3.annotation.ResourceAdapter;
import org.jboss.mailra.rar.MailListener;

/**
 *
 */
@MessageDriven(
    activationConfig = {
    @ActivationConfigProperty(propertyName = "mailServer", propertyValue = "imap.gmail.com"),
    @ActivationConfigProperty(propertyName = "userName", propertyValue = "marko.luksa@gmail.com"),
    @ActivationConfigProperty(propertyName = "password", propertyValue = "pass"),
    @ActivationConfigProperty(propertyName = "storeProtocol", propertyValue = "imaps"),
    @ActivationConfigProperty(propertyName = "mailFolder", propertyValue = "capedwarf-test"),
    @ActivationConfigProperty(propertyName = "pollingInterval", propertyValue = "5000")
})
//@ResourceAdapter(value = "MailRA.ear#MailRA-rar-1.0-SNAPSHOT.rar")
//@ResourceAdapter(value = "MailRA-rar-1.0-SNAPSHOT.rar")
@ResourceAdapter(value = "org.wildfly.mail.ra:main")
public class MailMDB implements MailListener {

    @Override
    public void onMessage(Message msg) {
        System.out.println("***************************************");
        System.out.println("***************************************");
        System.out.println("***************************************");
        try {
            System.out.println("msg = " + msg);
            System.out.println("msg.getSubject() = " + msg.getSubject());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        System.out.println("***************************************");
        System.out.println("***************************************");
        System.out.println("***************************************");
    }
}
