/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter;

import org.junit.Test;

/**
 * @author Alberto Chaparro
 */
public class JavaUpgradeVersionSourceProcessorTest
	extends BaseSourceProcessorTestCase {

	@Test
	public void testMajorUpgradeByAlterColumnName() throws Exception {
		test("MajorUpgradeByAlterColumnName.testjava", "2.0.0", 30);
	}

	@Test
	public void testMajorUpgradeByAlterTableDropColumn() throws Exception {
		test("MajorUpgradeByAlterTableDropColumn.testjava", "2.0.0", 31);
	}

	@Test
	public void testMajorUpgradeByAlterTableDropColumnClause()
		throws Exception {

		test("MajorUpgradeByAlterTableDropColumnClause.testjava", "2.0.0", 31);
	}

	@Test
	public void testMajorUpgradeByDropTable() throws Exception {
		test("MajorUpgradeByDropTable.testjava", "2.0.0", 30);
	}

	@Test
	public void testMinorUpgradeByAlterTableAddColumn() throws Exception {
		test("MinorUpgradeByAlterTableAddColumn.testjava", "1.1.0", 31);
	}

	@Test
	public void testMinorUpgradeByAlterTableAddColumnClause() throws Exception {
		test("MinorUpgradeByAlterTableAddColumnClause.testjava", "1.1.0", 31);
	}

	@Override
	protected void test(
			String fileName, String expectedSchemaVersion, int lineNumber)
		throws Exception {

		super.test(
			fileName, "Expected new schema version: " + expectedSchemaVersion,
			lineNumber);
	}

}