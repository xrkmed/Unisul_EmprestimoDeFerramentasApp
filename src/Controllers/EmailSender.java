package Controllers;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

public class EmailSender {

    //Sistema desativado por enquanto
    private final static String host = "smtp.hostinger.com";
    private final static int port = 587;
    private final static String sender = "";
    private final static String password = "";

    private EmailSender() {

    }

    public static void send(String toEmail, String subject, String body) {
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Autenticação do remetente
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sender, password);
            }
        };

        // Cria uma sessão de e-mail com autenticação
        Session session = Session.getInstance(props, auth);

        try {
            // Cria uma mensagem de e-mail
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(formatBody(body), "text/html");

            MimeMultipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);

            Transport.send(message);

            System.out.println("E-mail enviado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String formatBody(String body) {
        String emailContent = "<div marginheight=\"0\" marginwidth=\"0\" style=\"padding:0;width:100%!important;margin:0\">\n"
                + "<center>\n"
                + "<table cellpadding=\"8\" cellspacing=\"0\" border=\"0\" style=\"padding:0;width:100%!important;background:#ffffff;margin:0;background-color:#ffffff\">\n"
                + "\n"
                + "    <tbody><tr>\n"
                + "        <td valign=\"top\">\n"
                + "            <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\" style=\"border-radius:4px;border:1px #dceaf5 solid\">\n"
                + "                <tbody><tr>\n"
                + "                    <td colspan=\"3\" height=\"6\"></td>\n"
                + "                </tr>\n"
                + "                <tr>\n"
                + "                    <td width=\"100%\" align=\"center\" height=\"1\" style=\"color:#8a98a3;font-family:Verdana,Arial,'Open Sans','Lucida Grande','Segoe UI','Sans Serif'\">\n"
                + "                        <h2>GRUPO SUPIMPA</h2>\n"
                + "                    </td>\n"
                + "                </tr>\n"
                + "                <tr>\n"
                + "                    <td>\n"
                + "                        <table cellpadding=\"0\" cellspacing=\"0\" style=\"line-height:25px\" border=\"0\" align=\"center\">\n"
                + "                            <tbody><tr>\n"
                + "                                <td colspan=\"3\" height=\"16\">\n"
                + "                                </td>\n"
                + "                            </tr>\n"
                + "                            <tr>\n"
                + "                                <td width=\"36\">\n"
                + "                                </td>\n"
                + "\n"
                + "                                <td width=\"454\" align=\"left\" valign=\"top\" style=\"color:#444444;border-collapse:collapse;font-size:11pt;font-family:'Open Sans','Lucida Grande','Segoe UI',Verdana,Arial,'Sans Serif';max-width:454px\">\n"
                + "\n"
                + "\n"
                + body
                + "\n"
                + "\n"
                + "<br>\n"
                + "<br><div align=\"right\">- Grupo Supimpa. Developed by @xrkmed</div>\n"
                + "\n"
                + "\n"
                + "                                </td>\n"
                + "\n"
                + "                                <td width=\"36\">\n"
                + "                                </td>\n"
                + "                            </tr>\n"
                + "                            <tr>\n"
                + "                                <td colspan=\"3\" height=\"36\">\n"
                + "                                </td>\n"
                + "                            </tr>\n"
                + "                        </tbody></table>\n"
                + "                    </td>\n"
                + "                </tr>\n"
                + "            </tbody></table>\n"
                + "\n"
                + "\n"
                + "            <table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" border=\"0\">\n"
                + "                <tbody><tr>\n"
                + "                    <td height=\"10\">\n"
                + "                    </td>\n"
                + "                </tr>\n"
                + "                <tr>\n"
                + "                    <td style=\"padding:0;border-collapse:collapse\">\n"
                + "                        <table cellpadding=\"0\" cellspacing=\"0\" align=\"center\" border=\"0\">\n"
                + "                            <tbody><tr style=\"color:#8a98a3;font-size:11px;font-family:'Open Sans','Lucida Grande','Segoe UI',Verdana,Arial,'Sans Serif'\">\n"
                + "                                <td width=\"128\" align=\"left\"> </td>\n"
                + "                                <td width=\"400\" align=\"right\">Essa é uma mensagem automática e não deve ser respondida</td>\n"
                + "                            </tr>\n"
                + "                            <tr style=\"color:#8a98a3;font-size:12px;font-family:'Open Sans','Lucida Grande','Segoe UI',Verdana,Arial,'Sans Serif'\">\n"
                + "                                <td width=\"128\" align=\"left\"> </td>\n"
                + "                            </tr>\n"
                + "                        </tbody></table>\n"
                + "                    </td>\n"
                + "                </tr>\n"
                + "            </tbody></table>\n"
                + "        </td>\n"
                + "    </tr>\n"
                + "\n"
                + "\n"
                + "</tbody></table>\n"
                + "</center>\n"
                + "</div>";

        return emailContent;
    }

}
