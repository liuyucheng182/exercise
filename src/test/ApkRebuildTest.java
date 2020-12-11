package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class ApkRebuildTest{

	// 4MB buffer
	private static final byte[] BUFFER = new byte[4096 * 1024];
	private static final Logger logger = LoggerFactory.getLogger(ApkRebuildTest.class);
	/**
	 * zip复制
	 * <p>
	 * 说明：将服务器中的客户端apk文件复制一份到指定的目录下，在复制的过程中，需要将apk文件中META-INF文件夹下的ctchannel_channel581文件去除掉，
	 * 然后再向META-INF文件夹下添加一个ctchannel_渠道号（对应营业厅的渠道号）文件来替换掉删除的文件（此文件是用来区分不同营业厅客户端的标志）。
	 *  </p>
	 * @param zipName           复制后得到的apk文件名称
	 * @param excludeFileName   要排除的apk文件中的文件名称（如：ctchannel_channel581）
	 * @param addFileName       向apk文件中添加的文件名称（如：ctchannel_渠道号）
	 * @return
	 * @throws IOException
	 */
	public static String copyZip(String zipName, String excludeFileName, String addFileName) throws IOException {

		ZipFile zipFile = new ZipFile("D:\\java\\download\\client\\demo\\ctclient.apk");
		// 构建目录
		//createDirectory("");

		try (ZipOutputStream out = new ZipOutputStream(new FileOutputStream("D:\\java\\download\\client\\" + zipName))) {
			Enumeration<? extends ZipEntry> entries = zipFile.entries();
			while (entries.hasMoreElements()) {
				ZipEntry e = entries.nextElement();
				// 源包文件META-INF/ctchannel_channel581不写入
				if (!e.getName().startsWith(excludeFileName)) {
					out.putNextEntry(e);
					if (!e.isDirectory()) {
						copy(zipFile.getInputStream(e), out);
					}
					out.closeEntry();
				}
			}

			// 添加文件 META-INF/ctchannel_渠道号
			ZipEntry e = new ZipEntry(addFileName);
			out.putNextEntry(e);
			// out.write("123\n".getBytes());
			out.closeEntry();

		} catch (IOException e) {
			logger.info(e.getMessage(), e);
			throw e;
		}
		return "" + zipName;
	}
	
	public static String copyZipNew(String zipName, String excludeFileName, String addFileName) throws IOException {

		ZipFile zipFile = new ZipFile("D:\\java\\download\\client\\demo\\ctclient.apk");
		// 构建目录
		//createDirectory("");

		try (ZipOutputStream out = new ZipOutputStream(new FileOutputStream("D:\\java\\download\\client\\" + zipName))) {
			Enumeration<? extends ZipEntry> entries = zipFile.entries();
			while (entries.hasMoreElements()) {
				ZipEntry e = entries.nextElement();
				// 源包文件META-INF/ctchannel_channel581不写入
				if (!e.getName().startsWith(excludeFileName)) {
					out.putNextEntry(e);
					if (!e.isDirectory()) {
						//copy(zipFile.getInputStream(e), out);
						FileInputStream fis = (FileInputStream) zipFile.getInputStream(e);
						FileOutputStream fos = (FileOutputStream)(OutputStream) out;
						FileChannel inChannel = fis.getChannel(); 
						FileChannel outChannel = fos.getChannel();
						inChannel.transferTo(0, inChannel.size(), outChannel);
					} else if("META-INF".equals(e.getName())) {
						out.putNextEntry(new ZipEntry(addFileName));
					}
					out.closeEntry();
				}
			}

			// 添加文件 META-INF/ctchannel_渠道号
			/*ZipEntry e = new ZipEntry(addFileName);
			out.putNextEntry(e);
			out.closeEntry();*/

		} catch (IOException e) {
			logger.info(e.getMessage(), e);
			throw e;
		}
		return "" + zipName;
	}
	
	private static void copy(InputStream input, OutputStream output) throws IOException {
		int bytesRead;
		while ((bytesRead = input.read(BUFFER)) != -1) {
			output.write(BUFFER, 0, bytesRead);
		}
	}
	
	/**
	 * 构建目录
	 * 
	 * @param directory
	 */
	private static void createDirectory(String directory) {
		File file = new File(directory);
		if (!file.exists()) {
			if (!file.getParentFile().exists())
				file.getParentFile().mkdirs();
			file.mkdirs();
		}
	}
	
	@Test
	public void testApk() {
		List<String> list = getData();
		List<String> data = list.subList(0, 50);
		for (String channelNo : data) {
        	try {
				copyZipNew("ctclient" + channelNo + ".apk", "META-INF/ctchannel_", "META-INF/ctchannel_" + channelNo);
			} catch (Exception e) {
				System.out.println(channelNo);
			}
		}
	}
	
	
	@Test
	public void testCmdCopyApk(){
		List<String> list = getData();
		List<String> data = list.subList(0, 50);
		for (String channelNo : data) {
        	try {
				//copyZipNew("ctclient" + channelNo + ".apk", "META-INF/ctchannel_", "META-INF/ctchannel_" + channelNo);
        		//String cmd="cmd /c XCOPY D:\\java\\download\\client\\demo\\ctclient.apk D:\\java\\download\\client\\"+channelNo+".apk /s /y"; //命令的前面必须要有cmd /c
                //execCmd(cmd);
        		
        		String command1 = "cp /java/download/client/demo/ctclient.apk  /java/download/client/ctclient" + channelNo +".apk";
        		String command2 = "touch /java/download/client/META-INF/ctchannel_" + channelNo;
        		
        		String command3 = "cd /java/download/client && zip -m ctclient" + channelNo + ".apk META-INF/ctchannel_"+channelNo;
        		String command = command1 + "&&" + command2 + "&&" + command3;
        		
        		exec("127.0.0.1", "root", "123456", 22, command);
        		System.out.println(command);
			} catch (Exception e) {
				System.out.println(channelNo);
			}
		}
	}
	
	@Test
	public void testRemoteLinuxCmdCopyApk(){/*
		List<String> list = getData();
		List<String> data = list.subList(0, 10);
		StringBuffer sb= new StringBuffer();
        Session session =null;
        ChannelExec openChannel =null;
		for (String channelNo : data) {
        	try {
        		JSch jsch=new JSch();
                session = jsch.getSession("root", "101.201.238.116", 22);
                Properties config = new Properties();
                config.put("StrictHostKeyChecking", "no");//跳过公钥的询问
                session.setConfig(config);
                session.setPassword("Lyc199212");
                session.connect(5000);//设置连接的超时时间
                openChannel = (ChannelExec) session.openChannel("exec");
                
                String command1 = "cp /java/download/client/demo/ctclient.apk  /java/download/client/ctclient" + channelNo +".apk";
        		String command2 = "touch /java/download/client/META-INF/ctchannel_" + channelNo;
        		String command3 = "zip -m /java/download/client/ctclient" + channelNo + ".apk /java/download/client/META-INF/ctchannel_"+channelNo;
                
                openChannel.setCommand(command1); //执行命令
                openChannel.
                //openChannel.setCommand(command3);
                
        		System.out.println();
        		int exitStatus = openChannel.getExitStatus(); //退出状态为-1，直到通道关闭
                System.out.println(exitStatus);
                
        		 // 下面是得到输出的内容
                openChannel.connect();
                InputStream in = openChannel.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String buf = null;
                while ((buf = reader.readLine()) != null) {
                    sb.append(buf+"\n");
                }
                System.out.println(sb);
			} catch (Exception e) {
				System.out.println(channelNo);
				sb.append(e.getMessage()+"\n");
			} finally {
				
               
				if (openChannel != null && !openChannel.isClosed()) {
					openChannel.disconnect();
				}
				if (session != null && session.isConnected()) {
					session.disconnect();
				}
			}
		}
	*/}
	
	public static void execCmd(String cmd){
        try{
            Runtime rt = Runtime.getRuntime();
            //执行命令, 最后一个参数，可以使用new File("path")指定运行的命令的位置
            Process proc = rt.exec(cmd,null,null);  
            InputStream stderr =  proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(stderr,"GBK");
            BufferedReader br = new BufferedReader(isr);
            String line="";
            while ((line = br.readLine()) != null) { // 打印出命令执行的结果
                System.out.println(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
	}
	
	
	/**
     * 远程 执行命令并返回结果调用过程 是同步的（执行完才会返回）
     * @param host  主机名
     * @param user  用户名
     * @param psw   密码
     * @param port  端口
     * @param command   命令
     * @return
     */
    public static String exec(String host,String user,String psw,int port,String command){
        StringBuffer sb= new StringBuffer();
        Session session =null;
        ChannelExec openChannel =null;
        try {
            JSch jsch=new JSch();
            session = jsch.getSession(user, host, port);
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");//跳过公钥的询问
            session.setConfig(config);
            session.setPassword(psw);
            session.connect(5000);//设置连接的超时时间
            openChannel = (ChannelExec) session.openChannel("exec");
            openChannel.setCommand(command); //执行命令
            int exitStatus = openChannel.getExitStatus(); //退出状态为-1，直到通道关闭
            System.out.println(exitStatus);

            // 下面是得到输出的内容
            openChannel.connect();
            InputStream in = openChannel.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String buf = null;
            while ((buf = reader.readLine()) != null) {
                sb.append(buf+"\n");
            }
            System.out.println(sb);
        } catch (JSchException | IOException e) {
            sb.append(e.getMessage()+"\n");
        }finally{
            if(openChannel!=null&&!openChannel.isClosed()){
                openChannel.disconnect();
            }
            if(session!=null&&session.isConnected()){
                session.disconnect();
            }
        }
        return sb.toString();
    }

    public static void deleteInsideFile(String excludeFileName) {
    	try {
			ZipFile zipFile = new ZipFile(ApplicationConstants.apkOriginalPath);
			Enumeration<? extends ZipEntry> entries = zipFile.entries();
			while (entries.hasMoreElements()) {
				ZipEntry e = entries.nextElement();
				// 源包文件META-INF文件夹下存在以ctchannel_开头的文件则删除（如：META-INF/ctchannel_channel581） 
				if (e.getName().startsWith(excludeFileName)) {
					String command = "zip -d " + ApplicationConstants.apkOriginalPath + " " + excludeFileName + "*";
					//打印命令信息
					logger.info("执行的命令：" + command);
					Process process = Runtime.getRuntime().exec(command);
					//读取命令的输出信息
					InputStream is = process.getInputStream();
					BufferedReader reader = new BufferedReader(new InputStreamReader(is));
					// 打印输出信息
					String msg = "";
					StringBuffer message= new StringBuffer();
					while ((msg = reader.readLine()) != null) {
						message.append(msg + "\r\n");
					}
					logger.info("执行完命令后的输出信息：" + message);
					
					//命令执行失败后的处理
					if (process.exitValue() != 0) {
						throw new RuntimeException("命令执行失败！");
					}
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    /**
	 * apk复制
	 * <p>
	 * 说明：将服务器中的客户端apk文件复制一份到指定的目录下，在复制的过程中，需要将apk文件中META-INF文件夹下的ctchannel_channel581文件去除掉，
	 * 然后再向META-INF文件夹下添加一个ctchannel_渠道号（对应营业厅的渠道号）文件来替换掉删除的文件（此文件是用来区分不同营业厅客户端的标志）。
	 *  </p>
	 * @param apkName           复制后得到的apk文件名称
	 * @param excludeFileName   要排除的apk文件中的文件名称（如：META-INF/ctchannel_*）
	 * @param addFileName       向apk文件中添加的文件名称（如：META-INF/ctchannel_渠道号）
	 * @return
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public static String copyApk(String apkName, String excludeFileName, String addFileName) throws IOException, InterruptedException {
		
		/* linux命令：
		 * cp /java/download/client/demo/ctclient.apk /java/download/client/ctclient123456.apk 
		 * && zip -d /java/download/client/ctclient123456.apk META-INF/ctchannel_* 
		 * && touch /java/download/client/META-INF/ctchannel_123456 
		 * && cd /java/download/client/ 
		 * && zip -m /java/download/client/ctclient123456.apk META-INF/ctchannel_123456" 
		 * */
		
		String command = "cp " + ApplicationConstants.apkOriginalPath + " " + ApplicationConstants.apkPath + apkName 
				//+ " && zip -d " + ApplicationConstants.apkPath + apkName + " " + excludeFileName + "*"
				+ " && touch " + ApplicationConstants.apkPath + "META-INF/" + addFileName 
				+ " && cd  " + ApplicationConstants.apkPath 
				+ " && zip -m " + ApplicationConstants.apkPath + apkName + " META-INF/" + addFileName
				;
		// 打印命令信息
		logger.info("执行的命令：" + command);

		String[] cmds = new String[] { "/bin/sh", "-c", command };

		Process process = Runtime.getRuntime().exec(cmds);

		// 读取命令的输出信息
		InputStream is = process.getInputStream();
		InputStream errorStream = process.getErrorStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		BufferedReader errorReader = new BufferedReader(new InputStreamReader(errorStream));
		// 打印输出信息
		String msg = "";
		StringBuffer message = new StringBuffer();
		while ((msg = reader.readLine()) != null) {
			message.append(msg + "\r\n");
		}
		logger.info("执行完命令后的输出信息：" + message);

		// 打印错误信息
		String msg2 = "";
		StringBuffer message2 = new StringBuffer();
		while ((msg2 = errorReader.readLine()) != null) {
			message2.append(msg2 + "\r\n");
		}
		logger.info("执行完命令后的出错信息：" + message2);

		// 命令执行状态判断
		if (process.waitFor() == 0) {
			logger.info("命令执行结束！");
		} else {
			process.destroy();
			throw new RuntimeException("命令执行未正常结束！");
		}

		return ApplicationConstants.apkUrl + apkName;
	}
	
	@Test
	public void testCopyApk(){
		//deleteInsideFile("ctchannel_");
		List<String> list = getData();
		List<String> data = list.subList(0, 1);
		for (String channelNo : data) {
        	try {
        		String url = copyApk("ctclient"+ channelNo + ".apk", "ctchannel_", "ctchannel_"+channelNo);
        		System.out.println(url);
			} catch (Exception e) {
				System.out.println("复制过程出错：" + e.getMessage());
			}
		}
	}
	
	public static List<String> getData() {
		String[] strs = new String[] { "54560",
				"54559",
				"54558",
				"54557",
				"51810",
				"51809",
				"51808",
				"51807",
				"51806",
				"51805",
				"51804",
				"51803",
				"51802",
				"51801",
				"51800",
				"51799",
				"51798",
				"51797",
				"51796",
				"51795",
				"51794",
				"51793",
				"51792",
				"51791",
				"51790",
				"51789",
				"51788",
				"51787",
				"51786",
				"51785",
				"51784",
				"51783",
				"51782",
				"51781",
				"51780",
				"51779",
				"51778",
				"51777",
				"51776",
				"51775",
				"51774",
				"51773",
				"51772",
				"51771",
				"51770",
				"51769",
				"51768",
				"51767",
				"51766",
				"51765",
				"51764",
				"51763",
				"51762",
				"51761",
				"51760",
				"51759",
				"51758",
				"51757",
				"51756",
				"51755",
				"51754",
				"51753",
				"51752",
				"51751",
				"51750",
				"51749",
				"51748",
				"51747",
				"51746",
				"51745",
				"51744",
				"51743",
				"51742",
				"51741",
				"51740",
				"51739",
				"51738",
				"51737",
				"51736",
				"51735",
				"51734",
				"51733",
				"51732",
				"51731",
				"51730",
				"51729",
				"51728",
				"51727",
				"51726",
				"51725",
				"51724",
				"51723",
				"51722",
				"51721",
				"51720",
				"51719",
				"51718",
				"51717",
				"51716",
				"51715",
				"51714",
				"51713",
				"51712",
				"51711",
				"51710",
				"51709",
				"51708",
				"51707",
				"51706",
				"51705",
				"51704",
				"51703",
				"51702",
				"51701",
				"51700",
				"51699",
				"51698",
				"51697",
				"51696",
				"51695",
				"51694",
				"51693",
				"51692",
				"51691",
				"51690",
				"51689",
				"51688",
				"51687",
				"51686",
				"51685",
				"51684",
				"51683",
				"51682",
				"51681",
				"51680",
				"51679",
				"51678",
				"51677",
				"51676",
				"51675",
				"51674",
				"51673",
				"51672",
				"51671",
				"51670",
				"51669",
				"51668",
				"51667",
				"51666",
				"51665",
				"51664",
				"51663",
				"51662",
				"51661",
				"51660",
				"51659",
				"51658",
				"51657",
				"51656",
				"51655",
				"51654",
				"51653",
				"51652",
				"51651",
				"51650",
				"51649",
				"51648",
				"51647",
				"51646",
				"51645",
				"51644",
				"51643",
				"51642",
				"51641",
				"51640",
				"51639",
				"51638",
				"51637",
				"51636",
				"51635",
				"51634",
				"51633",
				"51632",
				"51631",
				"51630",
				"51629",
				"51628",
				"51627",
				"51626",
				"51625",
				"51624",
				"51623",
				"51622",
				"51621",
				"51620",
				"51619",
				"51618",
				"51617",
				"51616",
				"51615",
				"51614",
				"51613",
				"51612",
				"51611",
				"51610",
				"51609",
				"51608",
				"51607",
				"51606",
				"51605",
				"51604",
				"51603",
				"51602",
				"51601",
				"51600",
				"51599",
				"51598",
				"51597",
				"51596",
				"51595",
				"51594",
				"51593",
				"51592",
				"51591",
				"51590",
				"51589",
				"51588",
				"51587",
				"51586",
				"51585",
				"51584",
				"51583",
				"51582",
				"51581",
				"51580",
				"51579",
				"51578",
				"51577",
				"51576",
				"51575",
				"51574",
				"51573",
				"51572",
				"51571",
				"51570",
				"51569",
				"51568",
				"51567",
				"51566",
				"51565",
				"51564",
				"51563",
				"51562",
				"51561",
				"51560",
				"51559",
				"51558",
				"51557",
				"51556",
				"51555",
				"51554",
				"51553",
				"51552",
				"51551",
				"51550",
				"51549",
				"51548",
				"51547",
				"51546",
				"51545",
				"51544",
				"51543",
				"51542",
				"51541",
				"51540",
				"51539",
				"51538",
				"51537",
				"51536",
				"51535",
				"51534",
				"51533",
				"51532",
				"51531",
				"51530",
				"51529",
				"51528",
				"51527",
				"51526",
				"51525",
				"51524",
				"51523",
				"51522",
				"51521",
				"51520",
				"51519",
				"51518",
				"51517",
				"51516",
				"51515",
				"51514",
				"51513",
				"51512",
				"51511",
				"51510",
				"51509",
				"51508",
				"51507",
				"51506",
				"51505",
				"51504",
				"51503",
				"51502",
				"51501",
				"51500",
				"51499",
				"51498",
				"51497",
				"51496",
				"51495",
				"51494",
				"51493",
				"51492",
				"51491",
				"51490",
				"51489",
				"51488",
				"51487",
				"51486",
				"51485",
				"51484",
				"51483",
				"51482",
				"51481",
				"51480",
				"51479",
				"51478",
				"51477",
				"51476",
				"51475",
				"51474",
				"51473",
				"51472",
				"51471",
				"51470",
				"51469",
				"51468",
				"51467",
				"51466",
				"51465",
				"51464",
				"51463",
				"51462",
				"51461",
				"51460",
				"51459",
				"51458",
				"51457",
				"51456",
				"51455",
				"51454",
				"51453",
				"51452",
				"51451",
				"51450",
				"51449",
				"51448",
				"51447",
				"51446",
				"51445",
				"51444",
				"51443",
				"51442",
				"51441",
				"51440",
				"51439",
				"51438",
				"51437",
				"51436",
				"51435",
				"51434",
				"51433",
				"51432",
				"51431",
				"51430",
				"51429",
				"51428",
				"51427",
				"51426",
				"51425",
				"51424",
				"51423",
				"51422",
				"51421",
				"51420",
				"51419",
				"51418",
				"51417",
				"51416",
				"51415",
				"51414",
				"51413",
				"51412",
				"51411",
				"51410",
				"51409",
				"51408",
				"51407",
				"51406",
				"51405",
				"51404",
				"51403",
				"51402",
				"51401",
				"51400",
				"51399",
				"51398",
				"51397",
				"51396",
				"51395",
				"51394",
				"51393",
				"51392",
				"51391",
				"51390",
				"51389",
				"51388",
				"51387",
				"51386",
				"51385",
				"51384",
				"51383",
				"51382",
				"51381",
				"51380",
				"51379",
				"51378",
				"51377",
				"51376",
				"51375",
				"51374",
				"51373",
				"51372",
				"51371",
				"51370",
				"51369",
				"51368",
				"51367",
				"51366",
				"51365",
				"51364",
				"51363",
				"51362",
				"51361",
				"51360",
				"51359",
				"51358",
				"51357",
				"51356",
				"51355",
				"51354",
				"51353",
				"51352",
				"51351",
				"51350",
				"51349",
				"51348",
				"51347",
				"51346",
				"51345",
				"51344",
				"51343",
				"51342",
				"51341",
				"51340",
				"51339",
				"51338",
				"51337",
				"51336",
				"51335",
				"51334",
				"51333",
				"51332",
				"51331",
				"51330",
				"51329",
				"51328",
				"51327",
				"51326",
				"51325",
				"51324",
				"51323",
				"51322",
				"51321",
				"51320",
				"51319",
				"51318",
				"51317",
				"51316",
				"51315",
				"51314",
				"51313",
				"51312",
				"51311",
				"51310",
				"51309",
				"51308",
				"51307",
				"51306",
				"51305",
				"51304",
				"51303",
				"51302",
				"51301",
				"51300",
				"51299",
				"51298",
				"51297",
				"51296",
				"51295",
				"51294",
				"51293",
				"51292",
				"53320",
				"51284",
				"51279",
				"51275",
				"51273",
				"51269",
				"51261",
				"51260",
				"51258",
				"51254",
				"51246",
				"51243",
				"51241",
				"51238",
				"51237",
				"51229",
				"51222",
				"51218",
				"51217",
				"51214",
				"51211",
				"51207",
				"51197",
				"51192",
				"51182",
				"51179",
				"51177",
				"51271",
				"51255",
				"51252",
				"51249",
				"51248",
				"51224",
				"51223",
				"51219",
				"51213",
				"51208",
				"51206",
				"51199",
				"51189",
				"51178",
				"51173",
				"51291",
				"51288",
				"51285",
				"51278",
				"51257",
				"51212",
				"51198",
				"51193",
				"51185",
				"51181",
				"51282",
				"51268",
				"51228",
				"50111",
				"50110",
				"50109",
				"50108",
				"51290",
				"51287",
				"51283",
				"51276",
				"51274",
				"51234",
				"51210",
				"51196",
				"53312",
				"53326",
				"51256",
				"51232",
				"51215",
				"51194",
				"51289",
				"51286",
				"51264",
				"51240",
				"51227",
				"51203",
				"51190",
				"51263",
				"51230",
				"51205",
				"51172",
				"51272",
				"51262",
				"51250",
				"51204",
				"53336",
				"53316",
				"53328",
				"53325",
				"53323",
				"53318",
				"53338",
				"53337",
				"53334",
				"53333",
				"53331",
				"53330",
				"53329",
				"53317",
				"53315",
				"53314",
				"53313",
				"51280",
				"51277",
				"51267",
				"51247",
				"51244",
				"51239",
				"51236",
				"51233",
				"51226",
				"51225",
				"51221",
				"51220",
				"51216",
				"51202",
				"51200",
				"51171",
				"51170",
				"51169",
				"51168",
				"51167",
				"51166",
				"51165",
				"51164",
				"51163",
				"51162",
				"51161",
				"51160",
				"51159",
				"51158",
				"51157",
				"51156",
				"51155",
				"51154",
				"51153",
				"51152",
				"51151",
				"51150",
				"51149",
				"51148",
				"51147",
				"51146",
				"51145",
				"51144",
				"51143",
				"51142",
				"51141",
				"51140",
				"51139",
				"51138",
				"51137",
				"51136",
				"51135",
				"51134",
				"51133",
				"51132",
				"51131",
				"51130",
				"51129",
				"51128",
				"51127",
				"51126",
				"51125",
				"51124",
				"51123",
				"51122",
				"51121",
				"51120",
				"51119",
				"51118",
				"51117",
				"51116",
				"51115",
				"51114",
				"51113",
				"51112",
				"51111",
				"51110",
				"51109",
				"51108",
				"51107",
				"51106",
				"51105",
				"51104",
				"51103",
				"51102",
				"51101",
				"51100",
				"51099",
				"51098",
				"51097",
				"51096",
				"51095",
				"51094",
				"51093",
				"51092",
				"51091",
				"51090",
				"51089",
				"51088",
				"51087",
				"51086",
				"51085",
				"51084",
				"51083",
				"51082",
				"51081",
				"51080",
				"51079",
				"51078",
				"51077",
				"51076",
				"51075",
				"51074",
				"51073",
				"51072",
				"51071",
				"51070",
				"51069",
				"51068",
				"51067",
				"51066",
				"51065",
				"51064",
				"51063",
				"51062",
				"51061",
				"51060",
				"51059",
				"51058",
				"51057",
				"51056",
				"51055",
				"51054",
				"51053",
				"51052",
				"51051",
				"51050",
				"51049",
				"51048",
				"51047",
				"51046",
				"51045",
				"51044",
				"51043",
				"51042",
				"51041",
				"51040",
				"51039",
				"51038",
				"51037",
				"51036",
				"51035",
				"51034",
				"51033",
				"51032",
				"51031",
				"51030",
				"51029",
				"51028",
				"51027",
				"51026",
				"51025",
				"51024",
				"51023",
				"51022",
				"51021",
				"51020",
				"51019",
				"51018",
				"51017",
				"51016",
				"51015",
				"51014",
				"51013",
				"51012",
				"51011",
				"51010",
				"51009",
				"51008",
				"51007",
				"51006",
				"51005",
				"51004",
				"51003",
				"51002",
				"51001",
				"51000",
				"50999",
				"50998",
				"50997",
				"50996",
				"50995",
				"50994",
				"50993",
				"50992",
				"50991",
				"50990",
				"50989",
				"50988",
				"50987",
				"50986",
				"50985",
				"50984",
				"50983",
				"50982",
				"50981",
				"50980",
				"50979",
				"50978",
				"50977",
				"50976",
				"50975",
				"50974",
				"50973",
				"50972",
				"50971",
				"50970",
				"50969",
				"50968",
				"50967",
				"50966",
				"50965",
				"50964",
				"50963",
				"50962",
				"50961",
				"50960",
				"50959",
				"50958",
				"50957",
				"50956",
				"50955",
				"50954",
				"50953",
				"50952",
				"50951",
				"50950",
				"50949",
				"50948",
				"50947",
				"50946",
				"50945",
				"50944",
				"50943",
				"50942",
				"50941",
				"50940",
				"50939",
				"50938",
				"50937",
				"50936",
				"50935",
				"50934",
				"50933",
				"50932",
				"50931",
				"50930",
				"50929",
				"50928",
				"50927",
				"50926",
				"50925",
				"50924",
				"50923",
				"50922",
				"50921",
				"50920",
				"50919",
				"50918",
				"50917",
				"50916",
				"50915",
				"50914",
				"50913",
				"50912",
				"50911",
				"50910",
				"50909",
				"50908",
				"50907",
				"50906",
				"50905",
				"50904",
				"50903",
				"50902",
				"50901",
				"50900",
				"50899",
				"50898",
				"50897",
				"50896",
				"50895",
				"50894",
				"50893",
				"50892",
				"50891",
				"50890",
				"50889",
				"50888",
				"50887",
				"50886",
				"50885",
				"50884",
				"50883",
				"50882",
				"50881",
				"50880",
				"50879",
				"50878",
				"50877",
				"50876",
				"50875",
				"50874",
				"50873",
				"50872",
				"50871",
				"50870",
				"50869",
				"50868",
				"50867",
				"50866",
				"50865",
				"50864",
				"50863",
				"50862",
				"50861",
				"50860",
				"50859",
				"50858",
				"50857",
				"50856",
				"50855",
				"50854",
				"50853",
				"50852",
				"50851",
				"50850",
				"50849",
				"50848",
				"50847",
				"50846",
				"50845",
				"50844",
				"50843",
				"50842",
				"50841",
				"50840",
				"50839",
				"50838",
				"50837",
				"50836",
				"50835",
				"50834",
				"50833",
				"50832",
				"50831",
				"50830",
				"50829",
				"50828",
				"50827",
				"50826",
				"50825",
				"50824",
				"50823",
				"50822",
				"50821",
				"50820",
				"50819",
				"50818",
				"50817",
				"50816",
				"50815",
				"50814",
				"50813",
				"50812",
				"50811",
				"50810",
				"50809",
				"50808",
				"50807",
				"50806",
				"50805",
				"50804",
				"50803",
				"50802",
				"50801",
				"50800",
				"50799",
				"50798",
				"50797",
				"50796",
				"50795",
				"50794",
				"50793",
				"50792",
				"50791",
				"50790",
				"50789",
				"50788",
				"50787",
				"50786",
				"50785",
				"50784",
				"50783",
				"50782",
				"50781",
				"50780",
				"50779",
				"50778",
				"50777",
				"50776",
				"50775",
				"50774",
				"50773",
				"50772",
				"50771",
				"50770",
				"50769",
				"50768",
				"50767",
				"50766",
				"50765",
				"50764",
				"50763",
				"50762",
				"50761",
				"50760",
				"50759",
				"50758",
				"50757",
				"50756",
				"50755",
				"50754",
				"50753",
				"50752",
				"50751",
				"50750",
				"50749",
				"50748",
				"50747",
				"50746",
				"50745",
				"50744",
				"50743",
				"50742",
				"50741",
				"50740",
				"50739",
				"50738",
				"50737",
				"50736",
				"50735",
				"50734",
				"50733",
				"50732",
				"50731",
				"50730",
				"50729",
				"50728",
				"50727",
				"50726",
				"50725",
				"50724",
				"50723",
				"50722",
				"50721",
				"50720",
				"50719",
				"50718",
				"50717",
				"50716",
				"50715",
				"50714",
				"50713",
				"50712",
				"50711",
				"50710",
				"50709",
				"50708",
				"50707",
				"50706",
				"50705",
				"50704",
				"50703",
				"50702",
				"50701",
				"50700",
				"50699",
				"50698",
				"50697",
				"50696",
				"50695",
				"50694",
				"50693",
				"50692",
				"50691",
				"50690",
				"50689",
				"50688",
				"50687",
				"50686",
				"50685",
				"50684",
				"50683",
				"50682",
				"50681",
				"50680",
				"50679",
				"50678",
				"50677",
				"50676",
				"50675",
				"50674",
				"50673",
				"50672",
				"50671",
				"50670",
				"50669",
				"50668",
				"50667",
				"50666",
				"50665",
				"50664",
				"50663",
				"50662",
				"50661",
				"50660",
				"50659",
				"50658",
				"50657",
				"50656",
				"50655",
				"50654",
				"50653",
				"50652",
				"50651",
				"50650",
				"50649",
				"50648",
				"50647",
				"50646",
				"50645",
				"50644",
				"50643",
				"50642",
				"50641",
				"50640",
				"50639",
				"50638",
				"50637",
				"50636",
				"50635",
				"50634",
				"50633",
				"50632",
				"50631",
				"50630",
				"50629",
				"50628",
				"50627",
				"50626",
				"50625",
				"50624",
				"50623",
				"50622",
				"50621",
				"50620",
				"50619",
				"50618",
				"50617",
				"50616",
				"50615",
				"50614",
				"50613",
				"50612",
				"50611",
				"50610",
				"50609",
				"50608",
				"50607",
				"50606",
				"50605",
				"50604",
				"50603",
				"50602",
				"50601",
				"50600",
				"50599",
				"50598",
				"50597",
				"50596",
				"50595",
				"50594",
				"50593",
				"50592",
				"50591",
				"50590",
				"50589",
				"50588",
				"50587",
				"50586",
				"50585",
				"50584",
				"50583",
				"50582",
				"50581",
				"50580",
				"50579",
				"50578",
				"50577",
				"50576",
				"50575",
				"50574",
				"50573",
				"50572",
				"50571",
				"50570",
				"50569",
				"50568",
				"50567",
				"50566",
				"50565",
				"50564",
				"50563",
				"50562",
				"50561",
				"50560",
				"50559",
				"50558",
				"50557",
				"50556",
				"50555",
				"50554",
				"50553",
				"50552",
				"50551",
				"50550",
				"50549",
				"50548",
				"50547",
				"50546",
				"50545",
				"50544",
				"50543",
				"50542",
				"50541",
				"50540",
				"50539",
				"50538",
				"50537",
				"50536",
				"50535",
				"50534",
				"50533",
				"50532",
				"50531",
				"50530",
				"50529",
				"50528",
				"50527",
				"50526",
				"50525",
				"50524",
				"50523",
				"50522",
				"50521",
				"50520",
				"50519",
				"50518",
				"50517",
				"50516",
				"50515",
				"50514",
				"50513",
				"50512",
				"50511",
				"50510",
				"50509",
				"50508",
				"50507",
				"50506",
				"50505",
				"50504",
				"50503",
				"50502",
				"50501",
				"50500",
				"50499",
				"50498",
				"50497",
				"50496",
				"50495",
				"50494",
				"50493",
				"50492",
				"50491",
				"50490",
				"50489",
				"50488",
				"50487",
				"50486",
				"50485",
				"50484",
				"50483",
				"50482",
				"50481",
				"50480",
				"50479",
				"50478",
				"50477",
				"50476",
				"50475",
				"50474",
				"50473",
				"50472",
				"50471",
				"50470",
				"50469",
				"50468",
				"50467",
				"50466",
				"50465",
				"50464",
				"50463",
				"50462",
				"50461",
				"50460",
				"50459",
				"50458",
				"50457",
				"50456",
				"50455",
				"50454",
				"50453",
				"50452",
				"50451",
				"50450",
				"50449",
				"50448",
				"50447",
				"50446",
				"50445",
				"50444",
				"50443",
				"50442",
				"50441",
				"50440",
				"50439",
				"50438",
				"50437",
				"50436",
				"50435",
				"50434",
				"50433",
				"50432",
				"50431",
				"50430",
				"50429",
				"50428",
				"50427",
				"50426",
				"50425",
				"50424",
				"50423",
				"50422",
				"50421",
				"50420",
				"50419",
				"50418",
				"50417",
				"50416",
				"50415",
				"50414",
				"50413",
				"50412",
				"50411",
				"50410",
				"50409",
				"50408",
				"50407",
				"50406",
				"50405",
				"50404",
				"50403",
				"50402",
				"50401",
				"50400",
				"50399",
				"50398",
				"50397",
				"50396",
				"50395",
				"50394",
				"50393",
				"50392",
				"50391",
				"50390",
				"50389",
				"50388",
				"50387",
				"50386",
				"50385",
				"50384",
				"50383",
				"50382",
				"50381",
				"50380",
				"50379",
				"50378",
				"50377",
				"50376",
				"50375",
				"50374",
				"50373",
				"50372",
				"50371",
				"50370",
				"50369",
				"50368",
				"50367",
				"50366",
				"50365",
				"50364",
				"50363",
				"50362",
				"50361",
				"50360",
				"50359",
				"50358",
				"50357",
				"50356",
				"50355",
				"50354",
				"50353",
				"50352",
				"50351",
				"50350",
				"50349",
				"50348",
				"50347",
				"50346",
				"50345",
				"50344",
				"50343",
				"50342",
				"50341",
				"50340",
				"50339",
				"50338",
				"50337",
				"50336",
				"50335",
				"50334",
				"50333",
				"50332",
				"50331",
				"50330",
				"50329",
				"50328",
				"50327",
				"50326",
				"50325",
				"50324",
				"50323",
				"50322",
				"50321",
				"50320",
				"50319",
				"50318",
				"50317",
				"50316",
				"50315",
				"50314",
				"50313",
				"50312",
				"50311",
				"50310",
				"50309",
				"50308",
				"50307",
				"50306",
				"50305",
				"50304",
				"50303",
				"50302",
				"50301",
				"50300",
				"50299",
				"50298",
				"50297",
				"50296",
				"50295",
				"50294",
				"50293",
				"50292",
				"50291",
				"50290",
				"50289",
				"50288",
				"50287",
				"50286",
				"50285",
				"50284",
				"50283",
				"50282",
				"50281",
				"50280",
				"50279",
				"50278",
				"50277",
				"50276",
				"50275",
				"50274",
				"50273",
				"50272",
				"50271",
				"50270",
				"50269",
				"50268",
				"50267",
				"50266",
				"50265",
				"50264",
				"50263",
				"50262",
				"50261",
				"50260",
				"50259",
				"50258",
				"50257",
				"50256",
				"50255",
				"50254",
				"50253",
				"50252",
				"50251",
				"50250",
				"50249",
				"50248",
				"50247",
				"50246",
				"50245",
				"50244",
				"50243",
				"50242",
				"50241",
				"50235",
				"50234",
				"50233",
				"50232",
				"50231",
				"50230",
				"50229",
				"50228",
				"50227",
				"50226",
				"50225",
				"50224",
				"50223",
				"50222",
				"50221",
				"50220",
				"50219",
				"50218",
				"50217",
				"50216",
				"50215",
				"50214",
				"50213",
				"50212",
				"50211",
				"50210",
				"50209",
				"50208",
				"50207",
				"50206",
				"50205",
				"50204",
				"50203",
				"50202",
				"50201",
				"50200",
				"50199",
				"50198",
				"50197",
				"50196",
				"50195",
				"50194",
				"50193",
				"50192",
				"50191",
				"50190",
				"50189",
				"50188",
				"50187",
				"50186",
				"50185",
				"50184",
				"50183",
				"50182",
				"50181",
				"50180",
				"50179",
				"50178",
				"50177",
				"50176",
				"50175",
				"50174",
				"50173",
				"50172",
				"50171",
				"50170",
				"50169",
				"50168",
				"50167",
				"50166",
				"50165",
				"50164",
				"50163",
				"50162",
				"50161",
				"50160",
				"50159",
				"50158",
				"50157",
				"50156",
				"50155",
				"50154",
				"50153",
				"50152",
				"50151",
				"50150",
				"50149",
				"50148",
				"50147",
				"50146",
				"50145",
				"50144",
				"50143",
				"50142",
				"50141",
				"50140",
				"50139",
				"50138",
				"50137",
				"50136",
				"50135",
				"50134",
				"50133",
				"50132",
				"50131",
				"50130",
				"50129",
				"50128",
				"50127",
				"50126",
				"50125",
				"50124",
				"50123",
				"50122",
				"50121",
				"50120",
				"50119",
				"50118",
				"50117",
				"50116",
				"50115",
				"50114",
				"50113",
				"50112",
				"51191",
				"51186",
				"51176",
				"53327",
				"50107",
				"50106",
				"50105",
				"50104",
				"50103",
				"50102",
				"50101",
				"50100",
				"50099",
				"50098",
				"50097",
				"50096",
				"50095",
				"50094",
				"50093",
				"50092",
				"50091",
				"50090",
				"50089",
				"50088",
				"50087",
				"50086",
				"50085",
				"50084",
				"50083",
				"50082",
				"50081",
				"50080",
				"50079",
				"50078",
				"50077",
				"50076",
				"50075",
				"50074",
				"50073",
				"50072",
				"50071",
				"50070",
				"50069",
				"50068",
				"50067",
				"50066",
				"50065",
				"50064",
				"50063",
				"50062",
				"50061",
				"50060",
				"50059",
				"50058",
				"50057",
				"50056",
				"50055",
				"50054",
				"50053",
				"50052",
				"50051",
				"50050",
				"50049",
				"50048",
				"50047",
				"50046",
				"50045",
				"50044",
				"50043",
				"50042",
				"50041",
				"50040",
				"50039",
				"50038",
				"50037",
				"50036",
				"50035",
				"50034",
				"50033",
				"50032",
				"50031",
				"50030",
				"50029",
				"50028",
				"50027",
				"50026",
				"50025",
				"50024",
				"50023",
				"50022",
				"50021",
				"50020",
				"50019",
				"50018",
				"50017",
				"50016",
				"50015",
				"50014",
				"50013",
				"50007",
				"50006",
				"50005",
				"50004",
				"50003",
				"50002",
				"50001",
				"50240",
				"50239",
				"50238",
				"50237",
				"50236",
				"50012",
				"50011",
				"50010",
				"50009",
				"50008" };

		return Arrays.asList(strs);

	}

	 
}


//多线程复制文件
class CopyThread extends Thread {
	private String excludeFileName;// 排除的文件
	private String addFileName;// 添加的文件
	private String zipName;
	private int start;// start指定起始位置，end指定结束位置
	private int end;
	
	// 构造CopyThread方法
	public CopyThread(String zipName,String excludeFileName, String addFileName, int start, int end) {
	   this.excludeFileName = excludeFileName;//要复制的源文件路径
       this.addFileName = addFileName;//复制到的文件路径
       this.zipName = zipName;
       this.start = start;//复制起始位置
       this.end = end;//复制结束位置
	}
	
	@Override
	public void run() {
		String srcPath = "D:\\java\\download\\client\\demo\\ctclient.apk";
		String destPath = "D:\\java\\download\\client\\" + zipName;
		// 构建目录
		//createDirectory("");

		try (ZipOutputStream out = new ZipOutputStream(new FileOutputStream(destPath))) {
			
			RandomAccessFile randomIn = new RandomAccessFile(srcPath, "r");
			RandomAccessFile randomOut = new RandomAccessFile(destPath, "rw");
			randomIn.seek(start);// 将输入跳转到指定位置
			randomOut.seek(start);// 从指定位置开始写
			FileChannel inChannel = randomIn.getChannel(); 
			FileChannel outChannel = randomOut.getChannel();
			//锁住需要操作的区域,false代表锁住
			FileLock lock = outChannel.lock(start,(end-start), false);
			inChannel.transferTo(start,(end-start), outChannel);
			lock.release();//释放锁
			
			// 添加文件 META-INF/ctchannel_渠道号
			ZipEntry e = new ZipEntry(addFileName);
			out.putNextEntry(e);
			out.closeEntry();
			
			randomOut.close();//从里到外关闭文件
			randomIn.close();//关闭文件

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
