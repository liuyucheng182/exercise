package rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class NewTask {
 private final static  String queueName="workqueue2";
  
public static void main(String[] args) throws IOException, TimeoutException {
	//创建连接和频道
	ConnectionFactory factory=new ConnectionFactory();
	factory.setHost("localhost");
	Connection connection=factory.newConnection();
	Channel channel=connection.createChannel();
	//声明队列
	channel.queueDeclare(queueName, true, false, false, null);
	//发送10条消息，依次在消息后面附加10个点
	for (int i = 10; i >=0; i--) {
		String dots="";
		for (int j = 0; j < i; j++) {
			dots+=".";
		}
		String message="hello"+dots+dots.length();
		channel.basicPublish("", queueName, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
		System.out.println("[x] Sent '"+message+"'");
	}
	channel.close();
	connection.close();
}
}
