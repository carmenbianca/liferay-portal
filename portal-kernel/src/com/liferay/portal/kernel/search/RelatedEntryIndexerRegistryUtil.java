/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search;

import com.liferay.portal.kernel.util.ServiceProxyFactory;

import java.util.List;

/**
 * @author Michael C. Han
 */
public class RelatedEntryIndexerRegistryUtil {

	public static List<RelatedEntryIndexer> getRelatedEntryIndexers() {
		return _relatedEntryIndexerRegistry.getRelatedEntryIndexers();
	}

	public static List<RelatedEntryIndexer> getRelatedEntryIndexers(
		Class clazz) {

		return _relatedEntryIndexerRegistry.getRelatedEntryIndexers(clazz);
	}

	public static List<RelatedEntryIndexer> getRelatedEntryIndexers(
		String className) {

		return _relatedEntryIndexerRegistry.getRelatedEntryIndexers(className);
	}

	private static volatile RelatedEntryIndexerRegistry
		_relatedEntryIndexerRegistry =
			ServiceProxyFactory.newServiceTrackedInstance(
				RelatedEntryIndexerRegistry.class,
				RelatedEntryIndexerRegistryUtil.class,
				"_relatedEntryIndexerRegistry", false);

}