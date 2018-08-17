package 注释;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import sun.rmi.runtime.Log;
import sun.security.krb5.Realm;

import javax.management.MBeanRegistration;
import javax.naming.directory.DirContext;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author vector
 * @Data 2018/8/17 0017
 * @Description 多余的注释
 */
public class Demo442 {
	// Utility method that returns when this.closed is true. Throws an exception
	// if the timeout is reached.
	public synchronized void waitForClose(final long timeoutMillis) throws Exception {
		if (!closed) {
			wait(timeoutMillis);
			if (!closed)
				throw new Exception("MockResponseSender could not be closed");
		}
	}
}

public abstract class ContainerBase implements Container, Lifecycle, Pipeline, MBeanRegistration, Serializable {

	/**

	 * The processor delay for this component.

	 */
	protected int backgroundProcessorDelay = -1;

	/**

	 * The lifecycle event support for this component.

	 */

	protected LifecycleSupport lifecycle = new LifecycleSupport(this);

	/**

	 * The container event listeners for this Container.

	 */

	protected ArrayList listeners = new ArrayList();

	/**

	 * The Loader implementation with which this Container is

	 * associated.

	 */

	protected Loader loader = null;

	/**

	 * The Logger implementation with which this Container is

	 * associated.

	 */

	protected Log logger = null;

	/**
	 * Associated logger name.

	 */

	protected String logName = null;

	/**

	 * The Manager implementation with which this Container is

	 * associated.

	 */

	protected Manager manager = null;

	/**

	 * The cluster with which this Container is associated.

	 */

	protected Cluster cluster = null;

	/**

	 * The human-readable name of this Container.

	 */

	protected String name = null;

	/**

	 * The parent Container to which this Container is a child.

	 */

	protected Container parent = null;

	/**
	 * The parent class loader to be configured when we install a

	 * Loader.

	 */

	protected ClassLoader parentClassLoader = null;

	/**

	 * The Pipeline object with which this Container is

	 * associated.

	 */

	protected Pipeline pipeline = new StandardPipeline(this);

	/**

	 * The Realm with which this Container is associated.

	 */

	protected Realm realm = null;

	/**

	 * The resources DirContext object with which this Container

	 * is associated.

	 */

	protected DirContext resources = null;
}