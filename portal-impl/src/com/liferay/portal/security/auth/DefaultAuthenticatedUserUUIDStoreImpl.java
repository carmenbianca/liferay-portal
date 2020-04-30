/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.auth;

import com.liferay.portal.kernel.security.auth.AuthenticatedUserUUIDStore;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author     Michael C. Han
 * @deprecated As of Judson (7.1.x), with no direct replacement
 */
@Deprecated
public class DefaultAuthenticatedUserUUIDStoreImpl
	implements AuthenticatedUserUUIDStore {

	@Override
	public boolean exists(String userUUID) {
		return _userUUIDStore.contains(userUUID);
	}

	@Override
	public boolean register(String userUUID) {
		return _userUUIDStore.add(userUUID);
	}

	@Override
	public boolean unregister(String userUUID) {
		return _userUUIDStore.remove(userUUID);
	}

	private final Set<String> _userUUIDStore = Collections.newSetFromMap(
		new ConcurrentHashMap<>());

}