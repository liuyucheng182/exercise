package rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.ShutdownSignalException;

public class ReceiveLogsTopicForKernel {
	private static final String exchangeName="topic_logs";
	public static void main(String[] args) throws IOException, TimeoutException, ShutdownSignalException, ConsumerCancelledException, InterruptedException {
		// TODO Auto-generated method stub
		  ConnectionFactory factory=new ConnectionFactory();
	      factory.setHost("localhost");
	      Connection connection=factory.newConnection();
	      Channel channel=connection.createChannel();
	      channel.exchangeDeclare(exchangeName, "topic");
	      //随机生成一个队列
	      String queueName=channel.queueDeclare().getQueue();
	      channel.queueBind(queueName, exchangeName, "kernel.*");
	      System.out.println(" [*] Waiting for messages about kernel. To exit press CTRL+C");
	      QueueingConsumer consumer=new QueueingConsumer(channel);
	      channel.basicConsume(queueName, true, consumer);
	      while(true){
	    	  QueueingConsumer.Delivery delivery=consumer.nextDelivery();
	    	  String message=delivery.getBody().toString();
	    	  String routingKey=delivery.getEnvelope().getRoutingKey();
	    	  System.out.println(" [x] Received routingKey = " + routingKey  
	                    + ",msg = " + message + ".");
	      }
	}

}
