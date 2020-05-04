/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.screens.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.screens.service.ScreensAssetEntryServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>ScreensAssetEntryServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author José Manuel Navarro
 * @see ScreensAssetEntryServiceSoap
 * @generated
 */
public class ScreensAssetEntryServiceHttp {

	public static com.liferay.portal.kernel.json.JSONArray getAssetEntries(
			HttpPrincipal httpPrincipal,
			com.liferay.asset.kernel.service.persistence.AssetEntryQuery
				assetEntryQuery,
			java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ScreensAssetEntryServiceUtil.class, "getAssetEntries",
				_getAssetEntriesParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, assetEntryQuery, locale);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONArray)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONArray getAssetEntries(
			HttpPrincipal httpPrincipal, long companyId, long groupId,
			String portletItemName, java.util.Locale locale, int max)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ScreensAssetEntryServiceUtil.class, "getAssetEntries",
				_getAssetEntriesParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, companyId, groupId, portletItemName, locale, max);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONArray)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONObject getAssetEntry(
			HttpPrincipal httpPrincipal, long entryId, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ScreensAssetEntryServiceUtil.class, "getAssetEntry",
				_getAssetEntryParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, entryId, locale);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONObject getAssetEntry(
			HttpPrincipal httpPrincipal, String className, long classPK,
			java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ScreensAssetEntryServiceUtil.class, "getAssetEntry",
				_getAssetEntryParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, className, classPK, locale);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		ScreensAssetEntryServiceHttp.class);

	private static final Class<?>[] _getAssetEntriesParameterTypes0 =
		new Class[] {
			com.liferay.asset.kernel.service.persistence.AssetEntryQuery.class,
			java.util.Locale.class
		};
	private static final Class<?>[] _getAssetEntriesParameterTypes1 =
		new Class[] {
			long.class, long.class, String.class, java.util.Locale.class,
			int.class
		};
	private static final Class<?>[] _getAssetEntryParameterTypes2 =
		new Class[] {long.class, java.util.Locale.class};
	private static final Class<?>[] _getAssetEntryParameterTypes3 =
		new Class[] {String.class, long.class, java.util.Locale.class};

}