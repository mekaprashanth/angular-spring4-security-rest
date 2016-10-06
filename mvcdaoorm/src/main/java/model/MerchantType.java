package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MERCHANT_TYPE database table.
 * 
 */
@Entity
@Table(name="MERCHANT_TYPE")
@NamedQuery(name="MerchantType.findAll", query="SELECT m FROM MerchantType m")
public class MerchantType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MERCHANT_TYPE_MERCHANTTYPEID_GENERATOR", sequenceName="SEQ_MERCHANT_TYPE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MERCHANT_TYPE_MERCHANTTYPEID_GENERATOR")
	@Column(name="MERCHANT_TYPE_ID", unique=true, nullable=false, precision=10)
	private long merchantTypeId;

	@Column(nullable=false, length=200)
	private String description;

	@Column(name="MERCHANT_TYPE", nullable=false, length=30)
	private String merchantType;

	//bi-directional many-to-one association to MerchantNode
	@OneToMany(mappedBy="merchantType")
	private List<MerchantNode> merchantNodes;

	public MerchantType() {
	}

	public long getMerchantTypeId() {
		return this.merchantTypeId;
	}

	public void setMerchantTypeId(long merchantTypeId) {
		this.merchantTypeId = merchantTypeId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMerchantType() {
		return this.merchantType;
	}

	public void setMerchantType(String merchantType) {
		this.merchantType = merchantType;
	}

	public List<MerchantNode> getMerchantNodes() {
		return this.merchantNodes;
	}

	public void setMerchantNodes(List<MerchantNode> merchantNodes) {
		this.merchantNodes = merchantNodes;
	}

	public MerchantNode addMerchantNode(MerchantNode merchantNode) {
		getMerchantNodes().add(merchantNode);
		merchantNode.setMerchantType(this);

		return merchantNode;
	}

	public MerchantNode removeMerchantNode(MerchantNode merchantNode) {
		getMerchantNodes().remove(merchantNode);
		merchantNode.setMerchantType(null);

		return merchantNode;
	}

}