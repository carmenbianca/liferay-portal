/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.audit;

import com.liferay.petra.lang.CentralizedThreadLocal;

/**
 * @author Michael C. Han
 */
public class AuditRequestThreadLocal {

	public static AuditRequestThreadLocal getAuditThreadLocal() {
		AuditRequestThreadLocal auditRequestThreadLocal =
			_auditRequestThreadLocal.get();

		if (auditRequestThreadLocal == null) {
			auditRequestThreadLocal = new AuditRequestThreadLocal();

			_auditRequestThreadLocal.set(auditRequestThreadLocal);
		}

		return auditRequestThreadLocal;
	}

	public static void removeAuditThreadLocal() {
		_auditRequestThreadLocal.remove();
	}

	public String getClientHost() {
		return _clientHost;
	}

	public String getClientIP() {
		return _clientIP;
	}

	public String getQueryString() {
		return _queryString;
	}

	public long getRealUserId() {
		return _realUserId;
	}

	public String getRequestURL() {
		return _requestURL;
	}

	public String getServerName() {
		return _serverName;
	}

	public int getServerPort() {
		return _serverPort;
	}

	public String getSessionID() {
		return _sessionID;
	}

	public void setClientHost(String clientHost) {
		_clientHost = clientHost;
	}

	public void setClientIP(String clientIP) {
		_clientIP = clientIP;
	}

	public void setQueryString(String queryString) {
		_queryString = queryString;
	}

	public void setRealUserId(long realUserId) {
		_realUserId = realUserId;
	}

	public void setRequestURL(String requestURL) {
		_requestURL = requestURL;
	}

	public void setServerName(String serverName) {
		_serverName = serverName;
	}

	public void setServerPort(int serverPort) {
		_serverPort = serverPort;
	}

	public void setSessionID(String sessionID) {
		_sessionID = sessionID;
	}

	private static final ThreadLocal<AuditRequestThreadLocal>
		_auditRequestThreadLocal = new CentralizedThreadLocal<>(
			AuditRequestThreadLocal.class + "._auditRequestThreadLocal");

	private String _clientHost;
	private String _clientIP;
	private String _queryString;
	private long _realUserId;
	private String _requestURL;
	private String _serverName;
	private int _serverPort;
	private String _sessionID;

}