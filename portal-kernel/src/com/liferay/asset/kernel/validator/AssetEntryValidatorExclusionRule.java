/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.kernel.validator;

/**
 * @author Adolfo Pérez
 */
public interface AssetEntryValidatorExclusionRule {

	public boolean isValidationExcluded(
		long groupId, String className, long classPK, long classTypePK,
		long[] categoryIds, String[] tagNames);

}