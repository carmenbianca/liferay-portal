/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.builder.rule;

import com.liferay.dynamic.data.mapping.model.DDMForm;
import com.liferay.dynamic.data.mapping.model.DDMFormRule;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;

import java.util.List;

/**
 * @author Gabriel Albuquerque
 */
public interface DDMFormRuleDeserializer {

	public List<DDMFormRule> deserialize(DDMForm ddmForm, JSONArray jsonArray)
		throws PortalException;

}