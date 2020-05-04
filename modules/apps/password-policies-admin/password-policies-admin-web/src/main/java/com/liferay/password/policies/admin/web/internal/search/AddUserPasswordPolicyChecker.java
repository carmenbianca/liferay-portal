/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.password.policies.admin.web.internal.search;

import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.PasswordPolicy;
import com.liferay.portal.kernel.model.PasswordPolicyRel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.PasswordPolicyRelLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import javax.portlet.RenderResponse;

/**
 * @author Scott Lee
 */
public class AddUserPasswordPolicyChecker extends EmptyOnClickRowChecker {

	public AddUserPasswordPolicyChecker(
		RenderResponse renderResponse, PasswordPolicy passwordPolicy) {

		super(renderResponse);

		_passwordPolicy = passwordPolicy;
	}

	@Override
	public boolean isChecked(Object obj) {
		User user = (User)obj;

		try {
			return UserLocalServiceUtil.hasPasswordPolicyUser(
				_passwordPolicy.getPasswordPolicyId(), user.getUserId());
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			return false;
		}
	}

	@Override
	public boolean isDisabled(Object obj) {
		User user = (User)obj;

		if (isChecked(obj)) {
			return true;
		}

		try {
			PasswordPolicyRel passwordPolicyRel =
				PasswordPolicyRelLocalServiceUtil.fetchPasswordPolicyRel(
					User.class.getName(), user.getUserId());

			if ((passwordPolicyRel != null) &&
				(passwordPolicyRel.getPasswordPolicyId() !=
					_passwordPolicy.getPasswordPolicyId())) {

				return true;
			}
		}
		catch (Exception exception) {
			_log.error(exception, exception);
		}

		return false;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		AddUserPasswordPolicyChecker.class);

	private final PasswordPolicy _passwordPolicy;

}