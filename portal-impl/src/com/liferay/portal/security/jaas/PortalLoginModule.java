/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.jaas;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.ServerDetector;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PropsValues;

import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

/**
 * @author Brian Wing Shun Chan
 */
public class PortalLoginModule implements LoginModule {

	public PortalLoginModule() {
		LoginModule loginModule = null;

		if (Validator.isNotNull(PropsValues.PORTAL_JAAS_IMPL)) {
			try {
				loginModule = (LoginModule)InstanceFactory.newInstance(
					PropsValues.PORTAL_JAAS_IMPL);
			}
			catch (Exception exception) {
				_log.error(exception, exception);
			}
		}

		if (loginModule == null) {
			if (ServerDetector.isJBoss()) {
				loginModule =
					new com.liferay.portal.security.jaas.ext.jboss.
						PortalLoginModule();
			}
			else if (ServerDetector.isTomcat()) {
				loginModule =
					new com.liferay.portal.security.jaas.ext.tomcat.
						PortalLoginModule();
			}
			else if (ServerDetector.isWebLogic()) {
				loginModule =
					new com.liferay.portal.security.jaas.ext.weblogic.
						PortalLoginModule();
			}
		}

		if (_log.isDebugEnabled()) {
			Class<?> clazz = loginModule.getClass();

			_log.debug(clazz.getName());
		}

		_loginModule = loginModule;
	}

	@Override
	public boolean abort() throws LoginException {
		return _loginModule.abort();
	}

	@Override
	public boolean commit() throws LoginException {
		return _loginModule.commit();
	}

	@Override
	public void initialize(
		Subject subject, CallbackHandler callbackHandler,
		Map<String, ?> sharedState, Map<String, ?> options) {

		_loginModule.initialize(subject, callbackHandler, sharedState, options);
	}

	@Override
	public boolean login() throws LoginException {
		return _loginModule.login();
	}

	@Override
	public boolean logout() throws LoginException {
		return _loginModule.logout();
	}

	private static final Log _log = LogFactoryUtil.getLog(
		PortalLoginModule.class);

	private final LoginModule _loginModule;

}