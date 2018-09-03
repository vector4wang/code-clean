package 系统;

public class Demo115 {
	public static void main(String[] args) {
		XmlBeanFactory bf = new XmlBeanFactory(new ClassPathResource("app.xml", getClass()));
		Bank bank = (Bank) bf.getBean("bank");
	}
}

@Entity
@Table(name = "BANKS")
public class Bank implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Embeddable // An object "inlined" in Bank’s DB row
	public class Address {

		protected String streetAddr1;

		protected String streetAddr2;

		protected String city;

		protected String state;
		protected String zipCode;

	}

	@Embedded
	private Address address;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "bank")
	private Collection<Account> accounts = new ArrayList<Account>();

	public int getId() {
		return id;

	}

	public void setId(int id) {
		this.id = id;

	}

	public void addAccount(Account account) {
		account.setBank(this);
		accounts.add(account);

	}

	public Collection<Account> getAccounts() {
		return accounts;

	}

	public void setAccounts(Collection<Account> accounts) {
		this.accounts = accounts;

	}
}
