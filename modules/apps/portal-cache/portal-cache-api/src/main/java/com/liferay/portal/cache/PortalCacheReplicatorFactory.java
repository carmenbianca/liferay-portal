/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.cache;

import java.io.Serializable;

import java.util.Properties;

/**
 * @author Tina Tian
 */
public interface PortalCacheReplicatorFactory {

	public <K extends Serializable, V extends Serializable>
		PortalCacheReplicator<K, V> create(Properties properties);

}