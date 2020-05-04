/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type.internal.grid;

import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldValueRenderer;
import com.liferay.dynamic.data.mapping.model.DDMFormField;
import com.liferay.dynamic.data.mapping.model.DDMFormFieldOptions;
import com.liferay.dynamic.data.mapping.model.LocalizedValue;
import com.liferay.dynamic.data.mapping.storage.DDMFormFieldValue;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.Locale;
import java.util.Set;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pedro Queiroz
 */
@Component(
	immediate = true, property = "ddm.form.field.type.name=grid",
	service = DDMFormFieldValueRenderer.class
)
public class GridDDMFormFieldValueRenderer
	implements DDMFormFieldValueRenderer {

	@Override
	public String render(DDMFormFieldValue ddmFormFieldValue, Locale locale) {
		JSONObject valuesJSONObject = gridDDMFormFieldValueAccessor.getValue(
			ddmFormFieldValue, locale);

		if (valuesJSONObject.length() == 0) {
			return StringPool.BLANK;
		}

		DDMFormFieldOptions rows = getDDMFormFieldOptions(
			ddmFormFieldValue, "rows");
		DDMFormFieldOptions columns = getDDMFormFieldOptions(
			ddmFormFieldValue, "columns");

		StringBundler sb = new StringBundler(valuesJSONObject.length() * 5);

		Set<String> rowOptions = rows.getOptionsValues();

		for (String rowOption : rowOptions) {
			if (valuesJSONObject.has(rowOption)) {
				String columnOption = valuesJSONObject.getString(rowOption);

				LocalizedValue rowLabel = rows.getOptionLabels(rowOption);
				LocalizedValue columnLabel = columns.getOptionLabels(
					columnOption);

				sb.append(getLabel(rowLabel, rowOption, locale));

				sb.append(StringPool.COLON);
				sb.append(StringPool.SPACE);

				sb.append(getLabel(columnLabel, columnOption, locale));

				sb.append(StringPool.COMMA_AND_SPACE);
			}
		}

		if (sb.index() > 0) {
			sb.setIndex(sb.index() - 1);
		}

		return sb.toString();
	}

	protected DDMFormFieldOptions getDDMFormFieldOptions(
		DDMFormFieldValue ddmFormFieldValue, String optionType) {

		DDMFormField ddmFormField = ddmFormFieldValue.getDDMFormField();

		return (DDMFormFieldOptions)ddmFormField.getProperty(optionType);
	}

	protected String getLabel(
		LocalizedValue label, String defaultLabel, Locale locale) {

		if (label != null) {
			return label.getString(locale);
		}

		return defaultLabel;
	}

	@Reference
	protected GridDDMFormFieldValueAccessor gridDDMFormFieldValueAccessor;

}