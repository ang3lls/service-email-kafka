package br.com.service_email_kafka_avro.consumer;

import br.com.service_email_kafka_avro.model.Pedido;
import br.com.service_email_kafka_avro.service.EmailService;
import br.com.service_email_kafka_avro.utils.ParserUtils;
import com.micro.service.email.EventoPedido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author Everton Belarmino
 */
@Component
public class PedidoEventListener {

    private static final Logger LOG = LoggerFactory.getLogger(PedidoEventListener.class);

    @Autowired
    private ParserUtils parserUtils;

    @Autowired
    private EmailService emailService;

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(EventoPedido eventoPedido) {
        try {
            Pedido pedido = parserUtils.convertEventoPedidoToPedido(eventoPedido);
            emailService.sendEmail(
                    eventoPedido.getId(),
                    eventoPedido.getEmail(),
                    eventoPedido.getNome(),
                    eventoPedido.getCpf(),
                    eventoPedido.getValortotal()
            );
            System.out.println(pedido.getNome());
        } catch (Exception ex) {
            LOG.error("Error to send message:", ex.getMessage());
            throw ex;
        }
    }
}
