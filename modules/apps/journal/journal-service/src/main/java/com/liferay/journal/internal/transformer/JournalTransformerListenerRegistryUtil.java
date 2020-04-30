/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.internal.transformer;

import com.liferay.journal.util.JournalTransformerListenerRegistry;
import com.liferay.osgi.util.ServiceTrackerFactory;
import com.liferay.portal.kernel.templateparser.TransformerListener;

import java.util.List;

import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * @author Pavel Savinov
 */
public class JournalTransformerListenerRegistryUtil {

	public static TransformerListener getTransformerListener(String className) {
		JournalTransformerListenerRegistry journalTransformerListenerRegistry =
			_serviceTracker.getService();

		return journalTransformerListenerRegistry.getTransformerListener(
			className);
	}

	public static List<TransformerListener> getTransformerListeners() {
		JournalTransformerListenerRegistry journalTransformerListenerRegistry =
			_serviceTracker.getService();

		return journalTransformerListenerRegistry.getTransformerListeners();
	}

	private static final ServiceTracker<?, JournalTransformerListenerRegistry>
		_serviceTracker = ServiceTrackerFactory.open(
			FrameworkUtil.getBundle(
				JournalTransformerListenerRegistryUtil.class),
			JournalTransformerListenerRegistry.class);

}