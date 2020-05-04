/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class FragmentEntryConfigurationException extends PortalException {

	public FragmentEntryConfigurationException() {
	}

	public FragmentEntryConfigurationException(String msg) {
		super(msg);
	}

	public FragmentEntryConfigurationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public FragmentEntryConfigurationException(Throwable cause) {
		super(cause);
	}

}