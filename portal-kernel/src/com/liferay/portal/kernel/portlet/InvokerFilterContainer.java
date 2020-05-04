/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.portlet;

import java.util.List;

import javax.portlet.filter.ActionFilter;
import javax.portlet.filter.EventFilter;
import javax.portlet.filter.HeaderFilter;
import javax.portlet.filter.RenderFilter;
import javax.portlet.filter.ResourceFilter;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Raymond Augé
 * @author Neil Griffin
 */
@ProviderType
public interface InvokerFilterContainer {

	public List<ActionFilter> getActionFilters();

	public List<EventFilter> getEventFilters();

	public List<HeaderFilter> getHeaderFilters();

	public List<RenderFilter> getRenderFilters();

	public List<ResourceFilter> getResourceFilters();

}