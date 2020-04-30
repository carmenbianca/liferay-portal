/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.pwd;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PasswordPolicy;

/**
 * @author Brian Wing Shun Chan
 */
public interface Toolkit {

	public String generate(PasswordPolicy passwordPolicy);

	public void validate(
			long userId, String password1, String password2,
			PasswordPolicy passwordPolicy)
		throws PortalException;

	public void validate(
			String password1, String password2, PasswordPolicy passwordPolicy)
		throws PortalException;

}