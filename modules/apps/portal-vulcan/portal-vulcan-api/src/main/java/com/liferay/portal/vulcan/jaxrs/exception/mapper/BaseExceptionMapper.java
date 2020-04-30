/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.vulcan.jaxrs.exception.mapper;

import java.util.List;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Base class that returns objects that follow the Problem+JSON specification
 *
 * @author Javier Gamarra
 * @review
 */
public abstract class BaseExceptionMapper<T extends Throwable>
	implements ExceptionMapper<T> {

	@Override
	public Response toResponse(T exception) {
		Problem problem = getProblem(exception);

		return Response.status(
			problem.getStatus()
		).entity(
			problem
		).type(
			getMediaType()
		).build();
	}

	protected MediaType getMediaType() {
		List<MediaType> mediaTypes = httpHeaders.getAcceptableMediaTypes();

		MediaType mediaType = mediaTypes.get(0);

		if (mediaType.equals(MediaType.valueOf(MediaType.TEXT_HTML)) ||
			mediaType.equals(MediaType.valueOf(MediaType.WILDCARD))) {

			return MediaType.valueOf(MediaType.APPLICATION_JSON);
		}

		return mediaType;
	}

	protected abstract Problem getProblem(T exception);

	@Context
	protected HttpHeaders httpHeaders;

}