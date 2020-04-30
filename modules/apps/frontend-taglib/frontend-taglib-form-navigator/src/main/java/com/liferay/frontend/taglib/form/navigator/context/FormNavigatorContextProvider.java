/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.form.navigator.context;

/**
 * @author Alejandro Tardín
 */
public interface FormNavigatorContextProvider<T> {

	public String getContext(T formModelBean);

}