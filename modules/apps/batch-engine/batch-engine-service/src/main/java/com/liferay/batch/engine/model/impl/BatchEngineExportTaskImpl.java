/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.batch.engine.model.impl;

import com.liferay.petra.string.StringPool;
import com.liferay.petra.string.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Collections;
import java.util.List;

/**
 * @author Ivica Cardic
 */
public class BatchEngineExportTaskImpl extends BatchEngineExportTaskBaseImpl {

	public BatchEngineExportTaskImpl() {
	}

	@Override
	public List<String> getFieldNamesList() {
		if (Validator.isNull(getFieldNames())) {
			return Collections.emptyList();
		}

		return StringUtil.split(getFieldNames());
	}

	@Override
	public void setFieldNamesList(List<String> fieldNamesList) {
		setFieldNames(StringUtil.merge(fieldNamesList, StringPool.COMMA));
	}

}