package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SETTLEMENT_GROUP_ID database table.
 * 
 */
@Entity
@Table(name="SETTLEMENT_GROUP_ID")
@NamedQuery(name="SettlementGroupId.findAll", query="SELECT s FROM SettlementGroupId s")
public class SettlementGroupId implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SettlementGroupIdPK id;

	@Column(name="MERCHANT_SETTLEMENT_GROUP_NAME", nullable=false, length=150)
	private String merchantSettlementGroupName;

	@Column(name="SETTLEMENT_GROUP_NAME", nullable=false, length=150)
	private String settlementGroupName;

	//bi-directional many-to-one association to MerchantNode
	@OneToMany(mappedBy="settlementGroupIdBean")
	private List<MerchantNode> merchantNodes;

	//bi-directional many-to-one association to PaymentAccount
	@OneToMany(mappedBy="settlementGroupId")
	private List<PaymentAccount> paymentAccounts;

	//bi-directional many-to-one association to Alliance
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ALLIANCE_ID", nullable=false)
	private Alliance alliance;

	//bi-directional many-to-one association to Platform
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PLATFORM_ID", nullable=false, insertable=false, updatable=false)
	private Platform platform;

	public SettlementGroupId() {
	}

	public SettlementGroupIdPK getId() {
		return this.id;
	}

	public void setId(SettlementGroupIdPK id) {
		this.id = id;
	}

	public String getMerchantSettlementGroupName() {
		return this.merchantSettlementGroupName;
	}

	public void setMerchantSettlementGroupName(String merchantSettlementGroupName) {
		this.merchantSettlementGroupName = merchantSettlementGroupName;
	}

	public String getSettlementGroupName() {
		return this.settlementGroupName;
	}

	public void setSettlementGroupName(String settlementGroupName) {
		this.settlementGroupName = settlementGroupName;
	}

	public List<MerchantNode> getMerchantNodes() {
		return this.merchantNodes;
	}

	public void setMerchantNodes(List<MerchantNode> merchantNodes) {
		this.merchantNodes = merchantNodes;
	}

	public MerchantNode addMerchantNode(MerchantNode merchantNode) {
		getMerchantNodes().add(merchantNode);
		merchantNode.setSettlementGroupIdBean(this);

		return merchantNode;
	}

	public MerchantNode removeMerchantNode(MerchantNode merchantNode) {
		getMerchantNodes().remove(merchantNode);
		merchantNode.setSettlementGroupIdBean(null);

		return merchantNode;
	}

	public List<PaymentAccount> getPaymentAccounts() {
		return this.paymentAccounts;
	}

	public void setPaymentAccounts(List<PaymentAccount> paymentAccounts) {
		this.paymentAccounts = paymentAccounts;
	}

	public PaymentAccount addPaymentAccount(PaymentAccount paymentAccount) {
		getPaymentAccounts().add(paymentAccount);
		paymentAccount.setSettlementGroupId(this);

		return paymentAccount;
	}

	public PaymentAccount removePaymentAccount(PaymentAccount paymentAccount) {
		getPaymentAccounts().remove(paymentAccount);
		paymentAccount.setSettlementGroupId(null);

		return paymentAccount;
	}

	public Alliance getAlliance() {
		return this.alliance;
	}

	public void setAlliance(Alliance alliance) {
		this.alliance = alliance;
	}

	public Platform getPlatform() {
		return this.platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

}