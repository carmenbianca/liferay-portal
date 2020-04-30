/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.spring.configurator;

import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Shuyang Zhou
 */
public interface ConfigurableApplicationContextConfigurator {

	public void configure(
		ConfigurableApplicationContext configurableApplicationContext);

}