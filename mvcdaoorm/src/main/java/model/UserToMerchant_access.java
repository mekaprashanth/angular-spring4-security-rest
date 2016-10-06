package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the "USER_TO_MERCHANT ACCESS" database table.
 * 
 */
@Entity
@Table(name="\"USER_TO_MERCHANT ACCESS\"")
@NamedQuery(name="UserToMerchant_access.findAll", query="SELECT u FROM UserToMerchant_access u")
public class UserToMerchant_access implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ALLIANCE_ID", precision=10)
	private BigDecimal allianceId;

	@Column(name="MERCHANT_ID", precision=10)
	private BigDecimal merchantId;

	@Column(name="USER_ID", precision=10)
	private BigDecimal userId;

	public UserToMerchant_access() {
	}

	public BigDecimal getAllianceId() {
		return this.allianceId;
	}

	public void setAllianceId(BigDecimal allianceId) {
		this.allianceId = allianceId;
	}

	public BigDecimal getMerchantId() {
		return this.merchantId;
	}

	public void setMerchantId(BigDecimal merchantId) {
		this.merchantId = merchantId;
	}

	public BigDecimal getUserId() {
		return this.userId;
	}

	public void setUserId(BigDecimal userId) {
		this.userId = userId;
	}

}