/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.info.provider;

import com.liferay.info.pagination.Pagination;
import com.liferay.info.sort.Sort;

import java.util.List;
import java.util.Locale;

/**
 * @author     Jorge Ferrer
 * @deprecated As of Mueller (7.2.x), moved to {@link
 *             com.liferay.info.list.provider.InfoListProvider}
 */
@Deprecated
public interface InfoListProvider<T> {

	public List<T> getInfoList(InfoListProviderContext infoListProviderContext);

	public List<T> getInfoList(
		InfoListProviderContext infoListProviderContext, Pagination pagination,
		Sort sort);

	public int getInfoListCount(
		InfoListProviderContext infoListProviderContext);

	public String getLabel(Locale locale);

	public default boolean isAvailable(
		InfoListProviderContext infoListProviderContext) {

		return true;
	}

}