/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model;

import com.liferay.digital.signature.model.DSSealProviderOptions;

/**
 * @author Michael C. Han
 */
public class DSSealProviderOptionsImpl implements DSSealProviderOptions {

	@Override
	public String getMobilePhoneNumber() {
		return _mobilePhoneNumber;
	}

	@Override
	public String getOneTimePassword() {
		return _oneTimePassword;
	}

	@Override
	public String getRoleName() {
		return _roleName;
	}

	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		_mobilePhoneNumber = mobilePhoneNumber;
	}

	public void setOneTimePassword(String oneTimePassword) {
		_oneTimePassword = oneTimePassword;
	}

	public void setRoleName(String roleName) {
		_roleName = roleName;
	}

	private String _mobilePhoneNumber;
	private String _oneTimePassword;
	private String _roleName;

}