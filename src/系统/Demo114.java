package 系统;

public class Demo114 {
}
// The abstraction of a bank.

public interface Bank {

	Collection<Account> getAccounts();

	void setAccounts(Collection<Account> accounts);

}

// BankImpl.java
// The "Plain Old Java Object" (POJO) implementing the abstraction.

public class BankImpl implements Bank {

	private List<Account> accounts;

	public Collection<Account> getAccounts() {
		return accounts;

	}

	public void setAccounts(Collection<Account> accounts) {
		this.accounts = new ArrayList<Account>();
		for (Account account : accounts) {
			this.accounts.add(account);

		}

	}

}
// BankProxyHandler.java
// "InvocationHandler" required by the proxy API.

public class BankProxyHandler implements InvocationHandler {

	private Bank bank;

	public BankHandler(Bank bank) {
		this.bank = bank;

	}
	// Method defined in InvocationHandler

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String methodName = method.getName();
		if (methodName.equals("getAccounts")) {
			bank.setAccounts(getAccountsFromDatabase());
			return bank.getAccounts();

		} else if (methodName.equals("setAccounts")) {
			bank.setAccounts((Collection<Account>) args[0]);
			setAccountsToDatabase(bank.getAccounts());
			return null;

		} else {

...
		}

	}
	// Lots of details here:

	protected Collection<Account> getAccountsFromDatabase() { ...}

	protected void setAccountsToDatabase(Collection<Account> accounts) { ...}

}
	// Somewhere else...

	Bank bank = (Bank) Proxy.newProxyInstance(Bank.class.getClassLoader(), new Class[]{Bank.class},
			new BankProxyHandler(new BankImpl()));
}