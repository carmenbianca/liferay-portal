/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model;

import com.liferay.portal.kernel.exception.PortalException;

import java.io.Serializable;

/**
 * @author Shinn Lok
 */
public interface TreeModel {

	public String buildTreePath() throws PortalException;

	public Serializable getPrimaryKeyObj();

	public String getTreePath();

	public void updateTreePath(String treePath);

}