/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model;

/**
 * @author Brian Wing Shun Chan
 */
public interface AttachedModel extends TypedModel {

	public long getClassPK();

	public void setClassPK(long classPK);

}