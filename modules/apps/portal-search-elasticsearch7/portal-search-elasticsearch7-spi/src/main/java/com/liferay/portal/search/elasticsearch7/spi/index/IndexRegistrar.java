/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.spi.index;

import com.liferay.portal.search.elasticsearch7.spi.index.helper.IndexRegistrarHelper;

/**
 * @author André de Oliveira
 */
public interface IndexRegistrar {

	public void register(IndexRegistrarHelper indexRegistrarHelper);

}