package 类;

public class Demo103 {
}

public class Sql {

	public Sql(String table, Column[] columns)

	public String create()

	public String insert(Object[] fields)

	public String selectAll()

	public String findByKey(String keyColumn, String keyValue)

	public String select(Column column, String pattern)

	public String select(Criteria criteria)

	public String preparedInsert()

	private String columnList(Column[] columns)

	private String valuesList(Object[] fields, final Column[] columns)

	private String selectWithCriteria(String criteria)

	private String placeholderList(Column[] columns)

}

abstract public class Sql {

	public Sql(String table, Column[] columns)

	abstract public String generate();

}

public class CreateSql extends Sql {

	public CreateSql(String table, Column[] columns)

	@Override
	public String generate()

}

public class SelectSql extends Sql {

	public SelectSql(String table, Column[] columns)

	@Override
	public String generate()

}

public class InsertSql extends Sql {

	public InsertSql(String table, Column[] columns, Object[] fields)

	@Override
	public String generate()

	private String valuesList(Object[] fields, final Column[] columns)
}

public class SelectWithCriteriaSql extends Sql {

	public SelectWithCriteriaSql(String table, Column[] columns, Criteria criteria)

	@Override
	public String generate()

}

public class SelectWithMatchSql extends Sql {

	public SelectWithMatchSql(String table, Column[] columns, Column column, String pattern)

	@Override
	public String generate()

}

public class FindByKeySql extends Sql {

	public FindByKeySql(String table, Column[] columns, String keyColumn, String keyValue)

	@Override
	public String generate()

}

public class PreparedInsertSql extends Sql {

	public PreparedInsertSql(String table, Column[] columns)

	@Override
	public String generate() {
		private String placeholderList (Column[]columns)
	}

	public class Where {

		public Where(String criteria)

		public String generate()

	}

	public class ColumnList {

		public ColumnList(Column[] columns)

		public String generate()

	}
}

public interface StockExchange {

	Money currentPrice(String symbol);

}

public Portfolio{
private StockExchange exchange;
public Portfolio(StockExchange exchange){
	this.exchange=exchange;
}
// ...
}

public class PortfolioTest {
	private FixedStockExchangeStub exchange;
	private Portfolio portfolio;
	@Before
	protected void setUp() throws Exception {
		exchange = new FixedStockExchangeStub();
		exchange.fix("MSFT", 100);
		portfolio = new Portfolio(exchange);

	}
	@Test
	public void GivenFiveMSFTTotalShouldBe500() throws Exception {
		portfolio.add(5, "MSFT");
		Assert.assertEquals(500, portfolio.value());
	}
}