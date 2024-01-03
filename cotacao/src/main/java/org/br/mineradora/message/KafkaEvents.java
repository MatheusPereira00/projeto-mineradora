package org.br.mineradora.message;

import org.br.mineradora.dto.QuotationDTO;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class KafkaEvents {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Channel("quotation-channel")
    Emitter<QuotationDTO> quotationRequestEmitter;

    public void sendNewKafkaEvent(QuotationDTO quotation) {
        LOG.info("\n-- Enviando cotação para tópico do Kafka --");
        quotationRequestEmitter.send(quotation).toCompletableFuture().join();
    }

}
