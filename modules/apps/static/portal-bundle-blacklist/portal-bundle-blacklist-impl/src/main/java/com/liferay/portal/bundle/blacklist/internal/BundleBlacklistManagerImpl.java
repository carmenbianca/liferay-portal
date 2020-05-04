/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.bundle.blacklist.internal;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.bundle.blacklist.BundleBlacklistManager;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.IOException;

import java.util.Collection;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.function.Function;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Preston Crary
 */
@Component(immediate = true, service = BundleBlacklistManager.class)
public class BundleBlacklistManagerImpl implements BundleBlacklistManager {

	@Override
	public void addToBlacklistAndUninstall(String... bundleSymbolicNames)
		throws IOException {

		_updateProperties(
			blacklistBundleSymbolicNames -> {
				if (blacklistBundleSymbolicNames == null) {
					return bundleSymbolicNames;
				}

				Set<String> blacklistBundleSymbolicNamesSet = SetUtil.fromArray(
					blacklistBundleSymbolicNames);

				Collections.addAll(
					blacklistBundleSymbolicNamesSet, bundleSymbolicNames);

				return blacklistBundleSymbolicNamesSet.toArray(new String[0]);
			});
	}

	@Override
	public Collection<String> getBlacklistBundleSymbolicNames() {
		return _bundleBlacklist.getBlacklistBundleSymbolicNames();
	}

	@Override
	public void removeFromBlacklistAndInstall(String... bundleSymbolicNames)
		throws IOException {

		_updateProperties(
			blacklistBundleSymbolicNames -> {
				if (blacklistBundleSymbolicNames == null) {
					return null;
				}

				Set<String> blacklistBundleSymbolicNamesSet = SetUtil.fromArray(
					blacklistBundleSymbolicNames);

				for (String bundleSymbolicName : bundleSymbolicNames) {
					blacklistBundleSymbolicNamesSet.remove(bundleSymbolicName);
				}

				return blacklistBundleSymbolicNamesSet.toArray(new String[0]);
			});
	}

	private void _updateConfiguration(
			Configuration configuration, Dictionary<String, Object> properties)
		throws IOException {

		Bundle bundle = FrameworkUtil.getBundle(BundleBlacklistManager.class);

		BundleContext bundleContext = bundle.getBundleContext();

		CountDownLatch countDownLatch = new CountDownLatch(1);

		ServiceListener serviceListener = new ServiceListener() {

			@Override
			public void serviceChanged(ServiceEvent serviceEvent) {
				if (serviceEvent.getType() != ServiceEvent.MODIFIED) {
					return;
				}

				ServiceReference<?> serviceReference =
					serviceEvent.getServiceReference();

				Object service = bundleContext.getService(serviceReference);

				if (_bundleBlacklist == service) {
					countDownLatch.countDown();
				}

				bundleContext.ungetService(serviceReference);
			}

		};

		bundleContext.addServiceListener(serviceListener);

		try {
			configuration.update(properties);

			countDownLatch.await();
		}
		catch (InterruptedException interruptedException) {
		}
		finally {
			bundleContext.removeServiceListener(serviceListener);
		}
	}

	private void _updateProperties(Function<String[], String[]> updateFunction)
		throws IOException {

		Configuration configuration = _configurationAdmin.getConfiguration(
			BundleBlacklistConfiguration.class.getName(), StringPool.QUESTION);

		Dictionary<String, Object> properties = configuration.getProperties();

		String[] blacklistBundleSymbolicNames = null;

		if (properties == null) {
			properties = new HashMapDictionary<>();
		}
		else {
			String value = (String)properties.get(
				"blacklistBundleSymbolicNames");

			blacklistBundleSymbolicNames = StringUtil.split(value);
		}

		blacklistBundleSymbolicNames = updateFunction.apply(
			blacklistBundleSymbolicNames);

		if (blacklistBundleSymbolicNames == null) {
			return;
		}

		if (blacklistBundleSymbolicNames.length == 0) {
			properties.remove("blacklistBundleSymbolicNames");
		}
		else {
			properties.put(
				"blacklistBundleSymbolicNames",
				StringUtil.merge(blacklistBundleSymbolicNames));
		}

		_updateConfiguration(configuration, properties);
	}

	@Reference
	private BundleBlacklist _bundleBlacklist;

	@Reference
	private ConfigurationAdmin _configurationAdmin;

}