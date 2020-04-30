/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.seo.service.impl;

import com.liferay.layout.seo.service.base.LayoutSEOSiteServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=layoutseo",
		"json.web.service.context.path=LayoutSEOSite"
	},
	service = AopService.class
)
public class LayoutSEOSiteServiceImpl extends LayoutSEOSiteServiceBaseImpl {
}