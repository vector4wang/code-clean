package 格式;

import java.net.Socket;

/**
 * @author vector
 * @Data 2018/8/20 0020
 * @Description 缩进
 */
public class Demo533 {
}
public class FitNesseServer implements SocketServer { private FitNesseContext

		context; public FitNesseServer(FitNesseContext context) { this.context =

		context; } public void serve(Socket s) { serve(s, 10000); } public void

		serve(Socket s, long requestTimeout) { try { FitNesseExpediter sender = new

				FitNesseExpediter(s, context);

			sender.setRequestParsingTimeLimit(requestTimeout); sender.start(); }

		catch(Exception e) { e.printStackTrace(); } } }

-----

public class FitNesseServer implements SocketServer {

	private FitNesseContext context;

	public FitNesseServer(FitNesseContext context) {
		this.context = context;

	}

	public void serve(Socket s) {
		serve(s, 10000);

	}

	public void serve(Socket s, long requestTimeout) {
		try {
			FitNesseExpediter sender = new FitNesseExpediter(s, context);
			sender.setRequestParsingTimeLimit(requestTimeout);
			sender.start();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}

public class CommentWidget extends TextWidget
{

	public static final String REGEXP = "^#[^\r\n]*(?:(?:\r\n)|\n|\r)?";

	public CommentWidget(ParentWidget parent, String text){super(parent, text);}

	public String render() throws Exception {return ""; }
}

我更喜欢扩展和缩进范围，就像这样：

public class CommentWidget extends TextWidget {

	public static final String REGEXP = "^#[^\r\n]*(?:(?:\r\n)|\n|\r)?";

	public CommentWidget(ParentWidget parent, String text) {

		super(parent, text);

	}

	public String render() throws Exception {

		return "";

	}

}