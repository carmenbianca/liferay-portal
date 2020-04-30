/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.orm;

/**
 * @author Raymond Augé
 */
public interface ProjectionList extends Projection {

	public ProjectionList add(Projection projection);

	public ProjectionList add(Projection projection, String alias);

}