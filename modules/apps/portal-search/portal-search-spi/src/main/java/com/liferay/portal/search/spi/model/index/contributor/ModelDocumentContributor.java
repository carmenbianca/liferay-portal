/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.spi.model.index.contributor;

import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.search.Document;

/**
 * @author Michael C. Han
 */
public interface ModelDocumentContributor<T extends BaseModel<?>> {

	public void contribute(Document document, T baseModel);

}