/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.info.display.field;

import com.liferay.info.display.contributor.InfoDisplayField;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Jürgen Kappler
 */
@ProviderType
public interface InfoDisplayFieldProvider {

	public Set<InfoDisplayField> getContributorInfoDisplayFields(
		Locale locale, String... classNames);

	public Map<String, Object> getContributorInfoDisplayFieldsValues(
			String className, Object displayObject, Locale locale)
		throws PortalException;

}