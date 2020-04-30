/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.scr.reference.dynamic.greedy.test.internal;

import com.liferay.scr.reference.dynamic.greedy.test.ComponentController;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

/**
 * @author Preston Crary
 */
@Component(immediate = true, service = ComponentController.class)
public class ComponentControllerImpl implements ComponentController {

	@Override
	public void disableComponent(String name) {
		_componentContext.disableComponent(name);
	}

	@Override
	public void enabledComponent(String name) {
		_componentContext.enableComponent(name);
	}

	@Activate
	protected void activate(ComponentContext componentContext) {
		_componentContext = componentContext;
	}

	private ComponentContext _componentContext;

}