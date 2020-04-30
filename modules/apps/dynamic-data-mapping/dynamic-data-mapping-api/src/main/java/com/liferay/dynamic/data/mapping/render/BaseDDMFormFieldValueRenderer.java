/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.render;

import com.liferay.dynamic.data.mapping.storage.DDMFormFieldValue;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.ListUtil;

import java.util.List;
import java.util.Locale;

/**
 * @author Marcellus Tavares
 */
public abstract class BaseDDMFormFieldValueRenderer
	implements DDMFormFieldValueRenderer {

	@Override
	public String render(DDMFormFieldValue ddmFormFieldValue, Locale locale) {
		ValueAccessor valueAccessor = getValueAccessor(locale);

		return valueAccessor.get(ddmFormFieldValue);
	}

	@Override
	public String render(
		List<DDMFormFieldValue> ddmFormFieldValues, Locale locale) {

		return ListUtil.toString(
			ddmFormFieldValues, getValueAccessor(locale),
			StringPool.COMMA_AND_SPACE);
	}

	protected abstract ValueAccessor getValueAccessor(Locale locale);

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getValueAccessor(Locale)}
	 */
	@Deprecated
	protected ValueAccessor getValueAcessor(Locale locale) {
		return getValueAccessor(locale);
	}

}