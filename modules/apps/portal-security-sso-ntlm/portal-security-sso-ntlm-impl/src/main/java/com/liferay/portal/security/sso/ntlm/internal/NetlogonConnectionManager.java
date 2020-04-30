/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.sso.ntlm.internal;

import java.io.IOException;

import java.security.NoSuchAlgorithmException;

/**
 * @author Michael C. Han
 */
public interface NetlogonConnectionManager {

	public NetlogonConnection connect(
			String domainController, String domainControllerName,
			NtlmServiceAccount ntlmServiceAccount)
		throws IOException, NoSuchAlgorithmException, NtlmLogonException;

}