/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.document.conversion.internal.security.auth.verifier;

import com.liferay.portal.kernel.security.auth.verifier.AuthVerifier;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.security.auth.AuthVerifierPipeline;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author István András Dézsi
 */
@Component(
	configurationPid = "com.liferay.document.library.document.conversion.internal.security.auth.verifier.image.request.module.configuration.ImageRequestAuthVerifierConfiguration",
	configurationPolicy = ConfigurationPolicy.REQUIRE, service = {}
)
public class ImageRequestAuthVerifierPublisher {

	@Activate
	protected void activate(
		BundleContext bundleContext, Map<String, Object> properties) {

		Boolean enabled = GetterUtil.getBoolean(properties.get("enabled"));

		if ((enabled == null) || !enabled) {
			return;
		}

		AuthVerifier authVerifier = new ImageRequestAuthVerifier();

		Class<?> clazz = authVerifier.getClass();

		String authVerifierPropertyName =
			AuthVerifierPipeline.getAuthVerifierPropertyName(clazz.getName());

		Dictionary<String, Object> authVerifierProperties = new Hashtable<>();

		for (Map.Entry<String, Object> entry : properties.entrySet()) {
			String key = _translate(authVerifierPropertyName, entry.getKey());

			authVerifierProperties.put(key, entry.getValue());
		}

		_authVerifierRegistration = bundleContext.registerService(
			AuthVerifier.class, authVerifier, authVerifierProperties);
	}

	@Deactivate
	protected void deactivate() {
		if (_authVerifierRegistration != null) {
			_authVerifierRegistration.unregister();

			_authVerifierRegistration = null;
		}
	}

	private String _translate(String authVerifierPropertyName, String key) {
		if (key.equals("hostsAllowed")) {
			key = "hosts.allowed";
		}
		else if (key.equals("urlsExcludes")) {
			key = "urls.excludes";
		}
		else if (key.equals("urlsIncludes")) {
			key = "urls.includes";
		}

		return authVerifierPropertyName + key;
	}

	private ServiceRegistration<AuthVerifier> _authVerifierRegistration;

}