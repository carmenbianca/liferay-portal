/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.internal.upgrade.v3_2_4;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.jdbc.AutoBatchPreparedStatementUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.text.DecimalFormat;
import java.text.ParseException;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Rodrigo Paulino
 */
public class UpgradeDDMContent extends UpgradeProcess {

	public UpgradeDDMContent(JSONFactory jsonFactory) {
		_jsonFactory = jsonFactory;
	}

	@Override
	protected void doUpgrade() throws Exception {
		try (PreparedStatement ps1 = connection.prepareStatement(
				StringBundler.concat(
					"select contentId, data_, DDMStructureVersion.definition ",
					"from DDMContent join DDMFormInstanceRecordVersion on  ",
					"storageId = contentId join DDMFormInstanceVersion on ",
					"DDMFormInstanceVersion.formInstanceId = ",
					"DDMFormInstanceRecordVersion.formInstanceId and ",
					"DDMFormInstanceVersion.version = ",
					"DDMFormInstanceRecordVersion.formInstanceVersion join ",
					"DDMStructureVersion on DDMStructureVersion.",
					"structureVersionId = DDMFormInstanceVersion.",
					"structureVersionId"));
			PreparedStatement ps2 =
				AutoBatchPreparedStatementUtil.concurrentAutoBatch(
					connection,
					"update DDMContent set data_ = ? where contentId = ?")) {

			try (ResultSet rs = ps1.executeQuery()) {
				while (rs.next()) {
					String definition = rs.getString("definition");

					JSONObject definitionJSONObject =
						_jsonFactory.createJSONObject(definition);

					String data = rs.getString("data_");

					JSONObject dataJSONObject = _jsonFactory.createJSONObject(
						data);

					if (_upgradeDDMContentData(
							dataJSONObject.getJSONArray("fieldValues"),
							definitionJSONObject.getJSONArray("fields"))) {

						ps2.setString(1, dataJSONObject.toJSONString());

						long contentId = rs.getLong("contentId");

						ps2.setLong(2, contentId);

						ps2.addBatch();
					}
				}
			}

			ps2.executeBatch();
		}
	}

	private DecimalFormat _getDecimalFormat(Locale locale) {
		DecimalFormat decimalFormat = _decimalFormatsMap.get(locale);

		if (decimalFormat == null) {
			decimalFormat = (DecimalFormat)DecimalFormat.getInstance(locale);

			decimalFormat.setGroupingUsed(false);
			decimalFormat.setMaximumFractionDigits(Integer.MAX_VALUE);
			decimalFormat.setParseBigDecimal(true);

			_decimalFormatsMap.put(locale, decimalFormat);
		}

		return decimalFormat;
	}

	private HashMap<String, JSONObject> _mapDataFieldValues(
		JSONArray fieldValuesJSONArray) {

		HashMap<String, JSONObject> dataFieldValuesMap = new HashMap<>();

		fieldValuesJSONArray.forEach(
			object -> {
				JSONObject fieldValueJSONObject = (JSONObject)object;

				dataFieldValuesMap.put(
					fieldValueJSONObject.getString("name"),
					fieldValueJSONObject.getJSONObject("value"));
			});

		return dataFieldValuesMap;
	}

	private boolean _upgradeDDMContentData(
		JSONArray fieldValuesJSONArray, JSONArray fieldsJSONArray) {

		AtomicBoolean upgraded = new AtomicBoolean(false);

		HashMap<String, JSONObject> dataFieldValuesMap = _mapDataFieldValues(
			fieldValuesJSONArray);

		fieldsJSONArray.forEach(
			object -> {
				JSONObject fieldJSONObject = (JSONObject)object;

				String type = fieldJSONObject.getString("type");

				if (type.equals("numeric")) {
					String name = fieldJSONObject.getString("name");

					JSONObject fieldValueJSONObject = dataFieldValuesMap.get(
						name);

					JSONArray namesJSONArray = fieldValueJSONObject.names();

					namesJSONArray.forEach(
						languageId -> {
							try {
								DecimalFormat decimalFormat = _getDecimalFormat(
									LocaleUtil.fromLanguageId(
										GetterUtil.getString(languageId)));

								String valueString =
									fieldValueJSONObject.getString(
										GetterUtil.getString(languageId));

								Number number = GetterUtil.getNumber(
									decimalFormat.parse(valueString));

								String formattedNumber = decimalFormat.format(
									number);

								if (!valueString.equals(formattedNumber)) {
									DecimalFormat defaultDecimalFormat =
										_getDecimalFormat(LocaleUtil.US);

									number = defaultDecimalFormat.parse(
										valueString);

									formattedNumber = decimalFormat.format(
										number);

									upgraded.set(true);

									fieldValueJSONObject.put(
										languageId.toString(), formattedNumber);
								}
							}
							catch (ParseException parseException) {
								if (_log.isWarnEnabled()) {
									_log.warn(parseException, parseException);
								}
							}
						});
				}
			});

		return upgraded.get();
	}

	private static final Log _log = LogFactoryUtil.getLog(
		UpgradeDDMContent.class);

	private static final Map<Locale, DecimalFormat> _decimalFormatsMap =
		new ConcurrentHashMap<>();

	private final JSONFactory _jsonFactory;

}