/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.text.localizer.address;

import com.liferay.portal.kernel.model.Address;

/**
 * @author Pei-Jung Lan
 */
public interface AddressTextLocalizer {

	public String format(Address address);

}