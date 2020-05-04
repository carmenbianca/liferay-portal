/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.theme;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.PortletDecorator;
import com.liferay.portal.kernel.theme.PortletDecoratorFactory;
import com.liferay.portal.model.impl.PortletDecoratorImpl;
import com.liferay.portal.util.PropsValues;

/**
 * @author Eduardo García
 */
public class PortletDecoratorFactoryImpl implements PortletDecoratorFactory {

	@Override
	public PortletDecorator getDefaultPortletDecorator() {
		return new PortletDecoratorImpl(
			getDefaultPortletDecoratorId(), StringPool.BLANK,
			getDefaultPortletDecoratorCssClass());
	}

	@Override
	public String getDefaultPortletDecoratorCssClass() {
		return PropsValues.DEFAULT_PORTLET_DECORATOR_CSS_CLASS;
	}

	@Override
	public String getDefaultPortletDecoratorId() {
		return PropsValues.DEFAULT_PORTLET_DECORATOR_ID;
	}

	@Override
	public PortletDecorator getPortletDecorator() {
		return new PortletDecoratorImpl();
	}

	@Override
	public PortletDecorator getPortletDecorator(String portletDecoratorId) {
		return new PortletDecoratorImpl(portletDecoratorId);
	}

	@Override
	public PortletDecorator getPortletDecorator(
		String portletDecoratorId, String name, String cssClass) {

		return new PortletDecoratorImpl(portletDecoratorId, name, cssClass);
	}

}