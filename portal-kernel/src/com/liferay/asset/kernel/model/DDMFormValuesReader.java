/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.kernel.model;

import com.liferay.dynamic.data.mapping.kernel.DDMFormFieldValue;
import com.liferay.dynamic.data.mapping.kernel.DDMFormValues;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

/**
 * @author Adolfo Pérez
 */
public interface DDMFormValuesReader {

	public List<DDMFormFieldValue> getDDMFormFieldValues(
			String ddmFormFieldType)
		throws PortalException;

	public DDMFormValues getDDMFormValues() throws PortalException;

}