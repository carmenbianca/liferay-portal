/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Carlos Sierra Andrés
 */
public class ImportPackageTest {

	@Test
	public void testContains() {
		ImportPackage importPackage = _javaImportsFormatter.createImportPackage(
			_ARRAYS_IMPORT_STATEMENT);

		List<ImportPackage> importPackages = new ArrayList<>();

		importPackages.add(importPackage);

		if (!importPackages.contains(importPackage)) {
			ImportPackage importPackage2 =
				_javaImportsFormatter.createImportPackage(
					_ARRAYS_IMPORT_STATEMENT);

			importPackages.add(importPackage2);
		}

		Assert.assertEquals(
			importPackages.toString(), 1, importPackages.size());
	}

	@Test
	public void testEquals() {
		ImportPackage importPackage = _javaImportsFormatter.createImportPackage(
			_ARRAYS_IMPORT_STATEMENT);
		ImportPackage importPackage2 =
			_javaImportsFormatter.createImportPackage(_ARRAYS_IMPORT_STATEMENT);

		Assert.assertEquals(importPackage, importPackage2);
	}

	private static final String _ARRAYS_IMPORT_STATEMENT =
		"import java.util.Arrays";

	private final JavaImportsFormatter _javaImportsFormatter =
		new JavaImportsFormatter();

}