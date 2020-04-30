/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.util;

import com.liferay.portal.kernel.templateparser.TransformerListener;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Pavel Savinov
 */
@ProviderType
public interface JournalTransformerListenerRegistry {

	public TransformerListener getTransformerListener(String className);

	public List<TransformerListener> getTransformerListeners();

}