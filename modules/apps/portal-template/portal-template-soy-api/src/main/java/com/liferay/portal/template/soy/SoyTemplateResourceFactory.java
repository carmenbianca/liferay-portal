/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.template.soy;

import com.liferay.portal.kernel.template.TemplateResource;

import java.util.List;

/**
 * @author Tina Tian
 */
public interface SoyTemplateResourceFactory {

	public SoyTemplateResource createSoyTemplateResource(
		List<TemplateResource> templateResources);

}