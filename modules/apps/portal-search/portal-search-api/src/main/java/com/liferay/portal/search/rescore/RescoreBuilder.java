/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.rescore;

import com.liferay.portal.search.query.Query;

/**
 * @author Bryan Engler
 */
public interface RescoreBuilder {

	public Rescore build();

	public RescoreBuilder query(Query query);

	public RescoreBuilder windowSize(Integer windowSize);

}