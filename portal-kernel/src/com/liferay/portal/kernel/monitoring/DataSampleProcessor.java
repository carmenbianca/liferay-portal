/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.monitoring;

/**
 * @author Michael C. Han
 * @author Brian Wing Shun Chan
 */
public interface DataSampleProcessor<T extends DataSample> {

	public void processDataSample(T dataSample) throws MonitoringException;

}