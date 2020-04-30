/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.spi.model.index.contributor.helper;

import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.search.Document;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author André de Oliveira
 */
@ProviderType
public interface ModelIndexerWriterDocumentHelper {

	public <T extends BaseModel<?>> Document getDocument(T baseModel);

}