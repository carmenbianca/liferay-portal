/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.internal.upgrade.v2_0_5;

import com.liferay.portal.kernel.dao.jdbc.AutoBatchPreparedStatementUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.PortalUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.HashMap;
import java.util.Map;

/**
 * @author István András Dézsi
 */
public class UpgradeDDMFormFieldValidation extends UpgradeProcess {

	public UpgradeDDMFormFieldValidation(JSONFactory jsonFactory) {
		_jsonFactory = jsonFactory;
	}

	@Override
	protected void doUpgrade() throws Exception {
		try (PreparedStatement ps1 = connection.prepareStatement(
				"select structureId, definition from DDMStructure where " +
					"classNameId = ? ");
			PreparedStatement ps2 =
				AutoBatchPreparedStatementUtil.concurrentAutoBatch(
					connection,
					"update DDMStructure set definition = ? where " +
						"structureId = ?");
			PreparedStatement ps3 = connection.prepareStatement(
				"select structureVersionId, definition from " +
					"DDMStructureVersion where structureId = ?");
			PreparedStatement ps4 =
				AutoBatchPreparedStatementUtil.concurrentAutoBatch(
					connection,
					"update DDMStructureVersion set definition = ? where " +
						"structureVersionId = ?")) {

			ps1.setLong(1, getClassNameId());

			try (ResultSet rs = ps1.executeQuery()) {
				while (rs.next()) {
					String definition = rs.getString("definition");

					ps2.setString(1, makeFieldsLocalizable(definition));

					long structureId = rs.getLong("structureId");

					ps2.setLong(2, structureId);

					ps2.addBatch();

					ps3.setLong(1, structureId);

					try (ResultSet rs2 = ps3.executeQuery()) {
						while (rs2.next()) {
							definition = rs2.getString("definition");

							ps4.setString(1, makeFieldsLocalizable(definition));

							long structureVersionId = rs2.getLong(
								"structureVersionId");

							ps4.setLong(2, structureVersionId);

							ps4.addBatch();
						}
					}
				}
			}

			ps2.executeBatch();

			ps4.executeBatch();
		}
	}

	protected long getClassNameId() {
		return PortalUtil.getClassNameId(
			"com.liferay.dynamic.data.mapping.model.DDMFormInstance");
	}

	protected void makeFieldsLocalizable(
		JSONArray availableLanguageIdsJSONArray, JSONArray fieldsJSONArray) {

		for (int i = 0; i < fieldsJSONArray.length(); i++) {
			JSONObject jsonObject = fieldsJSONArray.getJSONObject(i);

			if (!_hasValidation(jsonObject)) {
				continue;
			}

			JSONObject validationJSONObject = jsonObject.getJSONObject(
				"validation");

			String originalValue = validationJSONObject.getString(
				"errorMessage");

			if (JSONUtil.isValid(originalValue)) {
				continue;
			}

			Map<String, String> localizedValue = new HashMap<>();

			for (int j = 0; j < availableLanguageIdsJSONArray.length(); j++) {
				localizedValue.put(
					availableLanguageIdsJSONArray.getString(j), originalValue);
			}

			validationJSONObject.put("errorMessage", localizedValue);

			JSONArray nestedFieldsJSONArray = jsonObject.getJSONArray(
				"nestedFields");

			if (nestedFieldsJSONArray != null) {
				makeFieldsLocalizable(
					availableLanguageIdsJSONArray, nestedFieldsJSONArray);
			}
		}
	}

	protected String makeFieldsLocalizable(String definition)
		throws PortalException {

		JSONObject jsonObject = _jsonFactory.createJSONObject(definition);

		JSONArray availableLanguageIdsJSONArray = jsonObject.getJSONArray(
			"availableLanguageIds");

		JSONArray fieldsJSONArray = jsonObject.getJSONArray("fields");

		makeFieldsLocalizable(availableLanguageIdsJSONArray, fieldsJSONArray);

		return jsonObject.toJSONString();
	}

	private boolean _hasValidation(JSONObject fieldJSONObject) {
		JSONObject validationJSONObject = fieldJSONObject.getJSONObject(
			"validation");

		if (validationJSONObject == null) {
			return false;
		}

		return true;
	}

	private final JSONFactory _jsonFactory;

}