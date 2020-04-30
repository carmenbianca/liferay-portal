/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.registry.dependency;

import com.liferay.registry.ServiceReference;

/**
 * @author Michael C. Han
 */
public interface ServiceDependencyVerifier {

	public boolean verify(ServiceReference<?> serviceReference);

}