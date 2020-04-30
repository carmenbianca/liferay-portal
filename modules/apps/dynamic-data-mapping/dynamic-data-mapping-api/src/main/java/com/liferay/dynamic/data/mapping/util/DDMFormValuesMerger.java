/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.util;

import com.liferay.dynamic.data.mapping.storage.DDMFormValues;

/**
 * @author Inácio Nery
 */
public interface DDMFormValuesMerger {

	public DDMFormValues merge(
		DDMFormValues newDDMFormValues, DDMFormValues existingDDMFormValues);

}