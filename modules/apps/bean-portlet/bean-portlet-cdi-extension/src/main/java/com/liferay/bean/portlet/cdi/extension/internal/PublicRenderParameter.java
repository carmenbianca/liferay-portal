/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bean.portlet.cdi.extension.internal;

import javax.xml.namespace.QName;

/**
 * @author Neil Griffin
 */
public interface PublicRenderParameter {

	public String getIdentifier();

	public QName getQName();

}