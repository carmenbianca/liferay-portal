/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search;

import java.util.Comparator;

/**
 * @author Preston Crary
 */
public class IndexerClassNameComparator implements Comparator<Indexer<?>> {

	public IndexerClassNameComparator() {
		this(false);
	}

	public IndexerClassNameComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Indexer<?> indexer1, Indexer<?> indexer2) {
		String className1 = indexer1.getClassName();
		String className2 = indexer2.getClassName();

		int value = className1.compareTo(className2);

		if (_ascending) {
			return value;
		}

		return -value;
	}

	public boolean isAscending() {
		return _ascending;
	}

	private final boolean _ascending;

}