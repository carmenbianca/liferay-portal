/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal;

import java.util.Optional;

/**
 * @author André de Oliveira
 */
public interface FacetProcessorContext {

	public Optional<String> getExcludeTagsStringOptional();

}