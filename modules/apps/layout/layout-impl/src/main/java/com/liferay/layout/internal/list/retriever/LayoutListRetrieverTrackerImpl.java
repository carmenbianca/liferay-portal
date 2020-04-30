/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.internal.list.retriever;

import com.liferay.layout.internal.list.retriever.util.GenericsUtil;
import com.liferay.layout.list.retriever.LayoutListRetriever;
import com.liferay.layout.list.retriever.LayoutListRetrieverTracker;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

/**
 * @author Eudaldo Alonso
 */
@Component(immediate = true, service = LayoutListRetrieverTracker.class)
public class LayoutListRetrieverTrackerImpl
	implements LayoutListRetrieverTracker {

	public LayoutListRetriever getLayoutListRetriever(String type) {
		return _layoutListRetrievers.get(type);
	}

	@Reference(
		cardinality = ReferenceCardinality.MULTIPLE,
		policy = ReferencePolicy.DYNAMIC
	)
	protected void setLayoutListRetrievers(
		LayoutListRetriever layoutListRetriever) {

		_layoutListRetrievers.put(
			GenericsUtil.getItemClassName(layoutListRetriever),
			layoutListRetriever);
	}

	protected void unsetLayoutListRetrievers(
		LayoutListRetriever layoutListRetriever) {

		_layoutListRetrievers.remove(
			GenericsUtil.getItemClassName(layoutListRetriever));
	}

	private final Map<String, LayoutListRetriever> _layoutListRetrievers =
		new ConcurrentHashMap<>();

}