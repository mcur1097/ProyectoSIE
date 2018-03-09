package mail;

import java.util.Properties;  

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import vo.NovedadVo
;

public class EmailSenderServices
{
	NovedadVo miNovedadVo= new NovedadVo();

	public void recibirInstancia(NovedadVo miNovedadVo2){
		this.miNovedadVo=miNovedadVo2;
	}

	public EmailSenderServices(){
	}

    public void enviarCorreo(String remitente, String receptor, String pass, String asunto, String msj) {
	
        try
        {
        Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", remitente);
            props.setProperty("mail.smtp.auth", "false");

            Session session = Session.getDefaultInstance(props);
            MimeMessage message = new MimeMessage(session);
            
            message.setFrom(new InternetAddress(remitente));
            
            message.addRecipient(
             Message.RecipientType.TO, new InternetAddress(receptor));

            message.setSubject(asunto);
            message.setText("Estimado Usuario \n\n"
            		+ "Este mensaje ha sido enviado con el fin de informarle sobre una novedad que presenta uno de sus bienes "
            		   + "asignados dentro del inventario del SENA - Centro de Comercio y Turismo. \n\n" + 
            		
            		msj + "\n \n "
            		
            		+ "Recuerde Que..... \n"
            		+ "Este correo informativo es enviado al cuentadante del bien y al correo de los encargados de Mantenimiento \n\n"
            		+ "********NO RESPONDER - Mensaje Generado Automáticamente********"
            		+ "\n \n"
            		+ "Este correo es únicamente informativo y es de uso exclusivo de los destinatario(a)s, puede contener información privilegiada y/o confidencial.");

            Transport t = session.getTransport("smtp");
            t.connect(remitente, pass);
            t.sendMessage(message, message.getAllRecipients());

            t.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
	  }
}