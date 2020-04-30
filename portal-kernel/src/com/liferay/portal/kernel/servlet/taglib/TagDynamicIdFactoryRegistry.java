/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.servlet.taglib;

import com.liferay.registry.collections.ServiceTrackerCollections;
import com.liferay.registry.collections.ServiceTrackerMap;

/**
 * @author Carlos Sierra Andrés
 */
public class TagDynamicIdFactoryRegistry {

	public static TagDynamicIdFactory getTagDynamicIdFactory(
		String tagClassName) {

		return _tagDynamicIdFactoryRegistry._tagDynamicIdFactories.getService(
			tagClassName);
	}

	private static final TagDynamicIdFactoryRegistry
		_tagDynamicIdFactoryRegistry = new TagDynamicIdFactoryRegistry();

	private final ServiceTrackerMap<String, TagDynamicIdFactory>
		_tagDynamicIdFactories = ServiceTrackerCollections.openSingleValueMap(
			TagDynamicIdFactory.class, "tagClassName");

}