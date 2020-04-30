/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.list.retriever;

import com.liferay.item.selector.ItemSelectorReturnType;
import com.liferay.portal.kernel.json.JSONObject;

/**
 * @author Eudaldo Alonso
 */
public interface ListObjectReferenceFactory<T extends ItemSelectorReturnType> {

	public ListObjectReference getListObjectReference(JSONObject jsonObject);

}