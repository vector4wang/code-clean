package 格式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author vector
 * @Data 2018/8/20 0020
 * @Description 概念间垂直方向上的区隔
 */
public class Demo522 {
}

public class BoldWidget extends ParentWidget {

	public static final String REGEXP = "'''.+?'''";

	private static final Pattern pattern = Pattern.compile("'''(.+?)'''", Pattern.MULTILINE + Pattern.DOTALL);

	public BoldWidget(ParentWidget parent, String text) throws Exception {
		super(parent);
		Matcher match = pattern.matcher(text);
		match.find();
		addChildWidgets(match.group(1));

	}

	public String render() throws Exception {
		StringBuffer html = new StringBuffer("<b>");
		html.append(childHtml()).append("</b>");
		return html.toString();

	}

}

public class BoldWidget extends ParentWidget {

	public static final String REGEXP = "'''.+?'''";

	private static final Pattern pattern = Pattern.compile("'''(.+?)'''", Pattern.MULTILINE + Pattern.DOTALL);

	public BoldWidget(ParentWidget parent, String text) throws Exception {
		super(parent);
		Matcher match = pattern.matcher(text);
		match.find();
		addChildWidgets(match.group(1));
	}

	public String render() throws Exception {
		StringBuffer html = new StringBuffer("<b>");
		html.append(childHtml()).append("</b>");
		return html.toString();

	}

}