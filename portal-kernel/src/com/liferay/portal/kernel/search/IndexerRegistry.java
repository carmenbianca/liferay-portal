/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search;

import java.util.Set;

/**
 * @author Michael C. Han
 */
public interface IndexerRegistry {

	public <T> Indexer<T> getIndexer(Class<T> clazz);

	public <T> Indexer<T> getIndexer(String className);

	public Set<Indexer<?>> getIndexers();

	public <T> Indexer<T> nullSafeGetIndexer(Class<T> clazz);

	public <T> Indexer<T> nullSafeGetIndexer(String className);

	public void register(Indexer<?> indexer);

	public void unregister(Indexer<?> indexer);

	public void unregister(String className);

}