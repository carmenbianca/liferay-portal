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
 * @author Samuel Trong Tran
 */
public class ModificationConflictInfo implements ConflictInfo {

	public ModificationConflictInfo(long modelClassPK, boolean resolved) {
		_modelClassPK = modelClassPK;
		_resolved = resolved;
	}

	@Override
	public String getConflictDescription(ResourceBundle resourceBundle) {
		return LanguageUtil.get(resourceBundle, "modification-conflict");
	}

	@Override
	public long getCTAutoResolutionInfoId() {
		return _ctAutoResolutionInfoId;
	}

	@Override
	public String getResolutionDescription(ResourceBundle resourceBundle) {
		String message = "the-conflict-cannot-be-automatically-resolved";

		if (isResolved()) {
			message = "the-conflict-was-automatically-resolved";
		}

		return LanguageUtil.get(resourceBundle, message);
	}

	@Override
	public ResourceBundle getResourceBundle(Locale locale) {
		return ResourceBundleUtil.getBundle(
			locale, ModificationConflictInfo.class);
	}

	@Override
	public long getSourcePrimaryKey() {
		return _modelClassPK;
	}

	@Override
	public long getTargetPrimaryKey() {
		return _modelClassPK;
	}

	@Override
	public boolean isResolved() {
		return _resolved;
	}

	public void setCtAutoResolutionInfoId(long ctAutoResolutionInfoId) {
		_ctAutoResolutionInfoId = ctAutoResolutionInfoId;
	}

	private long _ctAutoResolutionInfoId;
	private final long _modelClassPK;
	private final boolean _resolved;

}