/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.registry.dependency;

/**
 * @author Michael C. Han
 */
public interface ServiceDependencyListener {

	public void dependenciesFulfilled();

	public void destroy();

}