/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.format;

/**
 * @author Brian Wing Shun Chan
 * @author Manuel de la Peña
 */
public interface PhoneNumberFormat {

	public String format(String phoneNumber);

	public String strip(String phoneNumber);

	public boolean validate(String phoneNumber);

}