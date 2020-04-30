/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.data.partitioning.sql.builder.postgresql.exporter;

import com.liferay.portal.tools.data.partitioning.sql.builder.exporter.DataPartitioningExporter;
import com.liferay.portal.tools.data.partitioning.sql.builder.exporter.DataPartitioningExporterFactory;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Manuel de la Peña
 */
public class DataPartitioningExporterFactoryTest {

	@Test
	public void testGetDataPartitioningExporterReturnsPostgreSQLProvider()
		throws Exception {

		DataPartitioningExporter dataPartitioningExporter =
			DataPartitioningExporterFactory.getDataPartitioningExporter();

		Class<PostgreSQLDataPartitioningExporter> clazz =
			PostgreSQLDataPartitioningExporter.class;

		Assert.assertTrue(clazz.isInstance(dataPartitioningExporter));
	}

}