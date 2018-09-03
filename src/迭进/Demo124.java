package 迭进;

public class Demo124 {
	public void scaleToOneDimension(float desiredDimension, float imageDimension) {
		if (Math.abs(desiredDimension - imageDimension) < errorThreshold)
			return;
		float scalingFactor = desiredDimension / imageDimension;
		scalingFactor = (float) (Math.floor(scalingFactor * 100) * 0.01f);”
		RenderedOp newImage = ImageUtilities.getScaledImage(image, scalingFactor, scalingFactor);
		image.dispose();
		System.gc();
		image = newImage;
	}

	public synchronized void rotate(int degrees) {
		RenderedOp newImage = ImageUtilities.getRotatedImage(image, degrees);
		image.dispose();
		System.gc();
		image = newImage;
	}
=============

	public void scaleToOneDimension(float desiredDimension, float imageDimension) {
		if (Math.abs(desiredDimension - imageDimension) < errorThreshold)
			return;
		float scalingFactor = desiredDimension / imageDimension;
		scalingFactor = (float) (Math.floor(scalingFactor * 100) * 0.01f);
		replaceImage(ImageUtilities.getScaledImage(image, scalingFactor, scalingFactor));
	}

	public synchronized void rotate(int degrees) {
		replaceImage(ImageUtilities.getRotatedImage(image, degrees));
	}

	private void replaceImage(RenderedOp newImage) {
		image.dispose();
		System.gc();
		image = newImage;

	}
==========

	public class VacationPolicy {
		public void accrueUSDivisionVacation() {
			// code to calculate vacation based on hours worked to date
			// ...
			// code to ensure vacation meets US minimums
			// ...
			// code to apply vaction to payroll record
			// ...
		}

		public void accrueEUDivisionVacation() {
			// code to calculate vacation based on hours worked to date
			// ...
			// code to ensure vacation meets EU minimums
			// ...
			// code to apply vaction to payroll record
			// ...
		}
	}

	abstract public class VacationPolicy {
		public void accrueVacation() {
			calculateBaseVacationHours();
			alterForLegalMinimums();
			applyToPayroll();
		}

		private void calculateBaseVacationHours() { /* ... */ }

		;

		abstract protected void alterForLegalMinimums();

		private void applyToPayroll() { /* ... */ }

		;
	}

	public class USVacationPolicy extends VacationPolicy {
		@Override
		protected void alterForLegalMinimums() {
			// US specific logic
		}
	}

	public class EUVacationPolicy extends VacationPolicy {
		@Override
		protected void alterForLegalMinimums() {
			// EU specific logic
		}
	}
