/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.xml;

import org.osgi.annotation.versioning.ProviderType;

import org.xml.sax.InputSource;

/**
 * @author Marcellus Tavares
 */
@ProviderType
public interface XMLSchema {

	public String getPublicId();

	public String getSchemaLanguage();

	public InputSource getSchemaSource();

	public String getSystemId();

}