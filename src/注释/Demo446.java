package 注释;

import java.net.SocketException;

/**
 * @author vector
 * @Data 2018/8/17 0017
 * @Description 废话注释
 */
public class Demo446 {
	/**

	 * Default constructor.

	 */
	protected AnnualDateRule() {
	}

	对吧？再看看这个：
	/** The day of the month. */

	private int dayOfMonth;

	还有这样的废话模范：

	/**

	 * Returns the day of the month.
	 * @return the day of the month.
	 */
	public int getDayOfMonth() {
		return dayOfMonth;

	}


	private void startSending() {
		try {
			doSending();
		} catch (SocketException e) {
			// normal. someone stopped the request.
		} catch (Exception e) {
			try {
				response.add(ErrorResponder.makeExceptionString(e));
				response.closeAll();
			} catch (Exception e1) {
				// Give me a break!
			}
		}
	}

	private void startSending() {
		try {
			doSending();

		} catch (SocketException e) {
			//normal. someone stopped the request.
		} catch (Exception e) {
			addExceptionAndCloseResponse(e);

		}

	}

	private void addExceptionAndCloseResponse(Exception e) {
		try {
			response.add(ErrorResponder.makeExceptionString(e));
			response.closeAll();

		} catch (Exception e1) {
		}

	}
}
