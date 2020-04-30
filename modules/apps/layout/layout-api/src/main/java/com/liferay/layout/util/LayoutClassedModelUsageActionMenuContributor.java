/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.util;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.layout.model.LayoutClassedModelUsage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public interface LayoutClassedModelUsageActionMenuContributor {

	public List<DropdownItem> getLayoutClassedModelUsageActionDropdownItems(
		HttpServletRequest httpServletRequest,
		LayoutClassedModelUsage layoutClassedModelUsage);

}