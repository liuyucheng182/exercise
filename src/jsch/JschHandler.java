package jsch;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;
import com.mysql.jdbc.BufferRow;

public class JschHandler {
	    protected String charset = "UTF-8"; // 设置编码格式  
	    protected String jschHost="172.16.50.62";//主机ip地址  
	    protected int jschPort=22;//主机端口  
	    protected String jschUserName="was";//用户名  
	    protected String jschPassWord="P@ssw0rd";//密码  
	    protected int jschTimeOut;//设置连接超时时间  
	    protected JSch jsch;  
	    protected Session session;  
	    protected Channel channel = null;  
	    protected ChannelSftp chSftp = null; 
	private static final Logger logger = LoggerFactory.getLogger(JschHandler.class); 
	
	/** 
     * 连接到指定的linux服务器 
     * 
     * @throws com.jcraft.jsch.JSchException 
     */  
	    public void getConnect() throws JSchException{
	    	JSch jsch=new JSch();
	    	session=jsch.getSession(jschUserName, jschHost, jschPort);
	    	logger.debug("Session Created");
	    	if (jschPassWord != null) {  
	            session.setPassword(jschPassWord); // 设置密码  
	        }  
	    	Properties config = new Properties();  
	        config.put("StrictHostKeyChecking", "no");  
	        session.setConfig(config);// 为Session对象设置properties  
	        session.setTimeout(jschTimeOut);//设置连接超时时间  
	        session.connect();  
	        logger.debug("Session connected.");  
	        logger.debug("Connected successfully to jschHost = " + jschHost + ",as jschUserName = " + jschUserName  
	                + ",as jschPort =  " + jschPort);  
	    }
	    
	    /** 
	     * 执行相关的命令 
	     */  
	    public void execCmd() {  
	   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   String command="";
	   BufferedReader reader=null;
	   
	   try {
		getConnect();
		while((command=br.readLine())!=null){
			channel=session.openChannel("exec");
			((ChannelExec)channel).setCommand(command);
			channel.setInputStream(null);
			((ChannelExec) channel).setErrStream(System.err);
			channel.connect();
			InputStream in=channel.getInputStream();
			  reader = new BufferedReader(new InputStreamReader(in, Charset.forName(charset)));  
              String buf = null;  
              while((buf=reader.readLine())!=null){
            	  System.out.println(buf);
              }
		}
	} catch (JSchException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {  
        try {  
            reader.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        channel.disconnect();  
        session.disconnect();  
    }    
	    }
	    
	    /** 
	     * 上传文件 
	     * 
	     * @param directory 上传的目录,有两种写法１、如/opt，拿到则是默认文件名２、/opt/文件名，则是另起一个名字 
	     * @param uploadFile 要上传的文件 如/opt/xxx.txt 
	     */  
	    public void upload(String directory, String uploadFile) {  
	        try {  
	            getConnect();//建立服务器连接  
	            logger.debug("Opening Channel.");  
	            channel = session.openChannel("sftp"); // 打开SFTP通道  
	            channel.connect(); // 建立SFTP通道的连接  
	            chSftp = (ChannelSftp) channel;  
	            File file = new File(uploadFile);  
	            long fileSize = file.length();  
	  
	           /*方法一 
	             OutputStream out = chSftp.put(uploadFile, new FileProgressMonitor(fileSize), ChannelSftp.OVERWRITE); // 使用OVERWRITE模式 
	             byte[] buff = new byte[1024 * 256]; // 设定每次传输的数据块大小为256KB 
	             int read; 
	             if (out != null) { 
	                 logger.debug("Start to read input stream"); 
	                InputStream is = new FileInputStream(directory); 
	                do { 
	                    read = is.read(buff, 0, buff.length); 
	                     if (read > 0) { 
	                            out.write(buff, 0, read); 
	                     } 
	                     out.flush(); 
	                 } while (read >= 0); 
	                 logger.debug("input stream read done."); 
	             }*/  
	  
	            chSftp.put(uploadFile, directory); //方法二  
	  
	            // chSftp.put(new FileInputStream(src), dst, new FileProgressMonitor(fileSize), ChannelSftp.OVERWRITE); //方法三  
	            logger.debug("成功上传文件至"+directory);  
	  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }finally {  
	            chSftp.quit();  
	  
	            if (channel != null) {  
	                channel.disconnect();  
	                logger.debug("channel disconnect");  
	            }  
	            if (session != null) {  
	                session.disconnect();  
	                logger.debug("channel disconnect");  
	            }  
	        }  
	    } 
	    
	    /** 
	     * 下载文件 
	     * 
	     * @param directory 下载的目录,有两种写法１、如/opt，拿到则是默认文件名２、/opt/文件名，则是另起一个名字 
	     * @param downloadFile 要下载的文件 如/opt/xxx.txt 
	     * 
	     */  
	    public void download(String directory, String downloadFile){
	    	try {
				getConnect();//建立服务器连接  
				logger.info("Opening Channel....");
			ChannelSftp	chSftp=(ChannelSftp) session.openChannel("sftp");// 打开SFTP通道
			    chSftp.connect();// 建立SFTP通道的连接
			    SftpATTRS attr = chSftp.stat(downloadFile);  
	            long fileSize = attr.getSize();  
	            chSftp.get(downloadFile, directory); // 代码段1 
	            //OutputStream out = new FileOutputStream(directory);  
	            //chSftp.get(downloadFile, out, new FileProgressMonitor(fileSize)); // 代码段2  
	  
	            /*代码段3 
	 
	            InputStream is = chSftp.get(downloadFile, new MyProgressMonitor()); 
	            byte[] buff = new byte[1024 * 2]; 
	            int read; 
	            if (is != null) { 
	                logger.debug("Start to read input stream"); 
	                do { 
	                    read = is.read(buff, 0, buff.length); 
	                    if (read > 0) { 
	                        out.write(buff, 0, read); 
	                    } 
	                    out.flush(); 
	                } while (read >= 0); 
	                logger.debug("input stream read done."); 
	            }*/  
	  
	            logger.debug("成功下载文件至"+directory); 
			} catch (JSchException | SftpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {    
	            if (chSftp != null) {  
	            	chSftp.disconnect();  
	                logger.debug("channelSftp disconnect");  
	            }  
	            if (session != null) {  
	                session.disconnect();  
	                logger.debug("session disconnect");  
	            }  
	        }  
	    }
	    
	    
	    /** 
	     * 删除文件 
	     * @param deleteFile 要删除的文件 
	     */  
	    public void delete(String deleteFile) {  
	  
	        try {  
	            getConnect();//建立服务器连接  
	            logger.debug("Opening Channel.");  
	            channel = session.openChannel("sftp"); // 打开SFTP通道  
	            channel.connect(); // 建立SFTP通道的连接  
	            chSftp = (ChannelSftp) channel;  
	            chSftp.rm(deleteFile);  
	            logger.debug("成功删除文件"+deleteFile);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	  
	    }  
}
