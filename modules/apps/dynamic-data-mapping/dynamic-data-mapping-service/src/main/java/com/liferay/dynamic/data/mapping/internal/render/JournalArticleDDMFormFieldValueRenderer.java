/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.internal.render;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.dynamic.data.mapping.model.DDMFormFieldType;
import com.liferay.dynamic.data.mapping.model.Value;
import com.liferay.dynamic.data.mapping.render.BaseDDMFormFieldValueRenderer;
import com.liferay.dynamic.data.mapping.render.ValueAccessor;
import com.liferay.dynamic.data.mapping.render.ValueAccessorException;
import com.liferay.dynamic.data.mapping.storage.DDMFormFieldValue;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Locale;

/**
 * @author Marcellus Tavares
 */
public class JournalArticleDDMFormFieldValueRenderer
	extends BaseDDMFormFieldValueRenderer {

	@Override
	public String getSupportedDDMFormFieldType() {
		return DDMFormFieldType.JOURNAL_ARTICLE;
	}

	@Override
	protected ValueAccessor getValueAccessor(Locale locale) {
		return new ValueAccessor(locale) {

			@Override
			public String get(DDMFormFieldValue ddmFormFieldValue) {
				Value value = ddmFormFieldValue.getValue();

				JSONObject jsonObject = createJSONObject(
					value.getString(locale));

				String className = jsonObject.getString("className");
				long classPK = jsonObject.getLong("classPK");

				if (Validator.isNull(className) && (classPK == 0)) {
					return StringPool.BLANK;
				}

				try {
					AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(
						className, classPK);

					return assetEntry.getTitle(locale);
				}
				catch (Exception exception) {
					return LanguageUtil.format(
						locale, "is-temporarily-unavailable", "content");
				}
			}

			protected JSONObject createJSONObject(String json) {
				try {
					return JSONFactoryUtil.createJSONObject(json);
				}
				catch (JSONException jsonException) {
					throw new ValueAccessorException(jsonException);
				}
			}

		};
	}

}