/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model;

/**
 * @author Cristina González
 */
public interface ShardedModel {

	public long getCompanyId();

	public void setCompanyId(long companyId);

}