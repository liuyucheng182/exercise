package rabbitmq;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;
import com.rabbitmq.client.ShutdownSignalException;

public class ReceiveLogsToSave {
	private static final String exchangeName="ex_log";
	public static void main(String[] args) throws IOException, TimeoutException, ShutdownSignalException, ConsumerCancelledException, InterruptedException {
		// TODO Auto-generated method stub
		// 创建连接和频道 
				ConnectionFactory factory=new ConnectionFactory();
				factory.setHost("localhost");
				Connection connection=factory.newConnection();
		       Channel channel=connection.createChannel();
		    // 声明转发器和类型(这样做是为了保险，无论是先运行发送端还是接收端，转发器都已经声明了)
		       channel.exchangeDeclare(exchangeName, "fanout");
		    // 创建一个非持久的、唯一的且自动删除的队列 
		       String queueName=channel.queueDeclare().getQueue();
		    // 为转发器指定队列，设置binding 
		      channel.queueBind(queueName, exchangeName, "");
		    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
		    QueueingConsumer consumer=new QueueingConsumer(channel);
		 // 指定接收者，第二个参数为自动应答，无需手动应答  
	        channel.basicConsume(queueName, true, consumer); 
		   while(true){
			   QueueingConsumer.Delivery delivery=consumer.nextDelivery();
			   String message=new String(delivery.getBody());
			   print2File(message);
		   }
		      
	}
	   public static void print2File(String message) {
		// TODO Auto-generated method stub
		   try  
	        {  
	            String dir = ReceiveLogsToSave.class.getClassLoader().getResource("").getPath();  
	            String logFileName = new SimpleDateFormat("yyyy-MM-dd")  .format(new Date());  
	            File file = new File(dir, logFileName+".txt");  
	            FileOutputStream fos = new FileOutputStream(file, true);  
	            fos.write((message + "\r\n").getBytes());  
	            fos.flush();  
	            fos.close();  
	        } catch (FileNotFoundException e)  
	        {  
	            e.printStackTrace();  
	        } catch (IOException e)  
	        {  
	            e.printStackTrace();  
	        }  
	}

}
