/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.data.engine.internal.expando.util;

import com.liferay.data.engine.internal.expando.model.DataEngineExpandoBridgeImpl;
import com.liferay.data.engine.nativeobject.DataEngineNativeObject;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactory;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * @author Jeyvison Nascimento
 */
@Component(immediate = true, service = ExpandoBridgeFactory.class)
public class DataEngineExpandoBridgeFactoryImpl
	implements ExpandoBridgeFactory {

	@Override
	public ExpandoBridge getExpandoBridge(long companyId, String className) {
		if (_dataEngineNativeObjectClassNames.containsKey(className)) {
			try {
				return new DataEngineExpandoBridgeImpl(
					className, 0, companyId, _groupLocalService);
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		}

		return new ExpandoBridgeImpl(companyId, className);
	}

	@Override
	public ExpandoBridge getExpandoBridge(
		long companyId, String className, long classPK) {

		if (_dataEngineNativeObjectClassNames.containsKey(className)) {
			try {
				return new DataEngineExpandoBridgeImpl(
					className, classPK, companyId, _groupLocalService);
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		}

		return new ExpandoBridgeImpl(companyId, className, classPK);
	}

	@Reference(
		cardinality = ReferenceCardinality.MULTIPLE,
		policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY
	)
	protected void addDataEngineNativeObject(
		DataEngineNativeObject dataEngineNativeObject) {

		_dataEngineNativeObjectClassNames.put(
			dataEngineNativeObject.getClassName(),
			dataEngineNativeObject.getClassName());
	}

	protected void removeDataEngineNativeObject(
		DataEngineNativeObject dataEngineNativeObject) {

		_dataEngineNativeObjectClassNames.remove(
			dataEngineNativeObject.getClassName());
	}

	private final Map<String, String> _dataEngineNativeObjectClassNames =
		new ConcurrentHashMap<>();

	@Reference
	private GroupLocalService _groupLocalService;

}