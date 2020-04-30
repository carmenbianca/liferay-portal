/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.nio.intraband.proxy;

import java.io.Serializable;

/**
 * @author Shuyang Zhou
 */
public interface TargetLocator extends Serializable {

	public Object getTarget(String id);

}