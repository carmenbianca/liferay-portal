/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.info.list.provider;

import com.liferay.info.pagination.Pagination;
import com.liferay.info.sort.Sort;

import java.util.List;
import java.util.Locale;

/**
 * @author Jorge Ferrer
 */
public interface InfoListProvider<T> {

	public List<T> getInfoList(InfoListProviderContext infoListProviderContext);

	public List<T> getInfoList(
		InfoListProviderContext infoListProviderContext, Pagination pagination,
		Sort sort);

	public int getInfoListCount(
		InfoListProviderContext infoListProviderContext);

	public default String getKey() {
		Class<?> clazz = getClass();

		return clazz.getName();
	}

	public String getLabel(Locale locale);

	public default boolean isAvailable(
		InfoListProviderContext infoListProviderContext) {

		return true;
	}

}