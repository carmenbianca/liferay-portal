/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.registry.internal;

import com.liferay.registry.Registry;
import com.liferay.registry.RegistryUtil;

/**
 * @author Raymond Augé
 */
public interface InterfaceTwo {

	public static Registry registry = RegistryUtil.getRegistry();

}