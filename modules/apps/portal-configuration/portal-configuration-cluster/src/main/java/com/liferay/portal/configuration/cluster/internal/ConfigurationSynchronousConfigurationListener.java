/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.configuration.cluster.internal;

import com.liferay.portal.configuration.cluster.internal.constants.ConfigurationClusterDestinationNames;
import com.liferay.portal.kernel.cluster.ClusterLink;
import com.liferay.portal.kernel.cluster.Priority;
import com.liferay.portal.kernel.messaging.Destination;
import com.liferay.portal.kernel.messaging.Message;

import org.osgi.framework.Constants;
import org.osgi.service.cm.ConfigurationEvent;
import org.osgi.service.cm.SynchronousConfigurationListener;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Raymond Augé
 */
@Component(
	enabled = false, immediate = true,
	service = SynchronousConfigurationListener.class
)
public class ConfigurationSynchronousConfigurationListener
	implements SynchronousConfigurationListener {

	@Override
	public void configurationEvent(ConfigurationEvent configurationEvent) {
		if (ConfigurationThreadLocal.isLocalUpdate()) {
			return;
		}

		Message message = new Message();

		message.setDestinationName(
			ConfigurationClusterDestinationNames.CONFIGURATION);

		message.put(Constants.SERVICE_PID, configurationEvent.getPid());

		message.put("configuration.event.type", configurationEvent.getType());

		_clusterLink.sendMulticastMessage(message, Priority.LEVEL10);
	}

	@Reference(unbind = "-")
	protected void setClusterLink(ClusterLink clusterLink) {
		_clusterLink = clusterLink;
	}

	@Reference(
		target = "(destination.name=" + ConfigurationClusterDestinationNames.CONFIGURATION + ")",
		unbind = "-"
	)
	protected void setDestination(Destination destination) {
	}

	private ClusterLink _clusterLink;

}