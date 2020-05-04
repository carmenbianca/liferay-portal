/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.internal.transformer;

import com.liferay.journal.constants.JournalPortletKeys;
import com.liferay.journal.util.JournalTransformerListenerRegistry;
import com.liferay.portal.kernel.templateparser.TransformerListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

/**
 * @author Pavel Savinov
 */
@Component(immediate = true, service = JournalTransformerListenerRegistry.class)
public class DefaultJournalTransformerListenerRegistryImpl
	implements JournalTransformerListenerRegistry {

	@Override
	public TransformerListener getTransformerListener(String className) {
		return _transformerListeners.get(className);
	}

	@Override
	public List<TransformerListener> getTransformerListeners() {
		return new ArrayList(_transformerListeners.values());
	}

	@Reference(
		cardinality = ReferenceCardinality.MULTIPLE,
		policy = ReferencePolicy.DYNAMIC,
		target = "(javax.portlet.name=" + JournalPortletKeys.JOURNAL + ")"
	)
	public void registerTransformerListener(
		TransformerListener transformerListener) {

		Class<?> clazz = transformerListener.getClass();

		_transformerListeners.put(clazz.getName(), transformerListener);
	}

	public void unregisterTransformerListener(
		TransformerListener transformerListener) {

		Class<?> clazz = transformerListener.getClass();

		_transformerListeners.remove(clazz.getName());
	}

	private final Map<String, TransformerListener> _transformerListeners =
		new ConcurrentHashMap<>();

}