/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.memory;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

import java.util.Objects;

/**
 * @author Shuyang Zhou
 */
public class EqualitySoftReference<T> extends SoftReference<T> {

	public EqualitySoftReference(T referent) {
		super(referent);

		_hashCode = referent.hashCode();
	}

	public EqualitySoftReference(
		T referent, ReferenceQueue<? super T> referenceQueue) {

		super(referent, referenceQueue);

		_hashCode = referent.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EqualitySoftReference<?>)) {
			return false;
		}

		EqualitySoftReference<?> equalitySoftReference =
			(EqualitySoftReference<?>)obj;

		if (Objects.equals(get(), equalitySoftReference.get())) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return _hashCode;
	}

	private final int _hashCode;

}