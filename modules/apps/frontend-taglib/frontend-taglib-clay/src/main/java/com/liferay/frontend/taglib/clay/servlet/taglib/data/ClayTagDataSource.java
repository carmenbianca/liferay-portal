/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.clay.servlet.taglib.data;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Rodolfo Roza Miranda
 */
public interface ClayTagDataSource<T> {

	public List<T> getItems(HttpServletRequest httpServletRequest);

}