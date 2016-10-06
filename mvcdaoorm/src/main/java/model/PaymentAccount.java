package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PAYMENT_ACCOUNT database table.
 * 
 */
@Entity
@Table(name="PAYMENT_ACCOUNT")
@NamedQuery(name="PaymentAccount.findAll", query="SELECT p FROM PaymentAccount p")
public class PaymentAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PaymentAccountPK id;

	@Column(name="ACCOUNT_NR", nullable=false, length=100)
	private String accountNr;

	//bi-directional many-to-one association to AccountType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ACCOUNT_TYPE_ID", nullable=false)
	private AccountType accountType;

	//bi-directional many-to-one association to SettlementGroupId
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="PLATFORM_ID", referencedColumnName="PLATFORM_ID", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="SETTLEMENT_ID", referencedColumnName="SETTLEMENT_GROUP_ID", nullable=false, insertable=false, updatable=false)
		})
	private SettlementGroupId settlementGroupId;

	public PaymentAccount() {
	}

	public PaymentAccountPK getId() {
		return this.id;
	}

	public void setId(PaymentAccountPK id) {
		this.id = id;
	}

	public String getAccountNr() {
		return this.accountNr;
	}

	public void setAccountNr(String accountNr) {
		this.accountNr = accountNr;
	}

	public AccountType getAccountType() {
		return this.accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public SettlementGroupId getSettlementGroupId() {
		return this.settlementGroupId;
	}

	public void setSettlementGroupId(SettlementGroupId settlementGroupId) {
		this.settlementGroupId = settlementGroupId;
	}

}