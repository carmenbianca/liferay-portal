/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.data.partitioning.sql.builder.exporter;

import com.liferay.portal.tools.data.partitioning.sql.builder.exporter.exception.DBProviderNotAvailableException;

import org.junit.Test;

/**
 * @author Manuel de la Peña
 */
public class DataPartitioningExporterFactoryTest {

	@Test(expected = DBProviderNotAvailableException.class)
	public void testGetDataPartitioningExporter() throws Exception {
		DataPartitioningExporterFactory.getDataPartitioningExporter();
	}

}