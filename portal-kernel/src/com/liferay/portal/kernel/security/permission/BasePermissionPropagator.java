/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.permission;

/**
 * @author     Hugo Huijser
 * @deprecated As of Mueller (7.2.x), replaced by {@link
 *             com.liferay.portal.kernel.security.permission.propagator.BasePermissionPropagator}
 */
@Deprecated
public abstract class BasePermissionPropagator
	extends com.liferay.portal.kernel.security.permission.propagator.
				BasePermissionPropagator implements PermissionPropagator {
}