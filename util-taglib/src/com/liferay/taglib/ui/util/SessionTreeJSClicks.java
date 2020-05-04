/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.taglib.ui.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Brian Wing Shun Chan
 * @author Eduardo Lundgren
 */
public class SessionTreeJSClicks {

	public static void closeLayoutNodes(
		HttpServletRequest httpServletRequest, String treeId,
		boolean privateLayout, long layoutId, boolean recursive) {

		try {
			List<String> layoutIds = new ArrayList<>();

			layoutIds.add(String.valueOf(layoutId));

			if (recursive) {
				getLayoutIds(
					httpServletRequest, privateLayout, layoutId, layoutIds);
			}

			closeNodes(
				httpServletRequest, treeId, layoutIds.toArray(new String[0]));
		}
		catch (Exception exception) {
			_log.error(exception, exception);
		}
	}

	public static void closeNode(
		HttpServletRequest httpServletRequest, String treeId, String nodeId) {

		while (true) {
			try {
				PortalPreferences portalPreferences =
					PortletPreferencesFactoryUtil.getPortalPreferences(
						httpServletRequest);

				String openNodesString = portalPreferences.getValue(
					SessionTreeJSClicks.class.getName(), treeId);

				openNodesString = StringUtil.removeFromList(
					openNodesString, nodeId);

				portalPreferences.setValue(
					SessionTreeJSClicks.class.getName(), treeId,
					openNodesString);

				return;
			}
			catch (ConcurrentModificationException
						concurrentModificationException) {
			}
			catch (Exception exception) {
				_log.error(exception, exception);

				return;
			}
		}
	}

	public static void closeNodes(
		HttpServletRequest httpServletRequest, String treeId) {

		while (true) {
			try {
				PortalPreferences portalPreferences =
					PortletPreferencesFactoryUtil.getPortalPreferences(
						httpServletRequest);

				portalPreferences.setValue(
					SessionTreeJSClicks.class.getName(), treeId,
					StringPool.BLANK);

				return;
			}
			catch (ConcurrentModificationException
						concurrentModificationException) {
			}
			catch (Exception exception) {
				_log.error(exception, exception);

				return;
			}
		}
	}

	public static void closeNodes(
		HttpServletRequest httpServletRequest, String treeId,
		String[] nodeIds) {

		while (true) {
			try {
				PortalPreferences portalPreferences =
					PortletPreferencesFactoryUtil.getPortalPreferences(
						httpServletRequest);

				String openNodesString = portalPreferences.getValue(
					SessionTreeJSClicks.class.getName(), treeId);

				for (String nodeId : nodeIds) {
					openNodesString = StringUtil.removeFromList(
						openNodesString, nodeId);
				}

				portalPreferences.setValue(
					SessionTreeJSClicks.class.getName(), treeId,
					openNodesString);

				return;
			}
			catch (ConcurrentModificationException
						concurrentModificationException) {
			}
			catch (Exception exception) {
				_log.error(exception, exception);

				return;
			}
		}
	}

	public static String getOpenNodes(
		HttpServletRequest httpServletRequest, String treeId) {

		try {
			PortalPreferences portalPreferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(
					httpServletRequest);

			return portalPreferences.getValue(
				SessionTreeJSClicks.class.getName(), treeId);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			return null;
		}
	}

	public static void openLayoutNodes(
		HttpServletRequest httpServletRequest, String treeId,
		boolean privateLayout, long layoutId, boolean recursive) {

		try {
			List<String> layoutIds = new ArrayList<>();

			layoutIds.add(String.valueOf(layoutId));

			if (recursive) {
				getLayoutIds(
					httpServletRequest, privateLayout, layoutId, layoutIds);
			}

			openNodes(
				httpServletRequest, treeId, layoutIds.toArray(new String[0]));
		}
		catch (Exception exception) {
			_log.error(exception, exception);
		}
	}

	public static void openNode(
		HttpServletRequest httpServletRequest, String treeId, String nodeId) {

		while (true) {
			try {
				PortalPreferences portalPreferences =
					PortletPreferencesFactoryUtil.getPortalPreferences(
						httpServletRequest);

				String openNodesString = portalPreferences.getValue(
					SessionTreeJSClicks.class.getName(), treeId);

				openNodesString = StringUtil.add(openNodesString, nodeId);

				portalPreferences.setValue(
					SessionTreeJSClicks.class.getName(), treeId,
					openNodesString);

				return;
			}
			catch (ConcurrentModificationException
						concurrentModificationException) {
			}
			catch (Exception exception) {
				_log.error(exception, exception);

				return;
			}
		}
	}

	public static void openNodes(
		HttpServletRequest httpServletRequest, String treeId,
		String[] nodeIds) {

		while (true) {
			try {
				PortalPreferences portalPreferences =
					PortletPreferencesFactoryUtil.getPortalPreferences(
						httpServletRequest);

				String openNodesString = portalPreferences.getValue(
					SessionTreeJSClicks.class.getName(), treeId);

				for (String nodeId : nodeIds) {
					openNodesString = StringUtil.add(openNodesString, nodeId);
				}

				portalPreferences.setValue(
					SessionTreeJSClicks.class.getName(), treeId,
					openNodesString);

				return;
			}
			catch (ConcurrentModificationException
						concurrentModificationException) {
			}
			catch (Exception exception) {
				_log.error(exception, exception);

				return;
			}
		}
	}

	protected static List<String> getLayoutIds(
			HttpServletRequest httpServletRequest, boolean privateLayout,
			long parentLayoutId, List<String> layoutIds)
		throws Exception {

		long groupId = ParamUtil.getLong(httpServletRequest, "groupId");

		List<Layout> layouts = LayoutLocalServiceUtil.getLayouts(
			groupId, privateLayout, parentLayoutId);

		for (Layout layout : layouts) {
			layoutIds.add(String.valueOf(layout.getLayoutId()));

			getLayoutIds(
				httpServletRequest, privateLayout, layout.getLayoutId(),
				layoutIds);
		}

		return layoutIds;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		SessionTreeJSClicks.class);

}