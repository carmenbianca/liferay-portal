/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.web.internal.processor;

import com.liferay.adaptive.media.processor.AMAsyncProcessor;
import com.liferay.adaptive.media.processor.AMAsyncProcessorLocator;
import com.liferay.portal.kernel.messaging.MessageBus;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Adolfo Pérez
 */
@Component(immediate = true, service = AMAsyncProcessorLocator.class)
public class AMAsyncProcessorLocatorImpl implements AMAsyncProcessorLocator {

	@Override
	public <M> AMAsyncProcessor<M, ?> locateForClass(Class<M> clazz) {
		return new AMAsyncProcessorImpl<>(clazz, _messageBus);
	}

	@Reference
	private MessageBus _messageBus;

}