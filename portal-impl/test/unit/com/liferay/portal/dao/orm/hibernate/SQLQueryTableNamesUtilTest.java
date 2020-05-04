/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.dao.orm.hibernate;

import com.liferay.petra.string.CharPool;
import com.liferay.portal.kernel.io.unsync.UnsyncBufferedReader;
import com.liferay.portal.kernel.test.rule.CodeCoverageAssertor;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.tools.ToolDependencies;

import java.io.InputStreamReader;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;

/**
 * @author Shuyang Zhou
 */
public class SQLQueryTableNamesUtilTest {

	@ClassRule
	public static final CodeCoverageAssertor codeCoverageAssertor =
		CodeCoverageAssertor.INSTANCE;

	@BeforeClass
	public static void setUpClass() throws Exception {
		ToolDependencies.wireCaches();
	}

	@Test
	public void testConstructor() {
		new SQLQueryTableNamesUtil();
	}

	@Test
	public void testGetTableNames() throws Exception {
		try (UnsyncBufferedReader unsyncBufferedReader =
				new UnsyncBufferedReader(
					new InputStreamReader(
						SQLQueryTableNamesUtilTest.class.getResourceAsStream(
							"dependencies/sql.txt")))) {

			String line = null;

			while ((line = unsyncBufferedReader.readLine()) != null) {
				int index = line.indexOf(CharPool.POUND);

				if (index == -1) {
					continue;
				}

				String sql = line.substring(0, index);

				String[] expectedTableNames = StringUtil.split(
					line.substring(index + 1), CharPool.COMMA);

				String[] actualTableNames =
					SQLQueryTableNamesUtil.getTableNames(sql);

				Arrays.sort(actualTableNames);

				Assert.assertArrayEquals(
					"For SQL " + sql, expectedTableNames, actualTableNames);

				// Access from cache

				actualTableNames = SQLQueryTableNamesUtil.getTableNames(sql);

				Arrays.sort(actualTableNames);

				Assert.assertArrayEquals(
					"For SQL " + sql, expectedTableNames, actualTableNames);
			}
		}
	}

}