/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.sso.openid.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Stian Sigvartsen
 */
public class StrangersNotAllowedException extends PortalException {

	public StrangersNotAllowedException(long companyId) {
		super(String.format("Company %s does not allow strangers", companyId));

		this.companyId = companyId;
	}

	public final long companyId;

}