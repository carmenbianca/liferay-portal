/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

import com.liferay.portal.kernel.model.Company;

/**
 * @author Brian Wing Shun Chan
 * @author José Manuel Navarro
 */
public class SendPasswordException extends PortalException {

	public static class MustBeEnabled extends SendPasswordException {

		public MustBeEnabled(Company company) {
			super(
				String.format(
					"Password Reset Link notification must be enabled for " +
						"company %s",
					company));

			this.company = company;
		}

		public final Company company;

	}

	protected SendPasswordException(String msg) {
		super(msg);
	}

}