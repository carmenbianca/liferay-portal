/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.osgi.web.wab.extender.internal;

import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.osgi.web.servlet.JSPServletFactory;
import com.liferay.portal.osgi.web.servlet.JSPTaglibHelper;
import com.liferay.portal.profile.PortalProfile;

import java.io.IOException;
import java.io.InputStream;

import java.net.URL;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.framework.wiring.BundleRevision;

/**
 * @author Raymond Augé
 * @author Miguel Pastor
 */
public class WebBundleDeployer {

	public WebBundleDeployer(
		BundleContext bundleContext, JSPServletFactory jspServletFactory,
		JSPTaglibHelper jspTaglibHelper,
		Dictionary<String, Object> properties) {

		_bundleContext = bundleContext;
		_jspServletFactory = jspServletFactory;
		_jspTaglibHelper = jspTaglibHelper;
		_properties = properties;
	}

	public void close() {
		for (Bundle bundle : _wabBundleProcessors.keySet()) {
			doStop(bundle);
		}
	}

	public ServiceRegistration<PortalProfile> doStart(Bundle bundle) {
		Enumeration<URL> enumeration = bundle.findEntries(
			"/WEB-INF", "liferay-plugin-package.properties", false);

		if ((enumeration == null) || !enumeration.hasMoreElements()) {
			_initWabBundle(bundle);

			return null;
		}

		URL url = enumeration.nextElement();

		Properties properties = new Properties();

		try (InputStream inputStream = url.openStream()) {
			properties.load(inputStream);
		}
		catch (IOException ioException) {
		}

		Set<String> portalProfileNames = SetUtil.fromArray(
			StringUtil.split(
				properties.getProperty("liferay-portal-profile-names")));

		if (portalProfileNames.isEmpty()) {
			_initWabBundle(bundle);

			return null;
		}

		portalProfileNames.add(bundle.getSymbolicName());

		return _bundleContext.registerService(
			PortalProfile.class,
			new WarModuleProfile(bundle, portalProfileNames), null);
	}

	public void doStop(Bundle bundle) {
		WabBundleProcessor wabBundleProcessor = _wabBundleProcessors.remove(
			bundle);

		if (wabBundleProcessor == null) {
			return;
		}

		try {
			wabBundleProcessor.destroy();

			handleCollidedWABs(bundle);
		}
		catch (Exception exception) {
		}
	}

	public boolean isFragmentBundle(Bundle bundle) {
		BundleRevision bundleRevision = bundle.adapt(BundleRevision.class);

		if ((bundleRevision.getTypes() & BundleRevision.TYPE_FRAGMENT) == 0) {
			return false;
		}

		return true;
	}

	protected void handleCollidedWABs(Bundle bundle) {
		String contextPath = WabUtil.getWebContextPath(bundle);

		for (Bundle curBundle : _bundleContext.getBundles()) {
			if (bundle.equals(curBundle) || isFragmentBundle(curBundle) ||
				_wabBundleProcessors.containsKey(curBundle)) {

				continue;
			}

			String curContextPath = WabUtil.getWebContextPath(curBundle);

			if (contextPath.equals(curContextPath)) {
				doStart(curBundle);

				break;
			}
		}
	}

	private void _initWabBundle(Bundle bundle) {
		try {
			WabBundleProcessor newWabBundleProcessor = new WabBundleProcessor(
				bundle, _jspServletFactory, _jspTaglibHelper);

			WabBundleProcessor oldWabBundleProcessor =
				_wabBundleProcessors.putIfAbsent(bundle, newWabBundleProcessor);

			if (oldWabBundleProcessor != null) {
				return;
			}

			newWabBundleProcessor.init(_properties);
		}
		catch (Exception exception) {
		}
	}

	private final BundleContext _bundleContext;
	private final JSPServletFactory _jspServletFactory;
	private final JSPTaglibHelper _jspTaglibHelper;
	private final Dictionary<String, Object> _properties;
	private final ConcurrentMap<Bundle, WabBundleProcessor>
		_wabBundleProcessors = new ConcurrentHashMap<>();

	private class WarModuleProfile implements PortalProfile {

		@Override
		public void activate() {
			_initWabBundle(_bundle);
		}

		@Override
		public Set<String> getPortalProfileNames() {
			return _portalProfileNames;
		}

		private WarModuleProfile(
			Bundle bundle, Set<String> portalProfileNames) {

			_bundle = bundle;
			_portalProfileNames = portalProfileNames;
		}

		private final Bundle _bundle;
		private final Set<String> _portalProfileNames;

	}

}