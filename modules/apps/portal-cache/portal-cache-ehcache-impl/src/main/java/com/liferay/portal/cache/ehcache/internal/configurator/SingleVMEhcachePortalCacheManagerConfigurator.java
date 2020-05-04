/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.cache.ehcache.internal.configurator;

import com.liferay.portal.kernel.util.Props;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Dante Wang
 */
@Component(
	immediate = true,
	service = SingleVMEhcachePortalCacheManagerConfigurator.class
)
public class SingleVMEhcachePortalCacheManagerConfigurator
	extends BaseEhcachePortalCacheManagerConfigurator {

	@Reference(unbind = "-")
	protected void setProps(Props props) {
		this.props = props;
	}

}