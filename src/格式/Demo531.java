package 格式;

/**
 * @author vector
 * @Data 2018/8/20 0020
 * @Description 水平方向上的区隔与靠近
 */
public class Demo531 {
	private void measureLine(String line) {
		lineCount++;
		int lineSize = line.length();
		totalChars += lineSize;
		lineWidthHistogram.addLine(lineSize, lineCount);
		recordWidestLine(lineSize);

	}
}

public class Quadratic {

	public static double root1(double a, double b, double c) {
		double determinant = determinant(a, b, c);
		return (-b + Math.sqrt(determinant)) / (2 * a);

	}

	public static double root2(int a, int b, int c) {
		double determinant = determinant(a, b, c);
		return (-b - Math.sqrt(determinant)) / (2 * a);

	}

	private static double determinant(double a, double b, double c) {
		return b * b - 4 * a * c;

	}

}