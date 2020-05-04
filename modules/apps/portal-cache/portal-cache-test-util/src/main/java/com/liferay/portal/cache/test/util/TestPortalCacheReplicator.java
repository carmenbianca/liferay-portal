/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.cache.test.util;

import com.liferay.portal.cache.PortalCacheReplicator;

import java.io.Serializable;

/**
 * @author Tina Tian
 */
public class TestPortalCacheReplicator
	<K extends Serializable, V extends Serializable>
		extends TestPortalCacheListener<K, V>
		implements PortalCacheReplicator<K, V> {
}