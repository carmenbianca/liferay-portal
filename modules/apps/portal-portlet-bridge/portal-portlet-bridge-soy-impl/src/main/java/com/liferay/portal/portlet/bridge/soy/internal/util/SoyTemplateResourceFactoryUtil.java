/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.portlet.bridge.soy.internal.util;

import com.liferay.portal.kernel.template.TemplateResource;
import com.liferay.portal.template.soy.SoyTemplateResource;
import com.liferay.portal.template.soy.SoyTemplateResourceFactory;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Tina Tian
 */
@Component(immediate = true, service = {})
public class SoyTemplateResourceFactoryUtil {

	public static SoyTemplateResource createSoyTemplateResource(
		List<TemplateResource> templateResources) {

		return _soyTemplateResourceFactory.createSoyTemplateResource(
			templateResources);
	}

	@Reference(unbind = "-")
	protected void setSoyTemplateResourceFactory(
		SoyTemplateResourceFactory soyTemplateResourceFactory) {

		_soyTemplateResourceFactory = soyTemplateResourceFactory;
	}

	private static SoyTemplateResourceFactory _soyTemplateResourceFactory;

}