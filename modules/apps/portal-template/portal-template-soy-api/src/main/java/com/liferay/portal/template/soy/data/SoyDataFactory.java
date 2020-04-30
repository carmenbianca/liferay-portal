/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.template.soy.data;

import com.liferay.portal.template.soy.util.SoyRawData;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Describes the API of an OSGi service that creates specialized complex types
 * that can be used in Soy templates.
 *
 * @author Iván Zaera Avellón
 * @review
 */
@ProviderType
public interface SoyDataFactory {

	/**
	 * @deprecated As of Mueller (7.2.x), replaced by {@link
	 *             #createSoyRawData(String)}
	 */
	@Deprecated
	public SoyHTMLData createSoyHTMLData(String html);

	public SoyRawData createSoyRawData(String html);

}