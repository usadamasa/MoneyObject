package money;

public class Money implements Expression{
	/**
	 * フィールド変数
	 */
	public Integer amount;
	public String currency;

	/**
	 * コンストラクタ
	 *
	 * @param amount
	 * @param currency
	 */
	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	/**
	 *
	 * @param multiplier
	 * @return Money
	 */
	public Money times(int multiplier) {
		return new Money(amount * multiplier, currency);
	}

	@Override
	public boolean equals(Object object) {
		Money money = (Money) object;
		return amount == money.amount && currency().equals(money.currency);
	}

	public String currency() {
		return currency;
	}

	public static Money dollar(int amount) {
		return new Money(amount, "USD");
	}

	public static Money franc(int amount) {
		return new Money(amount, "CHF");
	}

	@Override
	public String toString() {
		return amount + " " + currency;
	}

	public Expression plus(Money addend) {
		return new Sum(this,addend);
	}
	
	public Money reduce(Bank bank,String to){
		int rate = bank.rate(currency, to);
		return new Money(amount / rate,to);
	}
}
