/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.model;

import java.io.Serializable;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public interface MBTreeWalker extends Serializable {

	public List<MBMessage> getChildren(MBMessage message);

	public int[] getChildrenRange(MBMessage message);

	public List<MBMessage> getMessages();

	public MBMessage getRoot();

	public boolean isLeaf(MBMessage message);

	public boolean isOdd();

}