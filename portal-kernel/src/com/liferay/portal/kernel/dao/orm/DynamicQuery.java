/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.orm;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public interface DynamicQuery {

	public DynamicQuery add(Criterion criterion);

	public DynamicQuery addOrder(Order order);

	public void compile(Session session);

	@SuppressWarnings("rawtypes")
	public List list();

	@SuppressWarnings("rawtypes")
	public List list(boolean unmodifiable);

	public void setLimit(int start, int end);

	public DynamicQuery setProjection(Projection projection);

	public DynamicQuery setProjection(
		Projection projection, boolean useColumnAlias);

}