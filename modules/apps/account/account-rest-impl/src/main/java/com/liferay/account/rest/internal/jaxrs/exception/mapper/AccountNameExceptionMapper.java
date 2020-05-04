/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.rest.internal.jaxrs.exception.mapper;

import com.liferay.account.exception.AccountEntryNameException;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.BaseExceptionMapper;
import com.liferay.portal.vulcan.jaxrs.exception.mapper.Problem;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.osgi.service.component.annotations.Component;

/**
 * @author Drew Brokke
 */
@Component(
	property = {
		"osgi.jaxrs.application.select=(osgi.jaxrs.name=Liferay.Account.REST)",
		"osgi.jaxrs.extension=true",
		"osgi.jaxrs.name=Liferay.Account.REST.AccountNameExceptionMapper"
	},
	service = ExceptionMapper.class
)
public class AccountNameExceptionMapper
	extends BaseExceptionMapper<AccountEntryNameException> {

	@Override
	protected Problem getProblem(
		AccountEntryNameException accountEntryNameException) {

		return new Problem(
			Response.Status.BAD_REQUEST,
			accountEntryNameException.getMessage());
	}

}