/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.orm;

/**
 * @author Brian Wing Shun Chan
 */
public enum LockMode {

	FORCE, NONE, OPTIMISTIC, OPTIMISTIC_FORCE_INCREMENT,
	PESSIMISTIC_FORCE_INCREMENT, PESSIMISTIC_READ, PESSIMISTIC_WRITE, READ,
	UPGRADE, UPGRADE_NOWAIT, WRITE

}