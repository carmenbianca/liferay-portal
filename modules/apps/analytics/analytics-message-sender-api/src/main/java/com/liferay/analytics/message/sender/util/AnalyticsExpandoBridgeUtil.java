/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.analytics.message.sender.util;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.model.ExpandoColumnConstants;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rachael Koestartyo
 */
public class AnalyticsExpandoBridgeUtil {

	public static Map<String, Serializable> getAttributes(
		ExpandoBridge expandoBridge) {

		Map<String, Serializable> newAttributes = new HashMap<>();

		Map<String, Serializable> attributes = expandoBridge.getAttributes(
			false);

		for (Map.Entry<String, Serializable> entry : attributes.entrySet()) {
			String dataType = ExpandoColumnConstants.getDataType(
				expandoBridge.getAttributeType(entry.getKey()));

			if (Validator.isBlank(dataType)) {
				dataType = ExpandoColumnConstants.DATA_TYPE_TEXT;
			}

			newAttributes.put(
				entry.getKey() + "-" + dataType, entry.getValue());
		}

		return newAttributes;
	}

}