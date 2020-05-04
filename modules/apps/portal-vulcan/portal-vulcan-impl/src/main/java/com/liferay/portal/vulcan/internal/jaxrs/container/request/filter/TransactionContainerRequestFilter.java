/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.vulcan.internal.jaxrs.container.request.filter;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.spring.transaction.TransactionAttributeAdapter;
import com.liferay.portal.spring.transaction.TransactionAttributeBuilder;
import com.liferay.portal.spring.transaction.TransactionHandler;
import com.liferay.portal.spring.transaction.TransactionStatusAdapter;

import java.io.IOException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 * @author Javier Gamarra
 */
@Provider
@Transactional(rollbackFor = Exception.class)
public class TransactionContainerRequestFilter
	implements ContainerRequestFilter, ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext containerRequestContext)
		throws IOException {

		if (_transactionRequiredMethodNames.contains(
				containerRequestContext.getMethod())) {

			containerRequestContext.setProperty(
				_TRANSACTION_STATUS_ADAPTER,
				_transactionHandler.start(_transactionAttributeAdapter));
		}
	}

	@Override
	public void filter(
			ContainerRequestContext containerRequestContext,
			ContainerResponseContext containerResponseContext)
		throws IOException {

		TransactionStatusAdapter transactionStatusAdapter =
			(TransactionStatusAdapter)containerRequestContext.getProperty(
				_TRANSACTION_STATUS_ADAPTER);

		if (transactionStatusAdapter == null) {
			return;
		}

		Response.Status.Family family = Response.Status.Family.familyOf(
			containerResponseContext.getStatus());

		if (family == Response.Status.Family.SUCCESSFUL) {
			_transactionHandler.commit(
				_transactionAttributeAdapter, transactionStatusAdapter);
		}
		else {
			try {
				_transactionHandler.rollback(
					new Exception(
						StringBundler.concat(
							"Rollback due to ", family, ": ",
							containerResponseContext.getStatus())),
					_transactionAttributeAdapter, transactionStatusAdapter);
			}
			catch (Throwable throwable) {
				if (_log.isDebugEnabled()) {
					_log.debug("Unable to rollback the transaction", throwable);
				}
			}
		}
	}

	private static final String _TRANSACTION_STATUS_ADAPTER =
		TransactionContainerRequestFilter.class.getName() +
			"#TRANSACTION_STATUS_ADAPTER";

	private static final Log _log = LogFactoryUtil.getLog(
		TransactionContainerRequestFilter.class);

	private static final TransactionAttributeAdapter
		_transactionAttributeAdapter = new TransactionAttributeAdapter(
			TransactionAttributeBuilder.build(
				TransactionContainerRequestFilter.class.getAnnotation(
					Transactional.class)));
	private static final TransactionHandler _transactionHandler =
		(TransactionHandler)PortalBeanLocatorUtil.locate("transactionExecutor");
	private static final Set<String> _transactionRequiredMethodNames =
		new HashSet<>(Arrays.asList("DELETE", "PATCH", "POST", "PUT"));

}