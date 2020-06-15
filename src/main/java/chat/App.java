package chat;

import org.apache.kafka.clients.producer.Producer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;

@Configuration
@ComponentScan
public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        Scanner in = new Scanner(System.in);
        System.out.print("Введите логин: ");
        String login = in.nextLine();
        if (login == null) {
            System.out.println("Введите корректный логин");
        }
        KafkaConsumer consumerCreator = context.getBean(KafkaConsumer.class);
        consumerCreator.run(login);
        KafkaProducer producerCreator = context.getBean(KafkaProducer.class);
        ProducerFactory<String, String> producer = producerCreator.producerFactory();
        String message = "";

        while (!"exit".equals(message)){
            message = in.nextLine();
            if ("all".equals(message)){
                System.out.println("Enter message: ");
                String str = in.nextLine();
                str = login.concat(": ").concat(str);
                producerCreator.sendBroadCast((Producer<String, String>) producer, str);
            } else if ("pv".equals(message)){
                String str = in.nextLine();
                str = login.concat(" (p):").concat(str);
                final String topic  = in.nextLine();
                producerCreator.sendPrivate((Producer<String, String>) producer, str, topic);
            }
        }
    }
}
