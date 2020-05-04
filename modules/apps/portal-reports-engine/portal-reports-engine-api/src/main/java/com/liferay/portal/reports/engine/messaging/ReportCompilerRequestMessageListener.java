/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.reports.engine.messaging;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.reports.engine.ReportDesignRetriever;
import com.liferay.portal.reports.engine.ReportEngine;
import com.liferay.portal.reports.engine.ReportGenerationException;
import com.liferay.portal.reports.engine.ReportRequest;
import com.liferay.portal.reports.engine.ReportResultContainer;

/**
 * @author Michael C. Han
 */
public class ReportCompilerRequestMessageListener extends BaseMessageListener {

	public ReportCompilerRequestMessageListener() {
	}

	public ReportCompilerRequestMessageListener(
		ReportEngine reportEngine,
		ReportResultContainer reportResultContainer) {

		_reportEngine = reportEngine;
		_reportResultContainer = reportResultContainer;
	}

	public void setReportEngine(ReportEngine reportEngine) {
		_reportEngine = reportEngine;
	}

	public void setReportResultContainer(
		ReportResultContainer reportResultContainer) {

		_reportResultContainer = reportResultContainer;
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		ReportRequest reportRequest = (ReportRequest)message.getPayload();

		ReportDesignRetriever reportDesignRetriever =
			reportRequest.getReportDesignRetriever();

		ReportResultContainer reportResultContainer =
			_reportResultContainer.clone(reportDesignRetriever.getReportName());

		try {
			_reportEngine.compile(reportRequest);
		}
		catch (ReportGenerationException reportGenerationException) {
			_log.error("Unable to compile report", reportGenerationException);

			reportResultContainer.setReportGenerationException(
				reportGenerationException);
		}
		finally {
			Message responseMessage = MessageBusUtil.createResponseMessage(
				message, reportResultContainer);

			responseMessage.setPayload(reportResultContainer);

			MessageBusUtil.sendMessage(
				responseMessage.getDestinationName(), responseMessage);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		ReportCompilerRequestMessageListener.class);

	private ReportEngine _reportEngine;
	private ReportResultContainer _reportResultContainer;

}