/**
 * 
 */
package com.prash.spring.config;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

/**
 * @author Prashanth_Meka
 *
 */
public class CustomWebAuthenticationDetails implements Serializable {
	private static final long serialVersionUID = 320L;
	private final String remoteAddress;
	private final String sessionId;
	private final String clientType;

	public CustomWebAuthenticationDetails(HttpServletRequest request) {
		this.remoteAddress = request.getRemoteAddr();

		HttpSession session = request.getSession(false);
		this.sessionId = ((session != null) ? session.getId() : null);
		
		this.clientType = request.getParameter("clientType");
	}

	public boolean equals(Object obj) {
		if (obj instanceof WebAuthenticationDetails) {
			WebAuthenticationDetails rhs = (WebAuthenticationDetails) obj;

			if ((this.remoteAddress == null) && (rhs.getRemoteAddress() != null)) {
				return false;
			}

			if ((this.remoteAddress != null) && (rhs.getRemoteAddress() == null)) {
				return false;
			}

			if ((this.remoteAddress != null) && (!(this.remoteAddress.equals(rhs.getRemoteAddress())))) {
				return false;
			}

			if ((this.sessionId == null) && (rhs.getSessionId() != null)) {
				return false;
			}

			if ((this.sessionId != null) && (rhs.getSessionId() == null)) {
				return false;
			}

			return ((this.sessionId == null) || (this.sessionId.equals(rhs.getSessionId())));
		}

		return false;
	}

	public String getRemoteAddress() {
		return this.remoteAddress;
	}

	public String getSessionId() {
		return this.sessionId;
	}

	public int hashCode() {
		int code = 7654;

		if (this.remoteAddress != null) {
			code *= this.remoteAddress.hashCode() % 7;
		}

		if (this.sessionId != null) {
			code *= this.sessionId.hashCode() % 7;
		}

		return code;
	}

	public String getClientType() {
		return clientType;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()).append(": ");
		sb.append("RemoteIpAddress: ").append(getRemoteAddress()).append("; ");
		sb.append("SessionId: ").append(getSessionId());

		return sb.toString();
	}

	
}
