/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.remote.jaxrs.security.internal.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Carlos Sierra Andrés
 */
@XmlRootElement(name = "Forbidden")
public class ForbiddenEntity {

	public ForbiddenEntity() {
	}

	public ForbiddenEntity(Exception exception) {
		_exception = exception;
	}

	@XmlElement
	public String getMessage() {
		return _exception.getMessage();
	}

	private Exception _exception;

}