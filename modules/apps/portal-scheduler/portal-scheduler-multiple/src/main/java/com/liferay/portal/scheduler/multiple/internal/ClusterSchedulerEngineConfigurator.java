/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.scheduler.multiple.internal;

import com.liferay.portal.kernel.cluster.ClusterExecutor;
import com.liferay.portal.kernel.cluster.ClusterLink;
import com.liferay.portal.kernel.cluster.ClusterMasterExecutor;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.scheduler.SchedulerEngine;
import com.liferay.portal.kernel.scheduler.TriggerFactory;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.util.Props;

import java.util.Dictionary;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Tina Tian
 */
@Component(immediate = true, service = ClusterSchedulerEngineConfigurator.class)
public class ClusterSchedulerEngineConfigurator {

	@Activate
	protected void activate(BundleContext bundleContext) {
		if (_clusterLink.isEnabled()) {
			ClusterSchedulerEngine clusterSchedulerEngine =
				new ClusterSchedulerEngine(_schedulerEngine, _triggerFactory);

			clusterSchedulerEngine.setClusterExecutor(_clusterExecutor);
			clusterSchedulerEngine.setClusterMasterExecutor(
				_clusterMasterExecutor);
			clusterSchedulerEngine.setProps(_props);

			_serviceRegistration = bundleContext.registerService(
				IdentifiableOSGiService.class, clusterSchedulerEngine,
				new HashMapDictionary<String, Object>());

			_schedulerEngine = ClusterableProxyFactory.createClusterableProxy(
				clusterSchedulerEngine);
		}

		Dictionary<String, Object> schedulerEngineDictionary =
			new HashMapDictionary<>();

		schedulerEngineDictionary.put("scheduler.engine.proxy", Boolean.TRUE);

		_schedulerEngineServiceRegistration = bundleContext.registerService(
			SchedulerEngine.class, _schedulerEngine, schedulerEngineDictionary);
	}

	@Deactivate
	protected void deactivate() {
		if (_serviceRegistration != null) {
			_serviceRegistration.unregister();
		}

		if (_schedulerEngineServiceRegistration != null) {
			_schedulerEngineServiceRegistration.unregister();
		}
	}

	@Reference(unbind = "-")
	protected void setClusterExecutor(ClusterExecutor clusterExecutor) {
		_clusterExecutor = clusterExecutor;
	}

	@Reference(unbind = "-")
	protected void setClusterLink(ClusterLink clusterLink) {
		_clusterLink = clusterLink;
	}

	@Reference(unbind = "-")
	protected void setClusterMasterExecutor(
		ClusterMasterExecutor clusterMasterExecutor) {

		_clusterMasterExecutor = clusterMasterExecutor;
	}

	@Reference(unbind = "-")
	protected void setProps(Props props) {
		_props = props;
	}

	@Reference(target = "(scheduler.engine.proxy.bean=true)", unbind = "-")
	protected void setSchedulerEngine(SchedulerEngine schedulerEngine) {
		_schedulerEngine = schedulerEngine;
	}

	@Reference(unbind = "-")
	protected void TriggerFactory(TriggerFactory triggerFactory) {
		_triggerFactory = triggerFactory;
	}

	private ClusterExecutor _clusterExecutor;
	private ClusterLink _clusterLink;
	private ClusterMasterExecutor _clusterMasterExecutor;
	private Props _props;
	private SchedulerEngine _schedulerEngine;
	private volatile ServiceRegistration<SchedulerEngine>
		_schedulerEngineServiceRegistration;
	private ServiceRegistration<IdentifiableOSGiService> _serviceRegistration;
	private TriggerFactory _triggerFactory;

}