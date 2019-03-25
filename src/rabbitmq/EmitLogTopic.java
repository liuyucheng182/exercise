package rabbitmq;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class EmitLogTopic {

	private static final String exchangeName="topic_logs";
	public static void main(String[] args) throws IOException, TimeoutException {
		// TODO Auto-generated method stub
      ConnectionFactory factory=new ConnectionFactory();
      factory.setHost("localhost");
      Connection connection=factory.newConnection();
      Channel channel=connection.createChannel();
      channel.exchangeDeclare(exchangeName, "topic");
      String[] routingKeys={"kernal.info","cron.warning","auth.info","kernel.critical"};
      for (String routingKey : routingKeys) {
		  String msg=UUID.randomUUID().toString();
    	  channel.basicPublish(exchangeName, routingKey, null, msg.getBytes());
    	  System.out.println("[x] Sent routingKey="+routingKey+","+msg);
	}
      channel.close();
      connection.close();
	} 

}
