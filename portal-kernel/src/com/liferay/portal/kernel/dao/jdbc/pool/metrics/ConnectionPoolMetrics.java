/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.jdbc.pool.metrics;

/**
 * @author Mladen Cikara
 */
public interface ConnectionPoolMetrics {

	public String getConnectionPoolName();

	public int getNumActive();

	public int getNumIdle();

}