/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bean.portlet.cdi.extension.internal;

import javax.xml.namespace.QName;

/**
 * @author Neil Griffin
 */
public class PublicRenderParameterImpl implements PublicRenderParameter {

	public PublicRenderParameterImpl(String identifier, QName qName) {
		_identifier = identifier;
		_qName = qName;
	}

	@Override
	public String getIdentifier() {
		return _identifier;
	}

	@Override
	public QName getQName() {
		return _qName;
	}

	private final String _identifier;
	private final QName _qName;

}