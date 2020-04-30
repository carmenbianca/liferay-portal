/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.registry.dependency;

import com.liferay.registry.Filter;
import com.liferay.registry.ServiceReference;

/**
 * @author Michael C. Han
 */
public class FilterServiceDependencyVerifier
	implements ServiceDependencyVerifier {

	public FilterServiceDependencyVerifier(Filter filter) {
		_filter = filter;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if ((object == null) || (getClass() != object.getClass())) {
			return false;
		}

		return _filter.equals(object);
	}

	@Override
	public int hashCode() {
		return _filter.hashCode();
	}

	@Override
	public String toString() {
		return _filter.toString();
	}

	@Override
	public boolean verify(ServiceReference<?> serviceReference) {
		return _filter.matches(serviceReference);
	}

	private final Filter _filter;

}