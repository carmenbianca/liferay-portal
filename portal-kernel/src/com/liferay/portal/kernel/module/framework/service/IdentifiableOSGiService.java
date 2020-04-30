/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.module.framework.service;

import com.liferay.portal.kernel.transaction.Transactional;

/**
 * @author Tina Tian
 */
public interface IdentifiableOSGiService {

	@Transactional(enabled = false)
	public String getOSGiServiceIdentifier();

}