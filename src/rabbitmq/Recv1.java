package rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.ShutdownSignalException;

public class Recv1 {
	private static final String queueName="hello";
	public static void main(String[] args) throws IOException, TimeoutException, ShutdownSignalException, ConsumerCancelledException, InterruptedException {
		// TODO Auto-generated method stub
   ConnectionFactory factory=new ConnectionFactory();
   factory.setHost("localhost");
   Connection connection=factory.newConnection();
   Channel channel=connection.createChannel();
   channel.queueDeclare(queueName, false, false, false, null);
   System.out.println(" [*] Waiting for messages. To exit press CTRL+C"); 
   QueueingConsumer consumer=new QueueingConsumer(channel);
   channel.basicConsume(queueName,true, consumer);
   while (true)  
   {  
       //nextDelivery��һ�������������ڲ�ʵ����ʵ���������е�take������  
       QueueingConsumer.Delivery delivery = consumer.nextDelivery();  
       String message = new String(delivery.getBody());  
       System.out.println(" [x] Received '" + message + "'");  
   }  
   
	}

}
