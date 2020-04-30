/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.groupby;

import com.liferay.portal.search.groupby.GroupByResponse;
import com.liferay.portal.search.groupby.GroupByResponseFactory;

import org.osgi.service.component.annotations.Component;

/**
 * @author Bryan Engler
 */
@Component(immediate = true, service = GroupByResponseFactory.class)
public class GroupByResponseFactoryImpl implements GroupByResponseFactory {

	@Override
	public GroupByResponse getGroupByResponse(String field) {
		return new GroupByResponseImpl(field);
	}

}