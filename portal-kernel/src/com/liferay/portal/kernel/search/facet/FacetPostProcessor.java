/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search.facet;

import com.liferay.portal.kernel.search.Document;

import java.util.Collection;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author André de Oliveira
 */
@ProviderType
public interface FacetPostProcessor {

	public void exclude(Collection<Document> documents, Facet facet);

}