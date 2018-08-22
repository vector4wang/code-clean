package 错误处理;

/**
 * @author vector
 * @Data 2018/8/22 0022
 * @Description 定义常规流程
 */
public class Demo76 {
	void test1() {
		try {
			MealExpenses expenses = expenseReportDAO.getMeals(employee.getID());
			m_total += expenses.getTotal();
		} catch (MealExpensesNotFound e) {
			m_total += getMealPerDiem();
		}

		================

		MealExpenses expenses = expenseReportDAO.getMeals(employee.getID());
		m_total += expenses.getTotal();
	}
}

public class PerDiemMealExpenses implements MealExpenses {

	public int getTotal() {
		// return the per diem default
	}

}
