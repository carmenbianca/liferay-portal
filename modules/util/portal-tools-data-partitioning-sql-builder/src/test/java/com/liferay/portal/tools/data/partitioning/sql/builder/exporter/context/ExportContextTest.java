/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.data.partitioning.sql.builder.exporter.context;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Manuel de la Peña
 */
public class ExportContextTest {

	@Test
	public void testConstructorWithCatalogName() {
		String catalogName = "catalogName";

		ExportContext exportProcess = new ExportContext(
			catalogName, null, null, null, "schemaName", true);

		Assert.assertNotEquals(
			exportProcess.getSchemaName(), exportProcess.getCatalogName());
		Assert.assertEquals(catalogName, exportProcess.getCatalogName());
	}

	@Test
	public void testConstructorWithoutCatalogName() {
		ExportContext exportProcess = new ExportContext(
			null, null, null, "schemaName", true);

		Assert.assertEquals(
			exportProcess.getSchemaName(), exportProcess.getCatalogName());
	}

}