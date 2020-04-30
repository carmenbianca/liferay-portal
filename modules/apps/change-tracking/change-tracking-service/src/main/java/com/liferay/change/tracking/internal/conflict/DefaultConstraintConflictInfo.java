/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.internal.conflict;

import com.liferay.change.tracking.conflict.ConflictInfo;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Preston Crary
 */
public class DefaultConstraintConflictInfo implements ConflictInfo {

	public DefaultConstraintConflictInfo(
		long sourcePrimaryKey, long targetPrimaryKey,
		String uniqueColumnNames) {

		_sourcePrimaryKey = sourcePrimaryKey;
		_targetPrimaryKey = targetPrimaryKey;
		_uniqueColumnNames = uniqueColumnNames;
	}

	@Override
	public String getConflictDescription(ResourceBundle resourceBundle) {
		return LanguageUtil.format(
			resourceBundle, "values-for-x-are-not-unique", _uniqueColumnNames,
			false);
	}

	@Override
	public long getCTAutoResolutionInfoId() {
		return 0;
	}

	@Override
	public String getResolutionDescription(ResourceBundle resourceBundle) {
		return LanguageUtil.format(
			resourceBundle, "update-values-to-be-unique", _uniqueColumnNames,
			false);
	}

	@Override
	public ResourceBundle getResourceBundle(Locale locale) {
		return ResourceBundleUtil.getBundle(
			locale, DefaultConstraintConflictInfo.class);
	}

	@Override
	public long getSourcePrimaryKey() {
		return _sourcePrimaryKey;
	}

	@Override
	public long getTargetPrimaryKey() {
		return _targetPrimaryKey;
	}

	@Override
	public boolean isResolved() {
		return false;
	}

	private final long _sourcePrimaryKey;
	private final long _targetPrimaryKey;
	private final String _uniqueColumnNames;

}