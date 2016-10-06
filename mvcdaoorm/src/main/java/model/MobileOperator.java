package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MOBILE_OPERATOR database table.
 * 
 */
@Entity
@Table(name="MOBILE_OPERATOR")
@NamedQuery(name="MobileOperator.findAll", query="SELECT m FROM MobileOperator m")
public class MobileOperator implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MOBILE_OPERATOR_MOBILEOPERATORID_GENERATOR", sequenceName="SEQ_MOBILE_OPERATOR")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MOBILE_OPERATOR_MOBILEOPERATORID_GENERATOR")
	@Column(name="MOBILE_OPERATOR_ID", unique=true, nullable=false, precision=5)
	private long mobileOperatorId;

	@Column(name="MOBILE_OPERATOR", nullable=false, length=100)
	private String mobileOperator;

	//bi-directional many-to-one association to PurchaseAddendumDetail
	@OneToMany(mappedBy="mobileOperatorBean")
	private List<PurchaseAddendumDetail> purchaseAddendumDetails;

	public MobileOperator() {
	}

	public long getMobileOperatorId() {
		return this.mobileOperatorId;
	}

	public void setMobileOperatorId(long mobileOperatorId) {
		this.mobileOperatorId = mobileOperatorId;
	}

	public String getMobileOperator() {
		return this.mobileOperator;
	}

	public void setMobileOperator(String mobileOperator) {
		this.mobileOperator = mobileOperator;
	}

	public List<PurchaseAddendumDetail> getPurchaseAddendumDetails() {
		return this.purchaseAddendumDetails;
	}

	public void setPurchaseAddendumDetails(List<PurchaseAddendumDetail> purchaseAddendumDetails) {
		this.purchaseAddendumDetails = purchaseAddendumDetails;
	}

	public PurchaseAddendumDetail addPurchaseAddendumDetail(PurchaseAddendumDetail purchaseAddendumDetail) {
		getPurchaseAddendumDetails().add(purchaseAddendumDetail);
		purchaseAddendumDetail.setMobileOperatorBean(this);

		return purchaseAddendumDetail;
	}

	public PurchaseAddendumDetail removePurchaseAddendumDetail(PurchaseAddendumDetail purchaseAddendumDetail) {
		getPurchaseAddendumDetails().remove(purchaseAddendumDetail);
		purchaseAddendumDetail.setMobileOperatorBean(null);

		return purchaseAddendumDetail;
	}

}