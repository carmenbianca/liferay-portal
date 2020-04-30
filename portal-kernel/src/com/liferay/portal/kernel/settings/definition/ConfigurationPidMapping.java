/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.settings.definition;

/**
 * @author Iván Zaera
 */
public interface ConfigurationPidMapping {

	public Class<?> getConfigurationBeanClass();

	public String getConfigurationPid();

}