/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.management;

import java.io.Serializable;

/**
 * @author Shuyang Zhou
 */
public interface ManageAction<T> extends Serializable {

	public T action() throws ManageActionException;

}