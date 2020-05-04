/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.concurrent;

import java.io.Serializable;

/**
 * @author Shuyang Zhou
 */
public class IdentityKey<K> implements Serializable {

	public IdentityKey(K key) {
		_key = key;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof IdentityKey)) {
			return false;
		}

		IdentityKey<K> identityKey = (IdentityKey<K>)obj;

		if (_key == identityKey._key) {
			return true;
		}

		return false;
	}

	public K getKey() {
		return _key;
	}

	@Override
	public int hashCode() {
		return _key.hashCode();
	}

	private static final long serialVersionUID = 1L;

	private final K _key;

}