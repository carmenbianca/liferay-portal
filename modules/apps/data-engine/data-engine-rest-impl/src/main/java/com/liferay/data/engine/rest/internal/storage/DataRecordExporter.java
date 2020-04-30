/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.data.engine.rest.internal.storage;

import com.liferay.data.engine.rest.dto.v2_0.DataDefinition;
import com.liferay.data.engine.rest.dto.v2_0.DataRecord;
import com.liferay.data.engine.rest.internal.dto.v2_0.util.DataDefinitionUtil;
import com.liferay.data.engine.rest.internal.dto.v2_0.util.DataRecordValuesUtil;
import com.liferay.dynamic.data.lists.model.DDLRecordSet;
import com.liferay.dynamic.data.lists.service.DDLRecordSetLocalService;
import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldTypeServicesTracker;
import com.liferay.dynamic.data.mapping.spi.converter.SPIDDMFormRuleConverter;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author Jeyvison Nascimento
 */
public class DataRecordExporter {

	public DataRecordExporter(
		DDLRecordSetLocalService ddlRecordSetLocalService,
		DDMFormFieldTypeServicesTracker ddmFormFieldTypeServicesTracker,
		SPIDDMFormRuleConverter spiDDMFormRuleConverter) {

		_ddlRecordSetLocalService = ddlRecordSetLocalService;
		_ddmFormFieldTypeServicesTracker = ddmFormFieldTypeServicesTracker;
		_spiDDMFormRuleConverter = spiDDMFormRuleConverter;
	}

	public String export(List<DataRecord> dataRecords) throws Exception {
		if (ListUtil.isEmpty(dataRecords)) {
			return StringPool.BLANK;
		}

		DataRecord dataRecord = dataRecords.get(0);

		DDLRecordSet ddlRecordSet = _ddlRecordSetLocalService.getRecordSet(
			dataRecord.getDataRecordCollectionId());

		DataDefinition dataDefinition = DataDefinitionUtil.toDataDefinition(
			_ddmFormFieldTypeServicesTracker, ddlRecordSet.getDDMStructure(),
			_spiDDMFormRuleConverter);

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		Stream<DataRecord> stream = dataRecords.parallelStream();

		stream.map(
			record -> _toJSON(dataDefinition, record)
		).forEach(
			jsonArray::put
		);

		return jsonArray.toString();
	}

	private String _toJSON(
		DataDefinition dataDefinition, DataRecord dataRecord) {

		try {
			return DataRecordValuesUtil.toJSON(
				dataDefinition, dataRecord.getDataRecordValues());
		}
		catch (Exception exception) {
			return StringPool.BLANK;
		}
	}

	private final DDLRecordSetLocalService _ddlRecordSetLocalService;
	private final DDMFormFieldTypeServicesTracker
		_ddmFormFieldTypeServicesTracker;
	private final SPIDDMFormRuleConverter _spiDDMFormRuleConverter;

}