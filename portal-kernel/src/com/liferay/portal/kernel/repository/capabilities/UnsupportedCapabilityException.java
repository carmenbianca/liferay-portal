/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.repository.capabilities;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Iván Zaera
 */
public class UnsupportedCapabilityException extends SystemException {

	public UnsupportedCapabilityException(
		Class<? extends Capability> capabilityClass,
		String providerDescription) {

		super(
			String.format(
				"%s does not support capability %s", providerDescription,
				capabilityClass.getName()));
	}

}