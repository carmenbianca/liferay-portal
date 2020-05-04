/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.ldap.internal.model.listener;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.ldap.LDAPSettings;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.transaction.TransactionCommitCallbackUtil;
import com.liferay.portal.security.exportimport.UserExporter;
import com.liferay.portal.security.ldap.internal.UserImportTransactionThreadLocal;

import java.util.concurrent.Callable;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * @author Scott Lee
 * @author Brian Wing Shun Chan
 * @author Raymond Augé
 */
@Component(immediate = true, service = ModelListener.class)
public class ContactModelListener extends BaseLDAPExportModelListener<Contact> {

	@Override
	public void onAfterCreate(Contact contact) throws ModelListenerException {
		try {
			exportToLDAP(contact);
		}
		catch (Exception exception) {
			throw new ModelListenerException(
				"Unable to export contact with user ID " + contact.getUserId() +
					" to LDAP on after create",
				exception);
		}
	}

	@Override
	public void onAfterUpdate(Contact contact) throws ModelListenerException {
		try {
			exportToLDAP(contact);
		}
		catch (Exception exception) {
			throw new ModelListenerException(
				"Unable to export contact with user ID " + contact.getUserId() +
					" to LDAP on after update",
				exception);
		}
	}

	protected void exportToLDAP(final Contact contact) {
		if (UserImportTransactionThreadLocal.isOriginatesFromImport()) {
			return;
		}

		User user = _userLocalService.fetchUser(contact.getUserId());

		if ((user == null) || user.isDefaultUser()) {
			return;
		}

		Callable<Void> callable = CallableUtil.getCallable(
			expandoBridgeAttributes -> {
				try {
					_userExporter.exportUser(contact, expandoBridgeAttributes);
				}
				catch (Exception exception) {
					_log.error(
						"Unable to export contact with user ID " +
							contact.getUserId() + " to LDAP on after create",
						exception);
				}
			});

		TransactionCommitCallbackUtil.registerCallback(callable);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		ContactModelListener.class);

	@Reference(
		policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY
	)
	private volatile LDAPSettings _ldapSettings;

	@Reference(
		policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY
	)
	private volatile UserExporter _userExporter;

	@Reference
	private UserLocalService _userLocalService;

}