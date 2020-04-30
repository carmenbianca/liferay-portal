/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.test.util.indexing;

import com.liferay.portal.kernel.search.Query;

/**
 * @author André de Oliveira
 */
public interface QueryContributor {

	public void contribute(Query query);

}