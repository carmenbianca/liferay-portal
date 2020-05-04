/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.template;

import com.liferay.portal.kernel.cache.PortalCache;

/**
 * @author Tina Tian
 */
public interface TemplateResourceCache {

	public void clear();

	public TemplateResource getTemplateResource(String templateId);

	public boolean isEnabled();

	public void put(String templateId, TemplateResource templateResource);

	public void remove(String templateId);

	public void setSecondLevelPortalCache(
		PortalCache<TemplateResource, ?> portalCache);

}