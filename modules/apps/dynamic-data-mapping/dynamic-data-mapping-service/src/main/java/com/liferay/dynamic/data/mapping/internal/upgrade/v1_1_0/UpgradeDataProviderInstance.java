/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.internal.upgrade.v1_1_0;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.jdbc.AutoBatchPreparedStatementUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.StringUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Inácio Nery
 */
public class UpgradeDataProviderInstance extends UpgradeProcess {

	public UpgradeDataProviderInstance(JSONFactory jsonFactory) {
		_jsonFactory = jsonFactory;
	}

	@Override
	protected void doUpgrade() throws Exception {
		StringBundler sb = new StringBundler(3);

		sb.append("select DDMDataProviderInstance.definition, ");
		sb.append("DDMDataProviderInstance.dataProviderInstanceId from ");
		sb.append("DDMDataProviderInstance");

		try (PreparedStatement ps1 = connection.prepareStatement(sb.toString());
			PreparedStatement ps2 =
				AutoBatchPreparedStatementUtil.concurrentAutoBatch(
					connection,
					"update DDMDataProviderInstance set definition = ? where " +
						"dataProviderInstanceId = ?")) {

			try (ResultSet rs = ps1.executeQuery()) {
				while (rs.next()) {
					String definition = rs.getString(1);
					long dataProviderInstanceId = rs.getLong(2);

					String newDefinition =
						upgradeDataProviderInstanceDefinition(definition);

					ps2.setString(1, newDefinition);

					ps2.setLong(2, dataProviderInstanceId);

					ps2.addBatch();
				}

				ps2.executeBatch();
			}
		}
	}

	protected String upgradeDataProviderInstanceDefinition(String definition)
		throws JSONException {

		JSONObject definitionJSONObject = _jsonFactory.createJSONObject(
			definition);

		JSONArray fieldValuesJSONArray = definitionJSONObject.getJSONArray(
			"fieldValues");

		upgradeDataProviderInstanceFieldValues(fieldValuesJSONArray);

		return definitionJSONObject.toString();
	}

	protected void upgradeDataProviderInstanceFieldValues(
		JSONArray fieldValuesJSONArray) {

		JSONObject fieldValueJSONObject = _jsonFactory.createJSONObject();

		fieldValueJSONObject.put(
			"instanceId", StringUtil.randomString(8)
		).put(
			"name", "filterable"
		).put(
			"value", "false"
		);

		fieldValuesJSONArray.put(fieldValueJSONObject);

		fieldValueJSONObject = _jsonFactory.createJSONObject();

		fieldValueJSONObject.put(
			"instanceId", StringUtil.randomString(8)
		).put(
			"name", "filterParameterName"
		).put(
			"value", ""
		);

		fieldValuesJSONArray.put(fieldValueJSONObject);
	}

	private final JSONFactory _jsonFactory;

}