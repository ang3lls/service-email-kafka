package br.com.service_email_kafka_avro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(int id, String email, String nome, String cpf, float totalPedido) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);

        msg.setSubject("Pedido Criado: Cód.: " + id);
        msg.setText(
                "Pedido realizado pelo cliente: "+ nome +
                "\n"+ "CPF: "+cpf+
                "\n"+ "Valor Total : R$"+totalPedido);

        javaMailSender.send(msg);

    }
}
