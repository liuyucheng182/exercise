package webcrawler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class WebCrawler {
    @Test
	public void getMailsByText() throws IOException{
	  BufferedReader reader = new BufferedReader(new FileReader("E:\\DxDiag.txt"));
	  String line = null;
	  Pattern p = Pattern.compile("\\w+@\\w+\\.\\w+");
	  while((line=reader.readLine())!=null){
		 Matcher matcher = p.matcher(line);
		 while(matcher.find()){
			 System.out.println(matcher.group());
		 }
	  }
  }
    @Test
	public void getMailsByUrl() throws IOException{
		URL url = new URL("http://developer.51cto.com/art/201103/248141.htm");
		URLConnection conn = url.openConnection();
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line = null;
		Pattern p = Pattern.compile("\\d+");
		while ((line = reader.readLine()) != null) {
			Matcher matcher = p.matcher(line);
			while (matcher.find()) {
				System.out.println(matcher.group());	   
			}
			//Thread.sleep(1); //延时防止被对方屏蔽 
		}
	}
}
