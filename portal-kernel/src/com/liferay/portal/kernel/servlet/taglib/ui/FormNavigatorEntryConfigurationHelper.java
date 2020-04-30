/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.servlet.taglib.ui;

import java.util.List;
import java.util.Optional;

/**
 * @author Alejandro Tardín
 */
public interface FormNavigatorEntryConfigurationHelper {

	public <T> Optional<List<FormNavigatorEntry<T>>> getFormNavigatorEntries(
		String formNavigatorId, String categoryKey, T formModelBean);

}