/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.connection;

import com.liferay.petra.process.ProcessExecutor;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.cluster.ClusterExecutor;
import com.liferay.portal.kernel.cluster.ClusterMasterExecutor;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.Props;
import com.liferay.portal.kernel.util.ProxyFactory;
import com.liferay.portal.search.elasticsearch7.configuration.ElasticsearchConfiguration;
import com.liferay.portal.search.elasticsearch7.internal.sidecar.ClusterableSidecar;
import com.liferay.portal.search.elasticsearch7.internal.sidecar.Sidecar;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Tina Tian
 */
@Component(
	configurationPid = "com.liferay.portal.search.elasticsearch7.configuration.ElasticsearchConfiguration",
	enabled = false, immediate = true, service = {}
)
public class SidecarElasticsearchConnectionManager {

	@Activate
	protected void activate(ComponentContext componentContext) {
		BundleContext bundleContext = componentContext.getBundleContext();

		ElasticsearchConfiguration elasticsearchConfiguration =
			ConfigurableUtil.createConfigurable(
				ElasticsearchConfiguration.class,
				componentContext.getProperties());

		ElasticsearchConnection elasticsearchConnection;

		if (elasticsearchConfiguration.operationMode() ==
				com.liferay.portal.search.elasticsearch7.configuration.
					OperationMode.EMBEDDED) {

			if (_log.isWarnEnabled()) {
				StringBundler sb = new StringBundler(8);

				sb.append("Liferay is configured to use Elasticsearch engine ");
				sb.append("running in a child process of current process ");
				sb.append("named as sidecar. Do NOT use sidecar in ");
				sb.append("production. Sidecar is useful for development and ");
				sb.append("demonstration purposes. Refer to the ");
				sb.append("documentation for details on the limitations of ");
				sb.append("sidecar. Remote Elasticsearch connections can be ");
				sb.append("configured in the Control Panel.");

				_log.warn(sb.toString());
			}

			if (_clusterExecutor.isEnabled()) {
				ClusterableSidecar clusterableSidecar = new ClusterableSidecar(
					_clusterExecutor, _clusterMasterExecutor,
					elasticsearchConfiguration, _jsonFactory, _processExecutor,
					_props);

				_clusterableSidecarsOSGiServiceserviceRegistration =
					bundleContext.registerService(
						new String[] {
							ClusterableSidecar.class.getName(),
							IdentifiableOSGiService.class.getName()
						},
						clusterableSidecar, null);

				elasticsearchConnection = new SidecarElasticsearchConnection(
					clusterableSidecar);
			}
			else {
				elasticsearchConnection = new SidecarElasticsearchConnection(
					new Sidecar(
						elasticsearchConfiguration, _processExecutor, _props));
			}
		}
		else {
			elasticsearchConnection = ProxyFactory.newDummyInstance(
				ElasticsearchConnection.class);
		}

		_serviceRegistration = bundleContext.registerService(
			ElasticsearchConnection.class, elasticsearchConnection,
			MapUtil.singletonDictionary(
				"operation.mode", String.valueOf(OperationMode.EMBEDDED)));
	}

	@Deactivate
	protected void deactivate() {
		_serviceRegistration.unregister();

		if (_clusterableSidecarsOSGiServiceserviceRegistration != null) {
			_clusterableSidecarsOSGiServiceserviceRegistration.unregister();
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		SidecarElasticsearchConnectionManager.class);

	private ServiceRegistration<?>
		_clusterableSidecarsOSGiServiceserviceRegistration;

	@Reference
	private ClusterExecutor _clusterExecutor;

	@Reference
	private ClusterMasterExecutor _clusterMasterExecutor;

	@Reference
	private JSONFactory _jsonFactory;

	@Reference
	private ProcessExecutor _processExecutor;

	@Reference
	private Props _props;

	private ServiceRegistration<ElasticsearchConnection> _serviceRegistration;

}