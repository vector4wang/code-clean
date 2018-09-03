package 并发编程;

public class Demo1398 {
	public synchronized String nextUrlOrNull() {
		if (hasNext()) {
			String url = urlGenerator.next();
			Thread.yield(); // inserted for testing.
			updateHasNext();
			return url;
		}
		return null;
	}

}
