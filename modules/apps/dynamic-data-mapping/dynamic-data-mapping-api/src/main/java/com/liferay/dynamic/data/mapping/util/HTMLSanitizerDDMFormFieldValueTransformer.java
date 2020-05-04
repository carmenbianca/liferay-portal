/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.util;

import com.liferay.dynamic.data.mapping.model.Value;
import com.liferay.dynamic.data.mapping.storage.DDMFormFieldValue;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.sanitizer.Sanitizer;
import com.liferay.portal.kernel.sanitizer.SanitizerUtil;
import com.liferay.portal.kernel.util.ContentTypes;

import java.util.Locale;

/**
 * @author Marcellus Tavares
 */
public class HTMLSanitizerDDMFormFieldValueTransformer
	implements DDMFormFieldValueTransformer {

	public HTMLSanitizerDDMFormFieldValueTransformer(
		long companyId, long groupId, long userId) {

		_companyId = companyId;
		_groupId = groupId;
		_userId = userId;
	}

	@Override
	public String getFieldType() {
		return "ddm-text-html";
	}

	@Override
	public void transform(DDMFormFieldValue ddmFormFieldValue)
		throws PortalException {

		Value value = ddmFormFieldValue.getValue();

		for (Locale locale : value.getAvailableLocales()) {
			String sanitizedValue = sanitize(value.getString(locale));

			value.addString(locale, sanitizedValue);
		}
	}

	protected String sanitize(String value) throws PortalException {
		return SanitizerUtil.sanitize(
			_companyId, _groupId, _userId, Value.class.getName(), 0,
			ContentTypes.TEXT_HTML, Sanitizer.MODE_ALL, value, null);
	}

	private final long _companyId;
	private final long _groupId;
	private final long _userId;

}