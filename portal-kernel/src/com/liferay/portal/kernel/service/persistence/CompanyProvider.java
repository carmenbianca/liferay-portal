/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service.persistence;

/**
 * @author     Manuel de la Peña
 * @deprecated As of Mueller (7.2.x), with no direct replacement
 */
@Deprecated
public interface CompanyProvider {

	public long getCompanyId();

	public String getCompanyIdName();

}