/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search;

import com.liferay.portal.kernel.model.BaseModel;

/**
 * @author Eudaldo Alonso
 */
public interface DocumentContributor<T> {

	public void contribute(Document document, BaseModel<T> baseModel);

}