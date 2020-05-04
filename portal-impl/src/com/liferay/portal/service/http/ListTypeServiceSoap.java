/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ListTypeServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>ListTypeServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.liferay.portal.kernel.model.ListTypeSoap</code>. If the method in the
 * service utility returns a
 * <code>com.liferay.portal.kernel.model.ListType</code>, that is translated to a
 * <code>com.liferay.portal.kernel.model.ListTypeSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ListTypeServiceHttp
 * @generated
 */
public class ListTypeServiceSoap {

	public static com.liferay.portal.kernel.model.ListTypeSoap getListType(
			long listTypeId)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.model.ListType returnValue =
				ListTypeServiceUtil.getListType(listTypeId);

			return com.liferay.portal.kernel.model.ListTypeSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.portal.kernel.model.ListTypeSoap getListType(
			String name, String type)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.model.ListType returnValue =
				ListTypeServiceUtil.getListType(name, type);

			return com.liferay.portal.kernel.model.ListTypeSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.portal.kernel.model.ListTypeSoap[] getListTypes(
			String type)
		throws RemoteException {

		try {
			java.util.List<com.liferay.portal.kernel.model.ListType>
				returnValue = ListTypeServiceUtil.getListTypes(type);

			return com.liferay.portal.kernel.model.ListTypeSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static void validate(long listTypeId, long classNameId, String type)
		throws RemoteException {

		try {
			ListTypeServiceUtil.validate(listTypeId, classNameId, type);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static void validate(long listTypeId, String type)
		throws RemoteException {

		try {
			ListTypeServiceUtil.validate(listTypeId, type);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ListTypeServiceSoap.class);

}