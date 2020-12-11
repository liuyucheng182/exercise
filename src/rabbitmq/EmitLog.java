package rabbitmq;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class EmitLog {

	private static final String exchangeName="ex_log";
	public static void main(String[] args) throws IOException, TimeoutException {
		// 创建连接和频道 
		ConnectionFactory factory=new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection=factory.newConnection();
       Channel channel=connection.createChannel();
    // 声明转发器和类型
       channel.exchangeDeclare(exchangeName, "fanout");
      String message=new Date().toLocaleString()+": log someting";
   // 往转发器上发送消息
      channel.basicPublish(exchangeName, "", null, message.getBytes());
      System.out.println("sent: '"+message+"'");
      
      channel.close();
      connection.close();
	}

}
