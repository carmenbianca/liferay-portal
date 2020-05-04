/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.web.internal.display.context.util;

import com.liferay.portal.kernel.display.context.util.BaseRequestHelper;
import com.liferay.wiki.constants.WikiWebKeys;
import com.liferay.wiki.model.WikiNode;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Adolfo Pérez
 * @author Roberto Díaz
 */
public class WikiNodeInfoPanelRequestHelper extends BaseRequestHelper {

	public WikiNodeInfoPanelRequestHelper(
		HttpServletRequest httpServletRequest) {

		super(httpServletRequest);
	}

	public WikiNode getNode() {
		if (_node != null) {
			return _node;
		}

		HttpServletRequest httpServletRequest = getRequest();

		_node = (WikiNode)httpServletRequest.getAttribute(
			WikiWebKeys.WIKI_NODE);

		return _node;
	}

	public List<WikiNode> getNodes() {
		if (_nodes != null) {
			return _nodes;
		}

		HttpServletRequest httpServletRequest = getRequest();

		_nodes = (List<WikiNode>)httpServletRequest.getAttribute(
			WikiWebKeys.WIKI_NODES);

		if (_nodes == null) {
			_nodes = Collections.emptyList();
		}

		return _nodes;
	}

	private WikiNode _node;
	private List<WikiNode> _nodes;

}