package org.jboss.mailra;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.mail.Message;

import org.jboss.ejb3.annotation.ResourceAdapter;
import org.jboss.mailra.rar.MailListener;

/**
 *
 */
@MessageDriven(
    activationConfig = {
//    @ActivationConfigProperty(propertyName = "ConnectionFactoryJndiName", propertyValue = "jms/TopicConnectionfactory"),
//    @ActivationConfigProperty(propertyName = "DestinationName", propertyValue = "jms/demoTopic"),
//    @ActivationConfigProperty(propertyName = "DestinationType", propertyValue = "javax.jms.Topic"),
    @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "RECIPIENT = 'MDB'")
})
@ResourceAdapter(value = "MailRA.ear#MailRA-rar-1.0-SNAPSHOT.rar")
public class MailMDB implements MailListener {

    @Override
    public void onMessage(Message msg) {
        System.out.println("***************************************");
        System.out.println("***************************************");
        System.out.println("***************************************");
        System.out.println("msg = " + msg);
        System.out.println("***************************************");
        System.out.println("***************************************");
        System.out.println("***************************************");
    }
}
