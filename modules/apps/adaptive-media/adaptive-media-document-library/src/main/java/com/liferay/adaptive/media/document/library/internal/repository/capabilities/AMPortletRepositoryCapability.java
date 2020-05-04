/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.document.library.internal.repository.capabilities;

import com.liferay.portal.kernel.repository.capabilities.Capability;

import org.osgi.service.component.annotations.Component;

/**
 * @author Alejandro Tardín
 */
@Component(
	property = "repository.class.name=com.liferay.portal.repository.portletrepository.PortletRepository",
	service = Capability.class
)
public class AMPortletRepositoryCapability extends BaseCapability {
}