package br.com.service_email_kafka_avro.utils;

import br.com.service_email_kafka_avro.model.Pedido;
import com.micro.service.email.EventoPedido;
import org.springframework.stereotype.Component;

@Component
public class ParserUtils {

    public Pedido convertEventoPedidoToPedido(EventoPedido eventoPedido){
        return new Pedido(
                eventoPedido.getId(),
                eventoPedido.getNome(),
                eventoPedido.getEmail(),
                eventoPedido.getCpf(),
                eventoPedido.getValortotal()
        );
    }
}
