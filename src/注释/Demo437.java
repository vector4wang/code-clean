package 注释;

/**
 * @author vector
 * @Data 2018/8/17 0017
 * @Description 放大
 */
public class Demo437 {
	String listItemContent = match.group(3).trim();
	// the trim is real important. It removes the starting
	// spaces that could cause the item to be recognized
	// as another list.
	new ListItemWidget(this,listItemContent, this.level +1);
	return buildList(text.substring(match.end()));
}
