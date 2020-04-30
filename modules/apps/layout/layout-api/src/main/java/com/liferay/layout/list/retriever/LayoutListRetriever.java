/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.list.retriever;

import com.liferay.item.selector.ItemSelectorReturnType;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Eudaldo Alonso
 */
@ProviderType
public interface LayoutListRetriever
	<T extends ItemSelectorReturnType, S extends ListObjectReference> {

	public List getList(
		S s, LayoutListRetrieverContext layoutListRetrieverContext);

	public int getListCount(
		S s, LayoutListRetrieverContext layoutListRetrieverContext);

}