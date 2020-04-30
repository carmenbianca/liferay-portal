/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.dao.sql.transformer;

import java.util.function.Function;

/**
 * @author Manuel de la Peña
 * @author Brian Wing Shun Chan
 */
public interface SQLTransformerLogic {

	public Function<String, String>[] getFunctions();

}