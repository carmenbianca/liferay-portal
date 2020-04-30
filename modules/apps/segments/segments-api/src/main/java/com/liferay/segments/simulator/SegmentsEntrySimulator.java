/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.simulator;

/**
 * Provides methods to simulate the membership of an entity to a {@link
 * com.liferay.segments.model.SegmentsEntry SegmentsEntry}.
 *
 * @author Eduardo García
 */
public interface SegmentsEntrySimulator {

	public void deactivateSimulation(long classPK);

	public long[] getSimulatedSegmentsEntryIds(long classPK);

	public boolean isSimulationActive(long classPK);

	public void setSimulatedSegmentsEntryIds(
		long classPK, long[] segmentsEntryIds);

}