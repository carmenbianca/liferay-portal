/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.vulcan.internal.jaxrs.exception.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.BaseExceptionMapper;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.Problem;

import javax.ws.rs.core.Response;

/**
 * @author Javier Gamarra
 */
public class ExceptionMapper extends BaseExceptionMapper<Exception> {

	@Override
	protected Problem getProblem(Exception exception) {
		_log.error(exception, exception);

		return new Problem(
			Response.Status.INTERNAL_SERVER_ERROR, exception.getMessage());
	}

	private static final Log _log = LogFactoryUtil.getLog(
		ExceptionMapper.class);

}