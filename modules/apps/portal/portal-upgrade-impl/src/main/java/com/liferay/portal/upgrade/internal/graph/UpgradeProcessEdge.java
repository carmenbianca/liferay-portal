/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.internal.graph;

import com.liferay.portal.upgrade.internal.registry.UpgradeInfo;

import org.jgrapht.graph.DefaultEdge;

/**
 * @author Miguel Pastor
 * @author Carlos Sierra Andrés
 */
public class UpgradeProcessEdge extends DefaultEdge {

	public UpgradeProcessEdge(UpgradeInfo upgradeInfo) {
		_upgradeInfo = upgradeInfo;
	}

	public UpgradeInfo getUpgradeInfo() {
		return _upgradeInfo;
	}

	private final UpgradeInfo _upgradeInfo;

}