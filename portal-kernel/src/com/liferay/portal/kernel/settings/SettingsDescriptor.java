/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.settings;

import java.util.Set;

/**
 * @author Iván Zaera
 */
public interface SettingsDescriptor {

	public Set<String> getAllKeys();

	public Set<String> getMultiValuedKeys();

}