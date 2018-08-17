package 注释;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author vector
 * @Data 2018/8/17 0017
 * @Description 对意图的解释
 */
public class Demo433 {
	public int compareTo(Object o) {
		if (o instanceof WikiPagePath) {
			WikiPagePath p = (WikiPagePath) o;
			String compressedName = StringUtil.join(names, "");
			String compressedArgumentName = StringUtil.join(p.names, "");
			return compressedName.compareTo(compressedArgumentName);
		}
		return 1; // we are greater because we are the right type.
	}


	public void testConcurrentAddWidgets() throws Exception {
		WidgetBuilder widgetBuilder = new WidgetBuilder(new Class[]{BoldWidget.class});
		String text = "'''bold text'''";
		ParentWidget parent = new BoldWidget(new MockWidgetRoot(), "'''bold text'''");
		AtomicBoolean failFlag = new AtomicBoolean();
		failFlag.set(false);
		//This is our best attempt to get a race condition
		//by creating large number of threads.
		for (int i = 0; i < 25000; i++) {
			WidgetBuilderThread widgetBuilderThread = new WidgetBuilderThread(widgetBuilder, text, parent, failFlag);
			Thread thread = new Thread(widgetBuilderThread);
			thread.start();
		}
		assertEquals(false, failFlag.get());
	}
}
