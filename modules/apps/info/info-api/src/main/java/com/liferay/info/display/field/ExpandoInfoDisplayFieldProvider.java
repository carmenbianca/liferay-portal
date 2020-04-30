/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.info.display.field;

import com.liferay.info.display.contributor.InfoDisplayField;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Jürgen Kappler
 */
@ProviderType
public interface ExpandoInfoDisplayFieldProvider {

	public List<InfoDisplayField> getContributorExpandoInfoDisplayFields(
		String className, Locale locale);

	public Map<String, Object> getContributorExpandoInfoDisplayFieldsValues(
		String className, Object displayObject, Locale locale);

}