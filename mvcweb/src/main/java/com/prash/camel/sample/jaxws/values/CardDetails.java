/**
 * 
 */
package com.prash.camel.sample.jaxws.values;

/**
 * @author prashanthmeka
 *
 */
public class CardDetails {

	private String cardNumber;
	private Double cardBalance;
	private String cardStatus;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Double getCardBalance() {
		return cardBalance;
	}

	public void setCardBalance(Double cardBalance) {
		this.cardBalance = cardBalance;
	}

	public String getCardStatus() {
		return cardStatus;
	}

	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}

	@Override
	public String toString() {
		return "CardInputDetails [cardNumber=" + cardNumber + ", cardBalance="
				+ cardBalance + ", cardStatus=" + cardStatus + "]";
	}

}
