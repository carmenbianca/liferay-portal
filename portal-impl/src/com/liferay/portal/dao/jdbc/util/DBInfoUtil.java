/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.dao.jdbc.util;

import com.liferay.petra.concurrent.ConcurrentReferenceKeyHashMap;
import com.liferay.petra.memory.FinalizeManager;
import com.liferay.petra.reflect.ReflectionUtil;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import java.util.concurrent.ConcurrentMap;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DelegatingDataSource;

/**
 * @author Shuyang Zhou
 */
public class DBInfoUtil {

	public static DBInfo getDBInfo(DataSource dataSource) {
		if (dataSource instanceof DelegatingDataSource) {
			DelegatingDataSource delegatingDataSource =
				(DelegatingDataSource)dataSource;

			dataSource = delegatingDataSource.getTargetDataSource();
		}

		return _dbInfos.computeIfAbsent(
			dataSource,
			keyDataSource -> {
				try (Connection connection = keyDataSource.getConnection()) {
					DatabaseMetaData databaseMetaData =
						connection.getMetaData();

					return new DBInfo(
						databaseMetaData.getDatabaseProductName(),
						databaseMetaData.getDriverName(),
						databaseMetaData.getDatabaseMajorVersion(),
						databaseMetaData.getDatabaseMinorVersion());
				}
				catch (SQLException sqlException) {
					return ReflectionUtil.throwException(sqlException);
				}
			});
	}

	private static final ConcurrentMap<DataSource, DBInfo> _dbInfos =
		new ConcurrentReferenceKeyHashMap<>(
			FinalizeManager.WEAK_REFERENCE_FACTORY);

}