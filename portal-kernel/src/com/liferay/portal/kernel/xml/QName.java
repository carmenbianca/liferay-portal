/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.xml;

import java.io.Serializable;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 */
@ProviderType
public interface QName extends Serializable {

	public String getLocalPart();

	public String getName();

	public Namespace getNamespace();

	public String getNamespacePrefix();

	public String getNamespaceURI();

	public String getQualifiedName();

}