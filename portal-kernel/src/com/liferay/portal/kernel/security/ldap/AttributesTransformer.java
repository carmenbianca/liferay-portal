/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.ldap;

import javax.naming.directory.Attributes;

/**
 * @author Brian Wing Shun Chan
 */
public interface AttributesTransformer {

	public Attributes transformGroup(Attributes attributes);

	public Attributes transformUser(Attributes attributes);

}