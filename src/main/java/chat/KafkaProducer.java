package chat;

import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class KafkaProducer {

    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    public void sendBroadCast(Producer<String, String> producer, String message) {
        try {
            ProducerRecord<String, String> record = new ProducerRecord<>(Channel.NAME, message);
            producer.send(record).get();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void sendPrivate(Producer<String, String> producer, String message, String id) {
        try {
            ProducerRecord<String, String> record = new ProducerRecord<>(id, message);
            producer.send(record).get();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
