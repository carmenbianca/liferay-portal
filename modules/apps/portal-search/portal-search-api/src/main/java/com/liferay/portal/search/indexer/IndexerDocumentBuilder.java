/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.indexer;

import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.search.Document;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface IndexerDocumentBuilder {

	public <T extends BaseModel<?>> Document getDocument(T object);

	public <T extends BaseModel<?>> String getDocumentUID(T object);

}