/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.cluster;

import java.io.Serializable;

/**
 * @author Shuyang Zhou
 */
public interface Address extends Serializable {

	public String getDescription();

	public Object getRealAddress();

}