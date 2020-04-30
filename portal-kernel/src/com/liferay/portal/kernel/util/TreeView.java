/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jorge Ferrer
 */
public class TreeView implements Serializable {

	public TreeView() {
		this(new ArrayList<TreeNodeView>(), 0);
	}

	public TreeView(List<TreeNodeView> list, int depth) {
		_list = list;
		_depth = depth;
	}

	public int getDepth() {
		return _depth;
	}

	public List<TreeNodeView> getList() {
		return _list;
	}

	private final int _depth;
	private final List<TreeNodeView> _list;

}