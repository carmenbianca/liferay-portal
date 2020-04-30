/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.info.provider;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author     Eudaldo Alonso
 * @deprecated As of Mueller (7.2.x), moved to {@link
 *             com.liferay.info.list.provider.InfoListProviderTracker}
 */
@Deprecated
@ProviderType
public interface InfoListProviderTracker {

	public InfoListProvider getInfoListProvider(String className);

	public List<InfoListProvider> getInfoListProviders();

	public List<InfoListProvider> getInfoListProviders(Class<?> itemClass);

}