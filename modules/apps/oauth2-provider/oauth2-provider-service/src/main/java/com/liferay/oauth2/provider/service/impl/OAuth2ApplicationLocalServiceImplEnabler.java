/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.oauth2.provider.service.impl;

import com.liferay.document.library.kernel.store.Store;
import com.liferay.osgi.util.ComponentUtil;
import com.liferay.portal.change.tracking.store.CTStoreFactory;
import com.liferay.portal.util.PropsValues;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Shuyang Zhou
 */
@Component(immediate = true, service = {})
public class OAuth2ApplicationLocalServiceImplEnabler {

	@Activate
	protected void activate(ComponentContext componentContext) {
		ComponentUtil.enableComponents(
			Store.class, "(store.type=" + PropsValues.DL_STORE_IMPL + ")",
			componentContext, OAuth2ApplicationLocalServiceImpl.class);
	}

	@Reference
	private CTStoreFactory _ctStoreFactory;

}