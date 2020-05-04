/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.bundle.blacklist.internal;

import com.liferay.osgi.util.bundle.BundleStartLevelUtil;
import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.portal.lpkg.deployer.LPKGDeployer;

import java.util.Map;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.BundleListener;
import org.osgi.framework.wiring.FrameworkWiring;

/**
 * @author Matthew Tambara
 */
public class SelfMonitorBundleListener implements BundleListener {

	public SelfMonitorBundleListener(
		Bundle bundle, BundleContext systemBundleContext,
		FrameworkWiring frameworkWiring, LPKGDeployer lpkgDeployer,
		Map<String, UninstalledBundleData> uninstalledBundles) {

		_bundle = bundle;
		_systemBundleContext = systemBundleContext;
		_frameworkWiring = frameworkWiring;
		_lpkgDeployer = lpkgDeployer;
		_uninstalledBundles = uninstalledBundles;
	}

	@Override
	public void bundleChanged(BundleEvent bundleEvent) {
		Bundle bundle = bundleEvent.getBundle();

		if (!bundle.equals(_bundle)) {
			return;
		}

		if (bundleEvent.getType() == BundleEvent.STARTED) {

			// In case of STARTED, that means the blacklist bundle was updated
			// or refreshed, we must unregister the self monitor listener to
			// release the previous bundle revision

			_systemBundleContext.removeBundleListener(this);

			return;
		}

		if (bundleEvent.getType() != BundleEvent.UNINSTALLED) {
			return;
		}

		for (UninstalledBundleData uninstalledBundleData :
				_uninstalledBundles.values()) {

			try {
				BundleUtil.reinstallBundle(
					_frameworkWiring, uninstalledBundleData,
					_systemBundleContext, _lpkgDeployer);
			}
			catch (Throwable t) {
				ReflectionUtil.throwException(t);
			}
		}

		_systemBundleContext.removeBundleListener(this);
	}

	private final Bundle _bundle;
	private final FrameworkWiring _frameworkWiring;
	private final LPKGDeployer _lpkgDeployer;
	private final BundleContext _systemBundleContext;
	private final Map<String, UninstalledBundleData> _uninstalledBundles;

	static {
		ClassLoader classLoader =
			SelfMonitorBundleListener.class.getClassLoader();

		try {
			classLoader.loadClass(BundleStartLevelUtil.class.getName());
			classLoader.loadClass(BundleUtil.class.getName());
			classLoader.loadClass(ParamUtil.class.getName());
			classLoader.loadClass(WebBundleInstaller.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}