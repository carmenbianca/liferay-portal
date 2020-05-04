/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ContactServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>ContactServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.liferay.portal.kernel.model.ContactSoap</code>. If the method in the
 * service utility returns a
 * <code>com.liferay.portal.kernel.model.Contact</code>, that is translated to a
 * <code>com.liferay.portal.kernel.model.ContactSoap</code>. Methods that SOAP
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
 * @see ContactServiceHttp
 * @generated
 */
public class ContactServiceSoap {

	public static com.liferay.portal.kernel.model.ContactSoap[]
			getCompanyContacts(long companyId, int start, int end)
		throws RemoteException {

		try {
			java.util.List<com.liferay.portal.kernel.model.Contact>
				returnValue = ContactServiceUtil.getCompanyContacts(
					companyId, start, end);

			return com.liferay.portal.kernel.model.ContactSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static int getCompanyContactsCount(long companyId)
		throws RemoteException {

		try {
			int returnValue = ContactServiceUtil.getCompanyContactsCount(
				companyId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.portal.kernel.model.ContactSoap getContact(
			long contactId)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.model.Contact returnValue =
				ContactServiceUtil.getContact(contactId);

			return com.liferay.portal.kernel.model.ContactSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.portal.kernel.model.ContactSoap[] getContacts(
			long classNameId, long classPK, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.portal.kernel.model.Contact> orderByComparator)
		throws RemoteException {

		try {
			java.util.List<com.liferay.portal.kernel.model.Contact>
				returnValue = ContactServiceUtil.getContacts(
					classNameId, classPK, start, end, orderByComparator);

			return com.liferay.portal.kernel.model.ContactSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static int getContactsCount(long classNameId, long classPK)
		throws RemoteException {

		try {
			int returnValue = ContactServiceUtil.getContactsCount(
				classNameId, classPK);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ContactServiceSoap.class);

}