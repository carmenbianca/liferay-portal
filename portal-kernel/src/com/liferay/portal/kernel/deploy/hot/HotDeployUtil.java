/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.deploy.hot;

import com.liferay.portal.kernel.util.PortalLifecycle;

/**
 * @author Ivica Cardic
 * @author Brian Wing Shun Chan
 * @author Raymond Augé
 */
public class HotDeployUtil {

	public static void fireDeployEvent(HotDeployEvent hotDeployEvent) {
		getHotDeploy().fireDeployEvent(hotDeployEvent);
	}

	public static void fireUndeployEvent(HotDeployEvent hotDeployEvent) {
		getHotDeploy().fireUndeployEvent(hotDeployEvent);
	}

	public static HotDeploy getHotDeploy() {
		return _hotDeploy;
	}

	public static boolean registerDependentPortalLifecycle(
		String servletContextName, PortalLifecycle portalLifecycle) {

		return getHotDeploy().registerDependentPortalLifecycle(
			servletContextName, portalLifecycle);
	}

	public static void registerListener(HotDeployListener hotDeployListener) {
		getHotDeploy().registerListener(hotDeployListener);
	}

	public static void reset() {
		getHotDeploy().reset();
	}

	public static void setCapturePrematureEvents(
		boolean capturePrematureEvents) {

		getHotDeploy().setCapturePrematureEvents(capturePrematureEvents);
	}

	public static void unregisterListener(HotDeployListener hotDeployListener) {
		getHotDeploy().unregisterListener(hotDeployListener);
	}

	public static void unregisterListeners() {
		getHotDeploy().unregisterListeners();
	}

	public void setHotDeploy(HotDeploy hotDeploy) {
		_hotDeploy = hotDeploy;
	}

	private static HotDeploy _hotDeploy;

}