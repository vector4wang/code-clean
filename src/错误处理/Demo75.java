package 错误处理;

/**
 * @author vector
 * @Data 2018/8/22 0022
 * @Description 依调用者需要定义异常类
 */
public class Demo75 {
	void test1() {
		ACMEPort port = new ACMEPort(12);
		try {
			port.open();

		} catch (DeviceResponseException e) {
			reportPortError(e);
			logger.log("Device response exception", e);

		} catch (ATM1212UnlockedException e) {
			reportPortError(e);
			logger.log("Unlock exception", e);

		} catch (GMXError e) {
			reportPortError(e);
			logger.log("Device response exception");

		} finally {
			…
		}

		===========================

		LocalPort port = new LocalPort(12);
		try {
			port.open();

		} catch (PortDeviceFailure e) {
			reportError(e);
			logger.log(e.getMessage(), e);

		} finally {

…
		}
	}
}

public class LocalPort {

	private ACMEPort innerPort;

	public LocalPort(int portNumber) {
		innerPort = new ACMEPort(portNumber);

	}

	public void open() {
		try {
			innerPort.open();

		} catch (DeviceResponseException e) {
			throw new PortDeviceFailure(e);

		} catch (ATM1212UnlockedException e) {
			throw new PortDeviceFailure(e);

		} catch (GMXError e) {
			throw new PortDeviceFailure(e);

		}

	}

…

}