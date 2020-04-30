/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.cluster;

/**
 * @author André de Oliveira
 */
public interface ReplicasManager {

	public void updateNumberOfReplicas(int numberOfReplicas, String... indices);

}