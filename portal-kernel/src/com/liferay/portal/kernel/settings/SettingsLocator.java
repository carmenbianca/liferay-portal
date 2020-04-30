/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.settings;

/**
 * @author Iván Zaera
 * @author Jorge Ferrer
 */
public interface SettingsLocator {

	public Settings getSettings() throws SettingsException;

	public String getSettingsId();

}