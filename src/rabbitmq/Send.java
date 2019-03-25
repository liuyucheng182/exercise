package rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {

	private static final String queueName="hello";
	public static void main(String[] args) throws IOException, TimeoutException {
		/** 
         * 创建连接连接到MabbitMQ 
         */  
        ConnectionFactory factory = new ConnectionFactory();  
        //设置rabbitMQ所在主机ip或者主机名  
        factory.setHost("192.168.10.21");  
       // factory.setHost("127.0.0.1"); 
        //factory.setPort(15672);
        factory.setUsername("liu");
        factory.setPassword("123");
        //创建一个连接  
        Connection connection = factory.newConnection();  
        //创建一个频道  
        Channel channel = connection.createChannel();  
        //指定一个队列  
        channel.queueDeclare(queueName, false, false, false, null);  
        //发送的消息  
        String message = "nihaoma hello world!";  
        //往队列中发出一条消息  
        channel.basicPublish("", queueName, null, message.getBytes());  
        System.out.println(" [x] Sent '" + message + "'");  
        //关闭频道和连接  
        channel.close();  
        connection.close();  
	}

}
