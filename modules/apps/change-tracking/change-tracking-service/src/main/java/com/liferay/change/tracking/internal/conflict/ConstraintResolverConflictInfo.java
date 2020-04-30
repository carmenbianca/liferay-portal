/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.internal.conflict;

import com.liferay.change.tracking.conflict.ConflictInfo;
import com.liferay.change.tracking.resolver.ConstraintResolver;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Preston Crary
 */
public class ConstraintResolverConflictInfo implements ConflictInfo {

	public ConstraintResolverConflictInfo(
		ConstraintResolver<?> constraintResolver, long sourcePrimaryKey,
		long targetPrimaryKey, boolean resolved) {

		_constraintResolver = constraintResolver;
		_sourcePrimaryKey = sourcePrimaryKey;
		_targetPrimaryKey = targetPrimaryKey;
		_resolved = resolved;
	}

	@Override
	public String getConflictDescription(ResourceBundle resourceBundle) {
		return ResourceBundleUtil.getString(
			resourceBundle, _constraintResolver.getConflictDescriptionKey());
	}

	public ConstraintResolver<?> getConstraintResolver() {
		return _constraintResolver;
	}

	@Override
	public long getCTAutoResolutionInfoId() {
		return _ctAutoResolutionInfoId;
	}

	@Override
	public String getResolutionDescription(ResourceBundle resourceBundle) {
		return ResourceBundleUtil.getString(
			resourceBundle, _constraintResolver.getResolutionDescriptionKey());
	}

	@Override
	public ResourceBundle getResourceBundle(Locale locale) {
		return _constraintResolver.getResourceBundle(locale);
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
		return _resolved;
	}

	public void setCtAutoResolutionInfoId(long ctAutoResolutionInfoId) {
		_ctAutoResolutionInfoId = ctAutoResolutionInfoId;
	}

	private final ConstraintResolver<?> _constraintResolver;
	private long _ctAutoResolutionInfoId;
	private final boolean _resolved;
	private final long _sourcePrimaryKey;
	private final long _targetPrimaryKey;

}