package logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(LoggerTest.class);
		logger.info("1","2","3","4","5","6","7","Hello World");
	}
}
