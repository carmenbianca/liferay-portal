/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.configuration.admin.web.internal.util;

import com.liferay.configuration.admin.display.ConfigurationFormRenderer;

/**
 * @author Jorge Ferrer
 */
public interface ConfigurationFormRendererRetriever {

	public ConfigurationFormRenderer getConfigurationFormRenderer(String pid);

}