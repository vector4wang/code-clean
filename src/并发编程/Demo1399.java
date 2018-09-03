package 并发编程;

public class Demo1399 {
	public synchronized String nextUrlOrNull() {
		if (hasNext()) {
			ThreadJiglePoint.jiggle();
			String url = urlGenerator.next();
			ThreadJiglePoint.jiggle();
			updateHasNext();
			ThreadJiglePoint.jiggle();
			return url;
		}
		return null;
	}
}
