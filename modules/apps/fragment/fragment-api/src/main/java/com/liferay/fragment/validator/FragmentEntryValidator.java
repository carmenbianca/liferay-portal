/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.validator;

import com.liferay.fragment.exception.FragmentEntryConfigurationException;
import com.liferay.portal.kernel.json.JSONObject;

/**
 * @author Rubén Pulido
 */
public interface FragmentEntryValidator {

	public void validateConfiguration(String configuration)
		throws FragmentEntryConfigurationException;

	public default void validateConfigurationValues(
			String configuration, JSONObject valuesJSONObject)
		throws FragmentEntryConfigurationException {
	}

}