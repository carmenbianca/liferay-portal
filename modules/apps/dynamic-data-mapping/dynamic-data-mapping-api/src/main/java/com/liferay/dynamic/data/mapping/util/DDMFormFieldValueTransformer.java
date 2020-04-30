/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.util;

import com.liferay.dynamic.data.mapping.storage.DDMFormFieldValue;
import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Marcellus Tavares
 */
public interface DDMFormFieldValueTransformer {

	public String getFieldType();

	public void transform(DDMFormFieldValue ddmFormFieldValue)
		throws PortalException;

}