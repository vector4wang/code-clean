package 注释;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * @author vector
 * @Data 2018/8/17 0017
 * @Description 警示
 */
public class Demo435 {
	// Don't run unless you
	// have some time to kill.
	public void _testWithReallyBigFile() {
		writeLinesToFile(10000000);
		response.setBody(testFile);
		response.readyToSend(this);
		String responseString = output.toString();
		assertSubString("Content-Length: 1000000000", responseString);
		assertTrue(bytesSent > 1000000000);
	}

	public static SimpleDateFormat makeStandardHttpDateFormat() {
		//SimpleDateFormat is not thread safe,
		//so we need to create each instance independently.
		SimpleDateFormat df = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
		df.setTimeZone(TimeZone.getTimeZone("GMT"));
		return df;
	}
}
