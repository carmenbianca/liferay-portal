/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.query;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author André de Oliveira
 * @author Miguel Angelo Caldas Gallindo
 */
@ProviderType
public interface QueryTranslator<T> {

	public T translate(Query query);

}