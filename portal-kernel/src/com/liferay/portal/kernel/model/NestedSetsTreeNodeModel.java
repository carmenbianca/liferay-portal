/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model;

/**
 * @author Shuyang Zhou
 */
public interface NestedSetsTreeNodeModel {

	public long getNestedSetsTreeNodeLeft();

	public long getNestedSetsTreeNodeRight();

	public long getNestedSetsTreeNodeScopeId();

	public long getPrimaryKey();

	public void setNestedSetsTreeNodeLeft(long nestedSetsTreeNodeLeft);

	public void setNestedSetsTreeNodeRight(long nestedSetsTreeNodeRight);

}