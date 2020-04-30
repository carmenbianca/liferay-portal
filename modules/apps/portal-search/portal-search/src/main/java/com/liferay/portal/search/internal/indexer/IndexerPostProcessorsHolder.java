/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.indexer;

import com.liferay.portal.kernel.search.IndexerPostProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author André de Oliveira
 */
public class IndexerPostProcessorsHolder {

	public void addIndexerPostProcessor(
		IndexerPostProcessor indexerPostProcessor) {

		_indexerPostProcessors.add(indexerPostProcessor);
	}

	public void forEach(Consumer<IndexerPostProcessor> consumer) {
		_indexerPostProcessors.forEach(consumer);
	}

	public void removeIndexerPostProcessor(
		IndexerPostProcessor indexerPostProcessor) {

		_indexerPostProcessors.remove(indexerPostProcessor);
	}

	public IndexerPostProcessor[] toArray() {
		return _indexerPostProcessors.toArray(new IndexerPostProcessor[0]);
	}

	private final List<IndexerPostProcessor> _indexerPostProcessors =
		new ArrayList<>();

}