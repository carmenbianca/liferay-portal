/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.auth.verifier.internal.basic.auth.header;

import com.liferay.portal.kernel.security.auth.verifier.AuthVerifier;
import com.liferay.portal.kernel.security.auto.login.AutoLogin;
import com.liferay.portal.security.auth.verifier.internal.BaseAuthVerifierPublisher;

import java.util.Map;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Tomas Polesovsky
 */
@Component(
	configurationPid = "com.liferay.portal.security.auth.verifier.internal.basic.auth.header.configuration.BasicAuthHeaderAuthVerifierConfiguration",
	configurationPolicy = ConfigurationPolicy.OPTIONAL, service = {}
)
public class BasicAuthHeaderAuthVerifierPublisher
	extends BaseAuthVerifierPublisher {

	@Activate
	@Override
	protected void activate(
		BundleContext bundleContext, Map<String, Object> properties) {

		_authVerifier = new BasicAuthHeaderAuthVerifier(_autoLogin);

		super.activate(bundleContext, properties);
	}

	@Deactivate
	@Override
	protected void deactivate() {
		super.deactivate();
	}

	@Override
	protected AuthVerifier getAuthVerifierInstance() {
		return _authVerifier;
	}

	@Modified
	@Override
	protected void modified(
		BundleContext bundleContext, Map<String, Object> properties) {

		super.modified(bundleContext, properties);
	}

	@Override
	protected String translateKey(String authVerifierPropertyName, String key) {
		if (key.equals("forceBasicAuth")) {
			key = "basic_auth";
		}

		return super.translateKey(authVerifierPropertyName, key);
	}

	private AuthVerifier _authVerifier;

	@Reference(target = "(&(private.auto.login=true)(type=basic.auth.header))")
	private AutoLogin _autoLogin;

}