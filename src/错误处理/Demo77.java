package 错误处理;

import java.util.Collections;

/**
 * @author vector
 * @Data 2018/8/22 0022
 * @Description 别返回null值
 */
public class Demo77 {
	public void registerItem(Item item) {
		if (item != null) {
			ItemRegistry registry = peristentStore.getItemRegistry();
			if (registry != null) {
				Item existing = registry.getItem(item.getID());
				if (existing.getBillingPeriod().hasRetailOwner()) {
					existing.register(item);
				}
			}
		}
	}

	void test() {
		List<Employee> employees = getEmployees();
		if (employees != null) {
			for (Employee e : employees) {
				totalPay += e.getPay();
			}
		}
	}

	public List<Employee> getEmployees() {
		if ( ..there are no employees .. )
		return Collections.emptyList();

	}
}
