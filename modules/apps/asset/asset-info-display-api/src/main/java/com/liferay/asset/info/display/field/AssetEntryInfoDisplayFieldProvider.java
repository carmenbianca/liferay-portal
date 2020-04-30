/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.info.display.field;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Jürgen Kappler
 */
@ProviderType
public interface AssetEntryInfoDisplayFieldProvider {

	public Map<String, Object> getAssetEntryInfoDisplayFieldsValues(
			String className, long classPK, Locale locale)
		throws PortalException;

}