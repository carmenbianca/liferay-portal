/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.indexer;

import com.liferay.portal.search.spi.model.query.contributor.QueryPreFilterContributor;

import java.util.function.Consumer;

/**
 * @author André de Oliveira
 */
public interface QueryPreFilterContributorsHolder {

	public void forEach(Consumer<QueryPreFilterContributor> consumer);

}