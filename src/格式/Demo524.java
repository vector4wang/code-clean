package 格式;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author vector
 * @Data 2018/8/20 0020
 * @Description 垂直距离
 */
public class Demo524 {

	private static void readPreferences() {
		InputStream is = null;
		try {
			is = new FileInputStream(getPreferencesFile());
			setPreferences(new Properties(getPreferences()));
			getPreferences().load(is);

		} catch (IOException e) {
			try {
				if (is != null)
					is.close();

			} catch (IOException e1) {
			}

		}

	}

	public int countTestCases() {
		int count = 0;
		for (Test each : tests)
			count += each.countTestCases();
		return count;

	}

	for(XmlTest test :m_suite.getTests()){
		TestRunner tr = m_runnerFactory.newTestRunner(this, test);
		tr.addListener(m_textReporter);
		m_testRunners.add(tr);
		invoker = tr.getInvoker();
		for (ITestNGMethod m : tr.getBeforeSuiteMethods()) {
			beforeSuiteMethods.put(m.getMethod(), m);

		}
		for (ITestNGMethod m : tr.getAfterSuiteMethods()) {
			afterSuiteMethods.put(m.getMethod(), m);

		}

	}

}

public class TestSuite implements Test {

	static public Test createTest(Class<? extends TestCase> theClass, String name) {

...
	}

	public static Constructor<? extends TestCase> getTestConstructor(Class<? extends TestCase> theClass)
			throws NoSuchMethodException {

...
	}

	public static Test warning(final String message) {

...
	}

	private static String exceptionToString(Throwable t) {

...
	}

	private String fName;

	private Vector<Test> fTests = new Vector<Test>(10);

	public TestSuite() {
	}

	public TestSuite(final Class<? extends TestCase> theClass) {

...
	}

	public TestSuite(Class<? extends TestCase> theClass, String name) {

...
	}

...............

}


public class WikiPageResponder implements SecureResponder {

	protected WikiPage page;

	protected PageData pageData;

	protected String pageTitle;

	protected Request request;

	protected PageCrawler crawler;

	public Response makeResponse(FitNesseContext context, Request request) throws Exception {
		String pageName = getPageNameOrDefault(request, "FrontPage");
		loadPage(pageName, context);
		if (page == null)
			return notFoundResponse(context, request);
		else
			return makePageResponse(context);

	}

	private String getPageNameOrDefault(Request request, String defaultPageName) {
		String pageName = request.getResource();
		if (StringUtil.isBlank(pageName))
			pageName = defaultPageName;
		return pageName;

	}

	protected void loadPage(String resource, FitNesseContext context) throws Exception {
		WikiPagePath path = PathParser.parse(resource);
		crawler = context.root.getPageCrawler();
		crawler.setDeadEndStrategy(new VirtualEnabledPageCrawler());
		page = crawler.getPage(context.root, path);
		if (page != null)
			pageData = page.getData();

	}

	private Response notFoundResponse(FitNesseContext context, Request request) throws Exception {
		return new NotFoundResponder().makeResponse(context, request);

	}

	private SimpleResponse makePageResponse(FitNesseContext context) throws Exception {
		pageTitle = PathParser.render(crawler.getFullPath(page));
		String html = makeHtml(context);
		SimpleResponse response = new SimpleResponse();
		response.setMaxAge(0);
		response.setContent(html);
		return response;

	}

...
}

public class Assert {

	static public void assertTrue(String message, boolean condition) {
		if (!condition)
			fail(message);

	}

	static public void assertTrue(boolean condition) {
		assertTrue(null, condition);

	}

	static public void assertFalse(String message, boolean condition) {
		assertTrue(message, !condition);

	}

	static public void assertFalse(boolean condition) {
		assertFalse(null, condition);

	}

...
}