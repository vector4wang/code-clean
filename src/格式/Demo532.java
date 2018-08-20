package 格式;

import java.net.Socket;

/**
 * @author vector
 * @Data 2018/8/20 0020
 * @Description 水平对齐
 */
public class Demo532 {

}
class　FitNesseExpediter implements ResponseSender{
	private　　Socket　　　　　　　 socket;
	private　　 InputStream　　　 input;
	private　　 OutputStream　　　output;
	private　　 Request　　　　　　 request;
	private　　 Response　　　　　　response;
	private　　 FitNesseContext　context;
	protected　long　　　　　　　　　requestParsingTimeLimit;
	private　　 long　　　　　　　　 requestProgress;
	private　　 long　　　　　　　　 requestParsingDeadline;
	private　　 boolean　　　　　　 hasError;

	public FitNesseExpediter(Socket s, FitNesseContext context)　throws Exception{
		this.context=　　　　　　　　 context;
		socket=　　　　　　　　　　　　　s;
		input=　　　　　　　　　　　　　 s.getInputStream();
		output=　　　　　　　　　　　　　s.getOutputStream();
		requestParsingTimeLimit=10000;
	}
}

public class FitNesseExpediter implements ResponseSender {

	private Socket socket;

	private InputStream input;

	private OutputStream output;

	private Request request;

	private Response response;
	private FitNesseContext context;

	protected long requestParsingTimeLimit;

	private long requestProgress;

	private long requestParsingDeadline;

	private boolean hasError;

	public FitNesseExpediter(Socket s, FitNesseContext context) throws Exception {
		this.context = context;
		socket = s;
		input = s.getInputStream();
		output = s.getOutputStream();
		requestParsingTimeLimit = 10000;

	}
}
