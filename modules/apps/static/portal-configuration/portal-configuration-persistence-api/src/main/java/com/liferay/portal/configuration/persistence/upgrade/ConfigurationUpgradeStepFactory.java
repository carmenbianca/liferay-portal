/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.configuration.persistence.upgrade;

import com.liferay.portal.kernel.upgrade.UpgradeStep;

/**
 * @author Preston Crary
 */
public interface ConfigurationUpgradeStepFactory {

	public UpgradeStep createUpgradeStep(String oldPid, String newPid);

}