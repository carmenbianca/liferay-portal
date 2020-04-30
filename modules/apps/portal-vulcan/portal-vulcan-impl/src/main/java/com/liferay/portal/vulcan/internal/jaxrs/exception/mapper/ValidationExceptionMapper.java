/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.vulcan.internal.jaxrs.exception.mapper;

import com.liferay.portal.vulcan.jaxrs.exception.mapper.BaseExceptionMapper;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.Problem;

import javax.validation.ValidationException;

import javax.ws.rs.core.Response;

/**
 * Converts any {@code ValidationException} to a {@code 400} error.
 *
 * @author Javier Gamarra
 * @review
 */
public class ValidationExceptionMapper
	extends BaseExceptionMapper<ValidationException> {

	@Override
	protected Problem getProblem(ValidationException validationException) {
		return new Problem(
			Response.Status.BAD_REQUEST, validationException.getMessage());
	}

}