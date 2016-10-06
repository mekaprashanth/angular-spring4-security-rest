package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the MASTER_HIERARCHY database table.
 * 
 */
@Entity
@Table(name="MASTER_HIERARCHY")
@NamedQuery(name="MasterHierarchy.findAll", query="SELECT m FROM MasterHierarchy m")
public class MasterHierarchy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MASTER_HIERARCHY_MASTERHIERARCHYID_GENERATOR", sequenceName="SEQ_MASTER_HIERARCHY")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MASTER_HIERARCHY_MASTERHIERARCHYID_GENERATOR")
	@Column(name="MASTER_HIERARCHY_ID", unique=true, nullable=false, precision=10)
	private long masterHierarchyId;

	@Column(name="MERCHANT_LEVEL", nullable=false, precision=10)
	private BigDecimal merchantLevel;

	//bi-directional many-to-one association to MerchantNode
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PARENT_MERCHANT_NODE_ID", nullable=false)
	private MerchantNode merchantNode1;

	//bi-directional many-to-one association to MerchantNode
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MERCHANT_NODE_ID", nullable=false)
	private MerchantNode merchantNode2;

	public MasterHierarchy() {
	}

	public long getMasterHierarchyId() {
		return this.masterHierarchyId;
	}

	public void setMasterHierarchyId(long masterHierarchyId) {
		this.masterHierarchyId = masterHierarchyId;
	}

	public BigDecimal getMerchantLevel() {
		return this.merchantLevel;
	}

	public void setMerchantLevel(BigDecimal merchantLevel) {
		this.merchantLevel = merchantLevel;
	}

	public MerchantNode getMerchantNode1() {
		return this.merchantNode1;
	}

	public void setMerchantNode1(MerchantNode merchantNode1) {
		this.merchantNode1 = merchantNode1;
	}

	public MerchantNode getMerchantNode2() {
		return this.merchantNode2;
	}

	public void setMerchantNode2(MerchantNode merchantNode2) {
		this.merchantNode2 = merchantNode2;
	}

}