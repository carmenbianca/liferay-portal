/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.layoutsadmin.util;

import com.liferay.portal.kernel.model.LayoutSetBranch;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Akos Thurzo
 */
public interface LayoutsTree {

	public String getLayoutsJSON(
			HttpServletRequest httpServletRequest, long groupId,
			boolean privateLayout, long parentLayoutId, boolean incomplete,
			String treeId)
		throws Exception;

	public String getLayoutsJSON(
			HttpServletRequest httpServletRequest, long groupId,
			boolean privateLayout, long parentLayoutId, boolean incomplete,
			String treeId, LayoutSetBranch layoutSetBranch)
		throws Exception;

	public String getLayoutsJSON(
			HttpServletRequest httpServletRequest, long groupId,
			boolean privateLayout, long layoutId, int max)
		throws Exception;

	public String getLayoutsJSON(
			HttpServletRequest httpServletRequest, long groupId,
			boolean privateLayout, long layoutId, int max,
			LayoutSetBranch layoutSetBranch)
		throws Exception;

	public String getLayoutsJSON(
			HttpServletRequest httpServletRequest, long groupId,
			boolean privateLayout, long parentLayoutId,
			long[] expandedLayoutIds, boolean incomplete, String treeId)
		throws Exception;

	public String getLayoutsJSON(
			HttpServletRequest httpServletRequest, long groupId,
			boolean privateLayout, long parentLayoutId,
			long[] expandedLayoutIds, boolean incomplete, String treeId,
			LayoutSetBranch layoutSetBranch)
		throws Exception;

	public String getLayoutsJSON(
			HttpServletRequest httpServletRequest, long groupId, String treeId)
		throws Exception;

	public String getLayoutsJSON(
			HttpServletRequest httpServletRequest, long groupId, String treeId,
			LayoutSetBranch layoutSetBranch)
		throws Exception;

}