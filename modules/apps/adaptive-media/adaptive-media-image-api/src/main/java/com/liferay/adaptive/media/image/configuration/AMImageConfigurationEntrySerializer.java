/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.image.configuration;

/**
 * @author Adolfo Pérez
 */
public interface AMImageConfigurationEntrySerializer {

	public AMImageConfigurationEntry deserialize(String s);

	public String serialize(
		AMImageConfigurationEntry amImageConfigurationEntry);

}