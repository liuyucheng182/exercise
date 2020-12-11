package rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send1 {

	private static final String queueName="hello";
	public static void main(String[] args) throws IOException, TimeoutException {
		/** 
         * �����������ӵ�MabbitMQ 
         */  
        ConnectionFactory factory = new ConnectionFactory();  
        //����MabbitMQ��������ip����������  
        factory.setHost("localhost");  
        //����һ������  
        Connection connection = factory.newConnection();  
        //����һ��Ƶ��  
        Channel channel = connection.createChannel();  
        //ָ��һ������  
        channel.queueDeclare(queueName, false, false, false, null);  
        //���͵���Ϣ  
        String message = "hello world!";  
        //�������з���һ����Ϣ  
        channel.basicPublish("", queueName, null, message.getBytes());  
        System.out.println(" [x] Sent '" + message + "'");  
        //�ر�Ƶ��������  
        channel.close();  
        connection.close();  
	}

}
