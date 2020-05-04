/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.internal.model.listener;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.staging.model.listener.StagingModelListener;
import com.liferay.wiki.model.WikiNode;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Akos Thurzo
 */
@Component(immediate = true, service = ModelListener.class)
public class WikiNodeStagingModelListener extends BaseModelListener<WikiNode> {

	@Override
	public void onAfterCreate(WikiNode wikiNode) throws ModelListenerException {
		_stagingModelListener.onAfterCreate(wikiNode);
	}

	@Override
	public void onAfterRemove(WikiNode wikiNode) throws ModelListenerException {
		_stagingModelListener.onAfterRemove(wikiNode);
	}

	@Override
	public void onAfterUpdate(WikiNode wikiNode) throws ModelListenerException {
		_stagingModelListener.onAfterUpdate(wikiNode);
	}

	@Reference
	private StagingModelListener<WikiNode> _stagingModelListener;

}