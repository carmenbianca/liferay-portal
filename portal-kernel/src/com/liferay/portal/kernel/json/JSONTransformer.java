/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.json;

/**
 * @author Bruno Basto
 */
public interface JSONTransformer {

	public void transform(JSONContext jsonContext, Object object);

}