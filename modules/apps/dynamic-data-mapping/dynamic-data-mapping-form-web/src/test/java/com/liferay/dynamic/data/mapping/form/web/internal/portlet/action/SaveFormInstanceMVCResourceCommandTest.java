/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.web.internal.portlet.action;

import com.liferay.portal.kernel.util.LocaleUtil;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Rafael Praxedes
 */
public class SaveFormInstanceMVCResourceCommandTest {

	@Before
	public void setUp() throws Exception {
		setUpSaveFormInstanceMVCResourceCommand();
	}

	@Test
	public void testFormatDate() {
		Calendar calendar = Calendar.getInstance();

		calendar.set(Calendar.YEAR, 2018);
		calendar.set(Calendar.MONTH, 3);
		calendar.set(Calendar.DAY_OF_MONTH, 18);
		calendar.set(Calendar.HOUR_OF_DAY, 14);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		Date date = calendar.getTime();

		Assert.assertEquals(
			"Apr 18, 2018 2:00 PM",
			_saveFormInstanceMVCResourceCommand.formatDate(
				date, LocaleUtil.US, "UTC"));

		Assert.assertEquals(
			"Apr 18, 2018 11:00 AM",
			_saveFormInstanceMVCResourceCommand.formatDate(
				date, LocaleUtil.US, "America/Sao_Paulo"));
	}

	protected void setUpSaveFormInstanceMVCResourceCommand() throws Exception {
		_saveFormInstanceMVCResourceCommand =
			new SaveFormInstanceMVCResourceCommand();
	}

	private SaveFormInstanceMVCResourceCommand
		_saveFormInstanceMVCResourceCommand;

}