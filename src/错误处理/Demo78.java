package 错误处理;

/**
 * @author vector
 * @Data 2018/8/22 0022
 * @Description TODO
 */
public class Demo78 {
}

public class MetricsCalculator {
	public double xProjection(Point p1, Point p2) {
		return (p2.x –p1.x) *1.5;
	}
…
}

public class MetricsCalculator {

	public double xProjection(Point p1, Point p2) {
		if (p1 == null || p2 == null) {
			throw InvalidArgumentException("Invalid argument for MetricsCalculator.xProjection");

		}
		return (p2.x –p1.x) *1.5;

	}

}

public class MetricsCalculator {

	public double xProjection(Point p1, Point p2) {
		assert p1 != null : "p1 should not be null";
		assert p2 != null : "p2 should not be null";
		return (p2.x –p1.x) *1.5;

	}
}
