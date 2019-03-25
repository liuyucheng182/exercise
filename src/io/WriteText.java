package io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class WriteText {

    final static Logger logger = LoggerFactory.getLogger(WriteText.class);

    private static String channel = "50005,50006,50007,50008";

    public static void main(String[] args) {
        File file = null;
        FileWriter fw = null;
        file = new File("/Users/liuyucheng/Downloads/ProtectedApkResignerForWalle-master/channel");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file);
            if(channel != null){
                String [] channels = channel.split(",");
                for(int i = 0;i < channels.length;i++){
                    //向文件中写内容
                    fw.write(channels[i] + System.getProperty("line.separator"));
                    fw.flush();
                }
                System.out.println("写入数据成功！");
            } else {
                System.out.println("写入失败，渠道号为空");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if(fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //调用Python脚本批量生成签名客户端apk
        WriteText writeText = new WriteText();
        try {
            writeText.execCommand();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


public void execCommand() throws Exception{
    String command = "cd /Users/liuyucheng/Downloads/ProtectedApkResignerForWalle-master && rm -f ctclient_aligned.apk ; python ApkResigner.py";

    String[] cmds = new String[] { "/bin/sh", "-c", command };

    Process process = Runtime.getRuntime().exec(cmds);

    // 读取命令的正常输出信息
    InputStream is = process.getInputStream();
    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
    // 打印正常输出信息
    String msg = "";
    StringBuffer message = new StringBuffer();
    while ((msg = reader.readLine()) != null) {
        message.append(msg + "\r\n");
    }
    logger.info("执行完命令后的正常输出信息：" + message);

    // 读取命令执行出错后的输出信息
    InputStream errorStream = process.getErrorStream();
    BufferedReader errorReader = new BufferedReader(new InputStreamReader(errorStream));
    // 打印错误信息
    String errormsg = "";
    StringBuffer errorMessage = new StringBuffer();
    while ((errormsg = errorReader.readLine()) != null) {
        errorMessage.append(errormsg + "\r\n");
    }
    logger.info("执行完命令后的出错信息：" + errorMessage);

    // 命令执行状态判断
    if (process.waitFor() == 0) {
        logger.info("命令执行结束！");
    } else {
        process.destroy();
        throw new RuntimeException("命令执行未正常结束，原因：" + errorMessage);
    }
}

}


