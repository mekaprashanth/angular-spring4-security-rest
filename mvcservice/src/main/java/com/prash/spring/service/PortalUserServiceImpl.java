/**
 * 
 */
package com.prash.spring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prash.spring.dao.PortalUserDAO;
import com.prash.spring.entities.PortalFunction;
import com.prash.spring.entities.PortalRole;
import com.prash.spring.entities.PortalRoleFunction;
import com.prash.spring.entities.PortalUser;
import com.prash.spring.entities.PortalUserFunction;
import com.prash.spring.model.PortalUserDetails;
import com.prash.spring.repositories.PortalFunctionRepository;
import com.prash.spring.repositories.PortalRoleFunctionRepository;
import com.prash.spring.repositories.PortalRoleRepository;
import com.prash.spring.repositories.PortalUserFunctionRepository;
import com.prash.spring.repositories.PortalUserRepository;

/**
 * @author Prashanth_Meka
 *
 */

@Service
public class PortalUserServiceImpl implements PortalUserService {

	@Autowired
	PortalUserRepository portalUserRepository;

	@Autowired
	PortalUserFunctionRepository portalUserFunctionRepository;

	@Autowired
	PortalRoleRepository portalRoleRepository;

	@Autowired
	PortalFunctionRepository portalFunctionRepository;

	@Autowired
	PortalRoleFunctionRepository portalRoleFunctionRepository;
	
	@Autowired
	PortalUserDAO portalUserDAO;

	@Override
	public PortalUser getUser(String username) {
		PortalUser portalUser = portalUserRepository.findByUsername(username);
		return portalUser;
	}

	@Override
	public void save(PortalUser portalUser) {
		List<PortalRoleFunction> roleFunctions = portalUser.getPortalRoleFunctions();
		for (PortalRoleFunction roleFunction : roleFunctions) {
			String roleName = roleFunction.getPortalRole().getName();
			String functionName = roleFunction.getPortalFunction().getName();
			List<PortalRole> portalRoles = portalRoleRepository.findByName(roleName);
			PortalFunction portalFunction = portalFunctionRepository.findByName(functionName);
			for (PortalRole portalRole : portalRoles) {
				roleFunction.setPortalFunction(portalFunction);
				roleFunction.setPortalRole(portalRole);

			}
		}
		portalUserRepository.save(portalUser);
	}

	@Override
	public List<PortalUser> list() {
//		return portalUserRepository.findAll();
		return portalUserDAO.findAllNative();
	}

	@Override
	public Integer getMaxUserId() {
		return portalUserRepository.getMaxUserId();
	}

	@Override
	public void updateResetLoginAttemptsAndLoginTime(String username) {
		PortalUser portalUser = portalUserRepository.findByUsername(username);
		portalUser.setLoginCount(0);
		portalUser.setLastLoginDate(new Date());
		portalUser.setBlockCode(null);
		portalUserRepository.save(portalUser);
	}

	@Override
	public void updateIncrementLoginAttempts(String username) {
		PortalUser portalUser = portalUserRepository.findByUsername(username);
		portalUser.setLoginCount(portalUser.getLoginCount() + 1);
		portalUserRepository.save(portalUser);
	}

	@Override
	public void updateLoginAttemptsAndBlockStatusTemporary(String username) {
		PortalUser portalUser = portalUserRepository.findByUsername(username);
		portalUser.setLoginCount(portalUser.getLoginCount() + 1);
		portalUser.setBlockCode(0L);
		portalUser.setLastLoginDate(new Date());
		portalUserRepository.save(portalUser);
		
		
		Optional<String> userIdCheck = Optional.of("50046001");
		Optional<String> transAmtSort = Optional.of("transAmt");
		final String SQL="SELECT vwclearing0_.C_TRAN_AMT   FROM VW_CLEARING_WITH_INVOICE vwclearing0_, "
	               + "  VW_MERCHANT_EXPANDED vwmerchant1_ WHERE"
	               + " vwclearing0_.MERCH_ID =vwmerchant1_.MERCH_ID AND"
	               + " (vwclearing0_.MERCH_ID IN "
	               + "  (SELECT usrmerchac2_.MERCH_ID   FROM USR_MERCH_ACCESS usrmerchac2_  "
	               + " WHERE 1=1 "
	               +( userIdCheck.isPresent() ? " AND usrmerchac2_.USER_ID=:userId":"")
	               + " ))"
	               + " ORDER BY "
	               +(transAmtSort.isPresent() ? transAmtSort.get():"usrmerchac2_.USER_ID");
		
		final Query query = getEntityManager().createNativeQuery(""); 
		userIdCheck.ifPresent((userId)-> query.setParameter("userId", userId));
		query.setMaxResults(20);
		query.setFirstResult(11);
	}

	private EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateLoginAttemptsAndBlockStatusPermanent(String username) {
		PortalUser portalUser = portalUserRepository.findByUsername(username);
		portalUser.setLoginCount(portalUser.getLoginCount() + 1);
		portalUser.setBlockCode(1L);
		portalUserRepository.save(portalUser);

	}

	@Transactional
	@Override
	public void savePortalUser(PortalUserDetails portalUserDetails) {
		// List<PortalFunction> portalFunctions =
		// portalFunctionRepository.findAll();

		List<PortalRoleFunction> portalRoleFunctions = new ArrayList<PortalRoleFunction>();
		/* for (PortalFunction portalFunction : portalFunctions) { */
		for (String authority : portalUserDetails.getRoles()) {
			List<PortalRole> portalRoles = portalRoleRepository.findByName(authority);
			for (PortalRole portalRole : portalRoles) {
				portalRoleFunctions.addAll(portalRoleFunctionRepository.findByPortalRole(portalRole));
				/*
				 * portalRoleFunction.setPortalRole(portalRole);
				 * portalRoleFunction.setPortalFunction(portalFunction);
				 * portalRoleFunction.setCanCreate(1);
				 * portalRoleFunction.setCanRead(1);
				 * portalRoleFunction.setCanUpdate(1);
				 * portalRoleFunctions.add(portalRoleFunction);
				 */
			}
		}

		PortalUser portalUser = new PortalUser(portalUserDetails.getUsername(), portalUserDetails.getPassword(),
				portalUserDetails.getPasscode(), portalUserDetails.getFirstName(), portalUserDetails.getLastName(),
				portalUserDetails.getMerchantId(), portalUserDetails.getEmailAddress(),
				portalUserDetails.getPhoneNumber(), portalUserDetails.getMobileNumber(),
				portalUserDetails.getIsActive(), portalUserDetails.getBlockCode(), portalUserDetails.getCreationDate(),
				portalUserDetails.getActivationDate(), portalUserDetails.getLastLoginDate(),
				portalUserDetails.getAllianceId(), portalUserDetails.getToken(), portalUserDetails.getIpAddress(),
				portalUserDetails.getLoginCount(), portalUserDetails.getAccountExpirationDate(),
				portalUserDetails.getAccountStatus(), portalUserDetails.getPasswordExpirationDate(),
				portalRoleFunctions);
		System.out.println(portalUser);
		portalUserRepository.save(portalUser);
		for (PortalUser portalUser1 : portalUserRepository.findAll()) {
			System.out.println(portalUser1);
			System.out.println();
		}

		for (PortalRoleFunction prf : portalRoleFunctionRepository.findAll()) {
			System.out.println(prf);
			System.out.println();
		}

		for (PortalUserFunction puf : portalUserFunctionRepository.findAll()) {
			System.out.println(puf);
			System.out.println();
		}
		
		Optional<String> testParam = Optional.of("");
		String transactionQueryForTranslation = " select v from VwClearingWithRefundForTranslation v , Dictionary d "
                + " where d.cat=:category  and d.languageCode=:langCode and  d.allianceCode=:allianceCode and "
                + " v.allianceCode = :allianceCode and "
                + " v.merchId in (select ua.merchToUserPK.merchId from  UsrMerchAccess ua where ua.merchToUserPK.userId=:userId)"
                + (testParam.isPresent()? " and (v.clearingId in (select ca.id.clearingId from ClearingToAuth ca where ca.id.authId=:authId))" :"")
                + (testParam.isPresent()? " and (v.cTranAmt between :fromAmount and :toAmount) ":"")
                + (testParam.isPresent()? " and (v.cTranDate between :fromDate and :toDate)) ":"")
                + (testParam.isPresent()? " and (v.cRefNum=:transactionId)   ":"")
                + (testParam.isPresent()? " and (trunc(v.cPostingDate) between :fromPostingDate and :toPostingDate) ":"")
                + (testParam.isPresent()? " and (v.cTranType=:transType) ":"")
                + (testParam.isPresent()? " and (v.terminalId=:terminalId) ":"")
                + (testParam.isPresent()? " and (v.cAuthCode=:authCode) ":"")

                + "    and (  (:code='cInstrumentSubtypeCode' and v.cInstrumentSubtypeCode=d.code)"
                + "           or  (:code='cIssuerLocation' and v.cIssuerLocation=d.code)"
                + "           or  (:code='cTranSourceCode' and v.cTranSourceCode=d.code) "
                + "           or  (:code='cProcessingStatusCode' and v.cProcessingStatusCode=d.code ) "
                + "    or  (:code='cTranType' and v.cTranType=d.code) "
                + "           or  (:code='cDccIndicator' and v.cDccIndicator=d.code) "
                + "           or  (:code='cInstrumentTypeCode' and v.cInstrumentTypeCode=d.code)"
                + "           or  (:code='cUcafeciCode' and v.cUcafeciCode=d.code)"
                + "     or not exists (SELECT 1 FROM Dictionary d1 WHERE cat =:category"
                + "           AND LANGUAGE_CODE=:langCode AND ALLIANCE_CODE=:allianceCode AND ((:code='cProcessingStatusCode' and v.cProcessingStatusCode=d1.code)"
                + " or(:code='cInstrumentSubtypeCode' and v.cInstrumentSubtypeCode=d1.code) "
                + " or(:code='cIssuerLocation' and v.cIssuerLocation=d1.code)or(:code='cTranSourceCode' and v.cTranSourceCode=d1.code)"
                + " or(:code='cTranType' and v.cTranType=d1.code) or (:code='cDccIndicator' and v.cDccIndicator=d1.code) "
                + " or (:code='cInstrumentTypeCode' and v.cInstrumentTypeCode=d1.code) or (:code='cUcafeciCode' and v.cUcafeciCode=d1.code))) "
                + " and (d.code='DUMMY_CODE'))"

                + " and (:transSourceCd is null  or (v.cTranSourceCode=:transSourceCd)) "
                + " and (:status is null  or (v.cProcessingStatusCode=:status) )  "
                + " and (:transCurrCode is null  or (v.cTranCurrCode=:transCurrCode)) "
                + " and (:eMid is null or (v.mExternalMerchId=:eMid)) order By coalesce(d.name "
                + " ,CASE :code "
                + " when 'cProcessingStatusCode' then v.cProcessingStatusCode "
                + "  when 'cInstrumentSubtypeCode' then v.cInstrumentSubtypeCode     "
                + "  when 'cIssuerLocation' then v.cIssuerLocation "
                + "  when 'cTranSourceCode' then v.cTranSourceCode "
                + "  when 'cTranType' then v.cTranType "
                + "  when 'cDccIndicator' then v.cDccIndicator "
                + "  when 'cInstrumentTypeCode' then v.cInstrumentTypeCode "
                + "  when 'cUcafeciCode' then v.cUcafeciCode END) ";
	}

}
