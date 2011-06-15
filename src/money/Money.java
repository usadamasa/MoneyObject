package money;

public class Money {
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

	public static Dollar dollar(int amount) {
		return new Dollar(amount, "USD");
	}

	public static Franc franc(int amount) {
		return new Franc(amount, "CHF");
	}

	@Override
	public String toString() {
		return amount + " " + currency;
	}

}
