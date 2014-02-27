package com.fagose.booklet.mail;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.fagose.booklet.model.User;


public class MailSender {
	
        @Autowired
        private ApplicationContext context;
        public static String sendActivationEmail (User user,String activationURL)throws Exception{

        try{    
                String title = "Booklet Uygulamasi Aktivasyon Maili";

            // Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
             final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
             Properties props = System.getProperties();
             props.put("mail.smtp.host", "smtp.gmail.com");
             props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
             props.put("mail.smtp.socketFactory.fallback", "false");
             props.put("mail.smtp.port", "465");
             props.put("mail.smtp.socketFactory.port", "465");
             props.put("mail.smtp.auth", "true");

             final String username = "bilgi.app@gmail.com";
             final String password = "bilgi";
             
             //Kullanciyi gonderilecek aktivasyon linkinde kullanilacak random String
             SecureRandom random = new SecureRandom();
             String activationString =new BigInteger(130, random).toString(20).substring(0,19);                
                 
             Session session = Session.getDefaultInstance(props,new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                 return new PasswordAuthentication(username,
                   password);
                }
               });  
           
             // -- Create a new message --
             Message msg = new MimeMessage(session);  
             msg.setFrom(new InternetAddress(username));
             msg.addRecipient(Message.RecipientType.TO, new InternetAddress(user.getUserEmail()));
             msg.setSubject("Activation Email");
             //*************************************************************

             String line;
             String subject = msg.getSubject();
             StringBuffer sb = new StringBuffer();
             sb.append("<HTML>\n");
             sb.append("<HEAD>\n");
             sb.append("<TITLE>\n");
             sb.append(subject + "\n");
             sb.append("</TITLE>\n");
             sb.append("</HEAD>\n");

             sb.append("<BODY>\n");
             sb.append("<H1>" + subject + "</H1>" + "\n");
             sb.append("<a href=\""+activationURL+
                         "/"+user.getUserName()+"/"+activationString+
                         ".htm\">Aktivasyon Maili</a>");

             sb.append("</BODY>\n");
             sb.append("</HTML>\n");

             msg.setDataHandler(new DataHandler(new ByteArrayDataSource(sb.toString(), "text/html")));      
             
 //*************************************************************            
             Transport.send(msg);

             return activationString;
    }

    catch (Exception ex) {

      ex.printStackTrace( );

    }
        return null;
               
               
        }

        public static String sendForgottenPassword(User user)throws Exception{

                try{    
                        String title = "Booklet Uygulamasi Sifre Hatirlatma";

                 //    Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                     final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
                     Properties props = System.getProperties();
                     props.setProperty("mail.smtp.host", "smtp.gmail.com");
                     props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
                     props.setProperty("mail.smtp.socketFactory.fallback", "false");
                     props.setProperty("mail.smtp.port", "465");
                     props.setProperty("mail.smtp.socketFactory.port", "465");
                     props.put("mail.smtp.auth", "true");

                     final String username = "bilgi.app@gmail.com";
                     final String password = "bilgi";
                     
                     //Kullanciyi gonderilecek aktivasyon linkinde kullanilacak random String
                     SecureRandom random = new SecureRandom();
                     String activationString =new BigInteger(130, random).toString(20).substring(0,19);                
                         
                     Session session = Session.getDefaultInstance(props,new Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                         return new PasswordAuthentication(username,
                           password);
                        }
                       });  
                   
                     // -- Create a new message --
                     Message msg = new MimeMessage(session);  
                     msg.setFrom(new InternetAddress(username));
                     msg.addRecipient(Message.RecipientType.TO, new InternetAddress(user.getUserEmail()));
                     msg.setSubject("Activation Email");
                     //*************************************************************

                     String line;
                     String subject = msg.getSubject();
                     StringBuffer sb = new StringBuffer();
                     sb.append("<HTML>\n");
                     sb.append("<HEAD>\n");
                     sb.append("<TITLE>\n");
                     sb.append(subject + "\n");
                     sb.append("</TITLE>\n");
                     sb.append("</HEAD>\n");

                     sb.append("<BODY>\n");
                     sb.append("<H1>" + subject + "</H1>" + "\n");
                     sb.append("<h3>Sifre : "+user.getPassword()+"</h3>");
                     sb.append("</BODY>\n");
                     sb.append("</HTML>\n");

                     msg.setDataHandler(new DataHandler(new ByteArrayDataSource(sb.toString(), "text/html")));      
                     
         //*************************************************************            
                     Transport.send(msg);

                     return activationString;
            }

            catch (Exception ex) {

              ex.printStackTrace( );

            }
                return null;
                       
                       
                }
       
}
