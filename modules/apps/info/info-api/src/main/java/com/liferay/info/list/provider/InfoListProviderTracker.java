/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.info.list.provider;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Eudaldo Alonso
 */
@ProviderType
public interface InfoListProviderTracker {

	public InfoListProvider getInfoListProvider(String key);

	public List<InfoListProvider> getInfoListProviders();

	public List<InfoListProvider> getInfoListProviders(Class<?> itemClass);

	public List<InfoListProvider> getInfoListProviders(String itemClassName);

}