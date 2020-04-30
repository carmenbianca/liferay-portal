/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.sidecar;

import com.liferay.petra.process.ProcessCallable;

import java.io.Serializable;

/**
 * @author Tina Tian
 */
public class StopSidecarProcessCallable
	implements ProcessCallable<Serializable> {

	@Override
	public Serializable call() {
		ElasticsearchServerUtil.shutdown();

		return null;
	}

	private static final long serialVersionUID = 1L;

}