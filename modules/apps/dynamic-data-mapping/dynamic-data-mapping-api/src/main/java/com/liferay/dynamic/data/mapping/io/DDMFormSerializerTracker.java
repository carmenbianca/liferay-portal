/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.io;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author     Leonardo Barros
 * @deprecated As of Mueller (7.2.x), with no direct replacement
 */
@Deprecated
@ProviderType
public interface DDMFormSerializerTracker {

	public DDMFormSerializer getDDMFormSerializer(String type);

}