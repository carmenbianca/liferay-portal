/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model;

import com.liferay.portal.kernel.xml.QName;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 */
public interface PublicRenderParameter extends Serializable {

	public String getIdentifier();

	public PortletApp getPortletApp();

	public QName getQName();

	public void setIdentifier(String identifier);

	public void setPortletApp(PortletApp portletApp);

	public void setQName(QName qName);

}