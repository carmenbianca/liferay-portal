/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.headless.delivery.internal.jaxrs.exception.mapper;

import com.liferay.document.library.kernel.exception.SourceFileNameException;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.BaseExceptionMapper;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.Problem;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.osgi.service.component.annotations.Component;

/**
 * Converts any {@code SourceFileNameException} to a {@code 400} error.
 *
 * @author Alejandro Hernández
 */
@Component(
	property = {
		"osgi.jaxrs.application.select=(osgi.jaxrs.name=Liferay.Headless.Delivery)",
		"osgi.jaxrs.extension=true",
		"osgi.jaxrs.name=Liferay.Headless.Delivery.DocumentSourceFileNameExceptionMapper"
	},
	service = ExceptionMapper.class
)
public class DocumentSourceFileNameExceptionMapper
	extends BaseExceptionMapper<SourceFileNameException> {

	@Override
	protected Problem getProblem(
		SourceFileNameException sourceFileNameException) {

		return new Problem(
			Response.Status.BAD_REQUEST, sourceFileNameException.getMessage());
	}

}