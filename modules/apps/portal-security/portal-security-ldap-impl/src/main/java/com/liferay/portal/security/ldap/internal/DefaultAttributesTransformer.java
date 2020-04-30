/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.ldap.internal;

import com.liferay.portal.kernel.security.ldap.AttributesTransformer;

import javax.naming.directory.Attributes;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(immediate = true, service = AttributesTransformer.class)
public class DefaultAttributesTransformer implements AttributesTransformer {

	@Override
	public Attributes transformGroup(Attributes attributes) {
		return attributes;
	}

	@Override
	public Attributes transformUser(Attributes attributes) {
		return attributes;
	}

}