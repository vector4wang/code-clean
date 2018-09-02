package 系统;

public class Demo112 {

	public Service getService() {
		if (service == null)
			service = new MyServiceImpl(...); // Good enough default for most cases?
		return service;

	}
}

public interface BankLocal extends java.ejb.EJBLocalObject {

	String getStreetAddr1() throws EJBException;

	String getStreetAddr2() throws EJBException;

	String getCity() throws EJBException;

	String getState() throws EJBException;

	String getZipCode() throws EJBException;

	void setStreetAddr1(String street1) throws EJBException;

	void setStreetAddr2(String street2) throws EJBException;

	void setCity(String city) throws EJBException;

	void setState(String state) throws EJBException;

	void setZipCode(String zip) throws EJBException;

	Collection getAccounts() throws EJBException;

	void setAccounts(Collection accounts) throws EJBException;

	void addAccount(AccountDTO accountDTO) throws EJBException;

}


public abstract class Bank implements javax.ejb.EntityBean {
	// 业务逻辑...

	public abstract String getStreetAddr1();

	public abstract String getStreetAddr2();

	public abstract String getCity();

	public abstract String getState();

	public abstract String getZipCode();

	public abstract void setStreetAddr1(String street1);

	public abstract void setStreetAddr2(String street2);

	public abstract void setCity(String city);

	public abstract void setState(String state);

	public abstract void setZipCode(String zip);

	public abstract Collection getAccounts();

	public abstract void setAccounts(Collection accounts);

	public void addAccount(AccountDTO accountDTO) {
		InitialContext context = new InitialContext();
		AccountHomeLocal accountHome = context.lookup("AccountHomeLocal");
		AccountLocal account = accountHome.create(accountDTO);
		Collection accounts = getAccounts();
		accounts.add(account);

	}
	// EJB container logic

	public abstract void setId(Integer id);

	public abstract Integer getId();

	public Integer ejbCreate(Integer id) { ...}

	public void ejbPostCreate(Integer id) { ...}
	// The rest had to be implemented but were usually empty:

	public void setEntityContext(EntityContext ctx) {
	}

	public void unsetEntityContext() {
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	}

	public void ejbLoad() {
	}

	public void ejbStore() {
	}

	public void ejbRemove() {
	}

}