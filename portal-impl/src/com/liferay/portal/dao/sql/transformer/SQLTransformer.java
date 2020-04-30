/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.dao.sql.transformer;

/**
 * @author Manuel de la Peña
 * @author Brian Wing Shun Chan
 */
public interface SQLTransformer {

	public String transform(String sql);

}