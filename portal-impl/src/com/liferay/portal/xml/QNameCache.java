/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.xml;

import com.liferay.petra.concurrent.ConcurrentReferenceKeyHashMap;
import com.liferay.petra.memory.FinalizeManager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.dom4j.DocumentFactory;
import org.dom4j.QName;

/**
 * @author Jorge Díaz
 */
public class QNameCache extends org.dom4j.tree.QNameCache {

	public QNameCache(DocumentFactory documentFactory) {
		super(documentFactory);

		namespaceCache = new ConcurrentReferenceKeyHashMap<>(
			FinalizeManager.WEAK_REFERENCE_FACTORY);
		noNamespaceCache = new ConcurrentReferenceKeyHashMap<>(
			FinalizeManager.WEAK_REFERENCE_FACTORY);
	}

	@Override
	protected Map<String, QName> createMap() {
		return new ConcurrentHashMap<>();
	}

}