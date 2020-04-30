/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.internal.model.listener;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.segments.model.SegmentsEntry;
import com.liferay.staging.model.listener.StagingModelListener;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eduardo García
 */
@Component(immediate = true, service = ModelListener.class)
public class SegmentsEntryStagingModelListener
	extends BaseModelListener<SegmentsEntry> {

	@Override
	public void onAfterCreate(SegmentsEntry segmentsEntry)
		throws ModelListenerException {

		_stagingModelListener.onAfterCreate(segmentsEntry);
	}

	@Override
	public void onAfterRemove(SegmentsEntry segmentsEntry)
		throws ModelListenerException {

		_stagingModelListener.onAfterRemove(segmentsEntry);
	}

	@Override
	public void onAfterUpdate(SegmentsEntry segmentsEntry)
		throws ModelListenerException {

		_stagingModelListener.onAfterUpdate(segmentsEntry);
	}

	@Reference
	private StagingModelListener<SegmentsEntry> _stagingModelListener;

}