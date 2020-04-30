/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.jdbc.aop;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 */
@ProviderType
public interface DynamicDataSourceTargetSource {

	public Operation getOperation();

	public DataSource getReadDataSource();

	public Object getTarget() throws Exception;

	public DataSource getWriteDataSource();

	public Operation popOperation();

	public void pushOperation(Operation operation);

	public void setReadDataSource(DataSource readDataSource);

	public void setWriteDataSource(DataSource writeDataSource);

}