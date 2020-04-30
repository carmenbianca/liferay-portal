/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.settings;

/**
 * @author André de Oliveira
 */
public interface SettingsContributor extends Comparable<SettingsContributor> {

	public int getPriority();

	public void populate(ClientSettingsHelper clientSettingsHelper);

}