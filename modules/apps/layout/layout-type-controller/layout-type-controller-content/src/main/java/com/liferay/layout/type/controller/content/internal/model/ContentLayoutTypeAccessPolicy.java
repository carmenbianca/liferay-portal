/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.type.controller.content.internal.model;

import com.liferay.layout.type.controller.model.BaseLayoutTypeAccessPolicy;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.model.LayoutTypeAccessPolicy;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jürgen Kappler
 */
@Component(
	immediate = true, property = "layout.type=" + LayoutConstants.TYPE_CONTENT,
	service = LayoutTypeAccessPolicy.class
)
public class ContentLayoutTypeAccessPolicy extends BaseLayoutTypeAccessPolicy {
}