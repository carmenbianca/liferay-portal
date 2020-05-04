/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.app.builder.rest.internal.jaxrs.exception.mapper;

import com.liferay.dynamic.data.mapping.exception.NoSuchStructureLayoutException;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.BaseExceptionMapper;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.Problem;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gabriel Albuquerque
 */
@Component(
	property = {
		"osgi.jaxrs.application.select=(osgi.jaxrs.name=Liferay.App.Builder.REST)",
		"osgi.jaxrs.extension=true",
		"osgi.jaxrs.name=Liferay.App.Builder.REST.NoSuchDataLayoutExceptionMapper"
	},
	service = ExceptionMapper.class
)
public class NoSuchDataLayoutExceptionMapper
	extends BaseExceptionMapper<NoSuchStructureLayoutException> {

	@Override
	protected Problem getProblem(
		NoSuchStructureLayoutException noSuchStructureLayoutException) {

		return new Problem(
			Response.Status.NOT_FOUND,
			StringUtil.replace(
				noSuchStructureLayoutException.getMessage(),
				"Dynamic data mapping structure layout", "Data layout"));
	}

}