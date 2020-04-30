/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.display.context;

import com.liferay.wiki.model.WikiNode;

/**
 * @author Roberto Díaz
 */
public interface WikiNodeInfoPanelDisplayContext extends WikiDisplayContext {

	public WikiNode getFirstNode();

	public int getNodesCount();

	public int getSelectedNodesCount();

	public boolean isMultipleNodeSelection();

	public boolean isSingleNodeSelection();

}