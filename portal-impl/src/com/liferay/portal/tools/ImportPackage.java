/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Carlos Sierra Andrés
 * @author Hugo Huijser
 */
public class ImportPackage implements Comparable<ImportPackage> {

	public ImportPackage(String importString, boolean isStatic, String line) {
		this(importString, isStatic, line, false);
	}

	public ImportPackage(
		String importString, boolean isStatic, String line, boolean bndImport) {

		_importString = importString;
		_isStatic = isStatic;
		_line = line;
		_bndImport = bndImport;
	}

	@Override
	public int compareTo(ImportPackage importPackage) {
		if (_isStatic != importPackage.isStatic()) {
			if (_isStatic) {
				return -1;
			}

			return 1;
		}

		String importPackageImportString = importPackage.getImportString();

		int value = _importString.compareTo(importPackageImportString);

		if (_importString.startsWith(StringPool.EXCLAMATION) ||
			importPackageImportString.startsWith(StringPool.EXCLAMATION)) {

			return value;
		}

		if (!_bndImport) {
			return value;
		}

		int startsWithWeight = StringUtil.startsWithWeight(
			_importString, importPackageImportString);

		String importStringPart1 = _importString.substring(startsWithWeight);
		String importStringPart2 = importPackageImportString.substring(
			startsWithWeight);

		if (importStringPart1.equals(StringPool.STAR) ||
			importStringPart2.equals(StringPool.STAR)) {

			return -value;
		}

		return value;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ImportPackage)) {
			return false;
		}

		ImportPackage importPackage = (ImportPackage)obj;

		if ((_isStatic == importPackage.isStatic()) &&
			_importString.equals(importPackage.getImportString())) {

			return true;
		}

		return false;
	}

	public String getImportString() {
		return _importString;
	}

	public String getLine() {
		return _line;
	}

	public String getPackageLevel() {
		int pos = _importString.indexOf(StringPool.SLASH);

		if (pos != -1) {
			pos = _importString.indexOf(StringPool.SLASH, pos + 1);

			if (pos == -1) {
				return _importString;
			}

			return _importString.substring(0, pos);
		}

		pos = _importString.indexOf(StringPool.PERIOD);

		pos = _importString.indexOf(StringPool.PERIOD, pos + 1);

		if ((pos == -1) && !_bndImport) {
			pos = _importString.indexOf(StringPool.PERIOD);
		}

		if (pos == -1) {
			return _importString;
		}

		return _importString.substring(0, pos);
	}

	@Override
	public int hashCode() {
		return _importString.hashCode();
	}

	public boolean isGroupedWith(ImportPackage importPackage) {
		if (_importString.equals(StringPool.STAR)) {
			return false;
		}

		String importPackageImportString = importPackage.getImportString();

		if (importPackageImportString.equals(StringPool.STAR)) {
			return false;
		}

		if (_isStatic != importPackage.isStatic()) {
			return false;
		}

		String packageLevel = getPackageLevel();

		if (packageLevel.equals(importPackage.getPackageLevel())) {
			return true;
		}

		return false;
	}

	public boolean isStatic() {
		return _isStatic;
	}

	private final boolean _bndImport;
	private final String _importString;
	private boolean _isStatic;
	private final String _line;

}